package pt.wook.TestesFuncionais;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesBusca {

	@Test
	
	public void PesquisarLivroExistente() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\EstudoFlavia\\chromedriver.exe");
		
		String nomeLivro = "SOS Ansiedade";
		String urlDoSite = "https://www.wook.pt/";
		
		WebDriver navegador = new ChromeDriver(); // abre o navegador sem nada
		navegador.manage().window().maximize(); // maximiza a janela
		navegador.get(urlDoSite);// abre o site
		
		
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
		
		navegador.close();

				
		
		
	}
}
