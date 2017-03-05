package pt.wook.TestesFuncionais;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesBusca {

	@Test
	
	public void PesquisarLivroExistente(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\EstudoFlavia\\chromedriver.exe");
		
		String nomeLivro = "SOS Ansiedade";
		boolean exibiuLivro = true;
		String urlDoSite = "https://www.wook.pt/";
		
		WebDriver navegador = new ChromeDriver(); // abre o navegador sem nada
		navegador.manage().window().maximize();
		navegador.get(urlDoSite);// abre o site
		
		
		WebElement boxBuscar = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]"));
		boxBuscar.click();
		
		WebElement caixaDeBusca = navegador.findElement(By.id("form-searchform-palavra"));
		caixaDeBusca.sendKeys(nomeLivro);
		
		WebElement botaoBuscar = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/div[2]/div[1]/button[1]"));
		botaoBuscar.click();
		
		
		assertTrue(exibiuLivro);
		
		
	}
}
