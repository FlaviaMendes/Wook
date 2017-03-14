package pt.wook.TestesFuncionais.paginas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginaBase {
	
	protected final String URL_SITE = "https://www.wook.pt/";
	protected static WebDriver navegador;
	
	PaginaBase(){// método construtor
		
		System.setProperty("webdriver.chrome.driver", "C:\\EstudoFlavia\\chromedriver.exe");
		if (navegador == null){
			System.out.println("Abrindo navegador.");
			navegador = new ChromeDriver();
		}
		
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void limparTodosCookies(){
		
		navegador.manage().deleteAllCookies();
		
	}

	public static void fecharNavegador() {

		navegador.close();
		
	}

}
