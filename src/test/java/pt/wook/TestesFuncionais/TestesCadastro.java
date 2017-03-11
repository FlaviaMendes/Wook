package pt.wook.TestesFuncionais;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesCadastro {
	
	private static String urlDoSite;
	private static WebDriver navegador;

		@BeforeClass
		public static void antesDeTodosOsTestes() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\EstudoFlavia\\chromedriver.exe");
			urlDoSite = "https://www.wook.pt/";
			navegador = new ChromeDriver();
			navegador.manage().window().maximize();
			
		}
		
		@Before
		public void antesDeCadaTeste(){
			
			navegador.get(urlDoSite);
			
		}
		
		@Test
		public void acessarPaginaDeLogin(){
			
			WebElement clicarIconeMenu = navegador.findElement(By.xpath("//*[@id=\"header-navbar\"]/button[1]/span"));
			clicarIconeMenu.click();
			
			WebElement abrirAbaLogin = navegador.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/nav/nav/ul[1]/li/a/span")); 
			assertTrue(abrirAbaLogin.isDisplayed());
			
		}
		
	
		
		
		
		
		
	}


	


	

	
	


