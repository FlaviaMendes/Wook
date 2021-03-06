package pt.wook.TestesFuncionais.cenarios;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesBusca {

	private static String urlDoSite;
	private static WebDriver navegador;

	@BeforeClass
	public static void antesDeTodosOsTestes() {
		System.setProperty("webdriver.chrome.driver", "C:\\EstudoFlavia\\chromedriver.exe");
		urlDoSite = "https://www.wook.pt/";
		
		navegador = new ChromeDriver(); // abre o navegador sem nada
		navegador.manage().window().maximize(); // maximiza a janela
	
	}
	
	@Before
	public void antesDeCadaTeste() {
		
		navegador.get(urlDoSite);// abre o site
		
	}
	
	@Test
	public void PesquisarLivroExistente() throws InterruptedException{
		String nomeLivro = "SOS Ansiedade";
		
		WebElement boxBuscar = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]"));
		boxBuscar.click();
		
		WebElement caixaDeBusca = navegador.findElement(By.id("form-searchform-palavra"));
		caixaDeBusca.sendKeys(nomeLivro);// preenche uma caisa de tx
		
		Thread.sleep(1000);
		
		WebElement botaoBuscar = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]/button[1]")); // qdo não tem id ou name
		botaoBuscar.click();
		
		
		WebElement mensagemResultadoBusca = navegador.findElement(By.xpath("//*[@id=\"search-page\"]/div[1]/h1"));
		String mensagemExibida = mensagemResultadoBusca.getText();
		String mensagemEsperada = "2 RESULTADOS PARA \"SOS ANSIEDADE\"";
		assertEquals(mensagemEsperada, mensagemExibida);
		
		int numeroExibido = Integer.parseInt(mensagemExibida.split(" ")[0]);
		// String[] mensagemQuebrada = mensagemExibida.split(" ");
		// String numeroExibidoEmTexto = mensagemQuebrada[0];
		// int numeroExibido = Integer.parseInt(numeroExibidoEmTexto);		
		assertThat(numeroExibido, greaterThanOrEqualTo(1));
		
		WebElement livroExibido = navegador.findElement(By.xpath("//*[@id=\"search-page\"]/div[3]/div[1]/div[2]/div[1]/a"));
		assertTrue(livroExibido.isDisplayed());
		

	}
	
	
	@Test
	public void PesquisarLivroPorAutor() throws InterruptedException{
		
		String nomeAutor = "NICHOLAS SPARKS";
				
		WebElement boxBuscar = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]"));
		boxBuscar.click();
		
		WebElement caixaDeBusca = navegador.findElement(By.id("form-searchform-palavra"));
		caixaDeBusca.sendKeys(nomeAutor);
		
		Thread.sleep(1000);
		
		WebElement botaoBuscar = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]/button[1]"));
		botaoBuscar.click();
		
		WebElement mensagemResultadoBusca = navegador.findElement(By.xpath("//*[@id=\"search-page\"]/div[1]/h1"));
		String mensagemExibida = mensagemResultadoBusca.getText();
		String mensagemEsperada = "201 RESULTADOS PARA \"NICHOLAS SPARKS\"";
		assertEquals(mensagemEsperada, mensagemExibida);
		
		int numeroExibido = Integer.parseInt(mensagemExibida.split(" ")[0]);
		assertThat(numeroExibido, greaterThanOrEqualTo(1));
		
		WebElement nomeDoAutorExibido = navegador.findElement(By.xpath("//*[@id=\"search-page\"]/div[3]/div[1]/div[2]/div[3]/a"));
		assertTrue(nomeDoAutorExibido.isDisplayed());
		
		
	}
	
	@Test
	@Ignore
	public void PesquisarLivroPorEditor() throws InterruptedException{
		
		String nomeEditor = "Editorial Presença";
				
		WebElement boxBusca = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]"));
		boxBusca.click();
		
		WebElement caixaDeBusca = navegador.findElement(By.id("form-searchform-palavra"));
		caixaDeBusca.sendKeys(nomeEditor);
		
		Thread.sleep(1000);
		
		WebElement botaoBuscar = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]/button[1]"));
		botaoBuscar.click();
		
		WebElement mensagemResultadoBusca = navegador.findElement(By.xpath("//*[@id=\"search-page\"]/div[1]/h1"));
		String mensagemExibida = mensagemResultadoBusca.getText();
		System.out.println("Mensagem Exibida: " + mensagemExibida);
		String mensagemEsperado = "4125 RESULTADOS PARA \"EDITORIAL PRESENÇA\"";
		assertThat(mensagemEsperado, Matchers.matchesPattern("[0-9]* RESULTADOS PARA \"EDITORIAL PRESENÇA\""));
		
		int numeroExibido = Integer.parseInt(mensagemExibida.split(" ")[0]);
		assertThat(numeroExibido, greaterThanOrEqualTo(1));
		
		// nao tem como confirmar na página o editor.
		
	}
	
	@Test
	
	public void PesquisarLivroInexistente() throws InterruptedException{
		
		String nomeLivroInexistente = "ASDFGHJKLÇ";
				
		WebElement boxBusca = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]"));
		boxBusca.click();
		
		WebElement caixaBusca = navegador.findElement(By.id("form-searchform-palavra"));
		caixaBusca.sendKeys(nomeLivroInexistente);
		
		Thread.sleep(1000);
		
		WebElement botaoBusca = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]/button[1]"));
		botaoBusca.click();
		
		WebElement mensagemResultadoBusca = navegador.findElement(By.xpath("//*[@id=\"search-page\"]/div[1]/h1"));
		String mensagemExibida = mensagemResultadoBusca.getText();
		String mensagemEsperada = "SEM RESULTADOS PARA \"ASDFGHJKLÇ\"";
		assertEquals(mensagemEsperada, mensagemExibida);
		
		WebElement mensagemBuscaSugerida = navegador.findElement(By.xpath("//*[@id=\"search-page\"]/div[2]/h1"));
		String mensagemSugeridaExibida = mensagemBuscaSugerida.getText();
		String mensagemSugeridaEsperada = "1 RESULTADOS PARA \"ISTEVE\"";
		assertEquals(mensagemSugeridaEsperada, mensagemSugeridaExibida);
		
		int numeroExibido = Integer.parseInt(mensagemSugeridaExibida.split(" ")[0]);
		assertThat(numeroExibido, greaterThanOrEqualTo(1));
		
		WebElement nomeSugerido = navegador.findElement(By.xpath("//*[@id=\"search-page\"]/div[5]/div/div[2]/div[1]/a"));
		assertTrue (nomeSugerido.isDisplayed());
		
	} 
	
	@AfterClass
	public static void depoisDeTodosOsTestes(){
		
		navegador.close();
		
	}
	
	
	
}