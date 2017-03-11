package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginaBase {
	
	protected final String URL_SITE = "https://www.wook.pt/";
	protected static WebDriver navegador;
	
	PaginaBase(){// método construtor
		
		System.setProperty("webdriver.chrome.driver", "C:\\EstudoFlavia\\chromedriver.exe");
		if (this.navegador == null){
			System.out.println("Abrindo navegador.");
			this.navegador = new ChromeDriver();
		}
	}

}
