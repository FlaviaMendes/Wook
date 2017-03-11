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

	private PaginaRegistro registro;

	@Before
	public void antesDeCadaTeste() {
		
		System.out.println("\nIniciando Teste.");

		PaginaPrincipal principal = new PaginaPrincipal();
		principal.abrirMenu();

		PaginaLogin login = principal.clicarEmLogin();
		registro = login.clicarNovoRegistro();

	}

	@Test
	public void registroComSucessoOptandoPorReceberComunicacoesDeMarketing() { // método - bloco de código
																			
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

	@Test
	public void registroComSucessoOptandoPorNaoReceberComunicacoesDeMarketing() {
		
	
		String email = "flaviamendes29@mailinator.com";
		registro.enderecoEmail(email);
		registro.confirmarEnderecoEmail(email);
		
		String password = "123456";
		registro.password(password);
		registro.confirmarPassword(password);
		registro.receberComunicacoesDeMarketing(false);
		
		PaginaConfirmarRegistro confirmarRegistro = registro.confirmar();
		
		String mensagemEsperada = "O seu registo foi efetuado com sucesso.";
		assertEquals(mensagemEsperada, confirmarRegistro.mensagemExibida());
		
	}

}
