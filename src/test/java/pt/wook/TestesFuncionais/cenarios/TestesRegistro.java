package pt.wook.TestesFuncionais.cenarios;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pt.wook.TestesFuncionais.paginas.PaginaConfirmarRegistro;
import pt.wook.TestesFuncionais.paginas.PaginaLogin;
import pt.wook.TestesFuncionais.paginas.PaginaPrincipal;
import pt.wook.TestesFuncionais.paginas.PaginaRegistro;

public class TestesRegistro {
	
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
		public void registroComSucessoOptandoPorReceberComunicacoesDeMarketing(){
			
			PaginaPrincipal principal = new PaginaPrincipal();
			principal.abrirMenu();
			
			PaginaLogin login = principal.clicarEmLogin();
			PaginaRegistro registro = login.clicarNovoRegistro();
			
			String email = "flaviamendes29@mailinator.com";
			registro.enderecoEmail(email);
			registro.confirmarEnderecoEmail(email);
			
			String password = "123456";
			registro.password(password);
			registro.confirmarPassword(password);
			registro.receberComunicacoesDeMarketing(true);
			
			PaginaConfirmarRegistro confirmarRegistro = registro.confirmar();
			
			String mensagemEsperada = "O seu registo foi efetuado com sucesso.";
			assertEquals(mensagemEsperada, confirmarRegistro.mensagemExibida());
			
			
			
		}
		
	
		
		
		
		
		
	}


	


	

	
	


