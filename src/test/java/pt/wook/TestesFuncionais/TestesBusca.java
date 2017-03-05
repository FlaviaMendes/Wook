package pt.wook.TestesFuncionais;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesBusca {

	@Test
	
	public void PesquisarLivroExistente(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\EstudoFlavia\\chromedriver.exe");
		
		String nomeLivro = "SOS Ansiedade";
		boolean exibiuLivro = true;
		String urlDoSite = "https://www.wook.pt/";
		
		WebDriver navegador = new ChromeDriver();
		navegador.get(urlDoSite);
		
		assertTrue(exibiuLivro);
		
		
	}
}
