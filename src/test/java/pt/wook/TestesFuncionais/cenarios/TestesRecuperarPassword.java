package pt.wook.TestesFuncionais.cenarios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import pt.wook.TestesFuncionais.paginas.PaginaBase;
import pt.wook.TestesFuncionais.paginas.PaginaLogin;
import pt.wook.TestesFuncionais.paginas.PaginaPrincipal;

public class TestesRecuperarPassword {
	
	private String recuperarPassword;

	@Before
	public void antesDeCadaTeste(){
		
		System.out.println("\nIniciando Testes.");
		
		PaginaPrincipal principal = new PaginaPrincipal();
		principal.abrirPagina();
		principal.abrirMenu();
		
		PaginaLogin login = principal.clicarEmLogin();
		recuperarPassword = login.clicarRecuperarPassword();
		
	}
	
	@After
	public void depoisDeCadaTeste(){
		
		PaginaBase.limparTodosCookies();
		
	}
	
	@AfterClass
	public static void depoisDeTodosOsTestes(){
	
		PaginaBase.fecharNavegador();
		
	}
	
	@Test
	public void recuperarSenhaComSucesso(){
		
		
	}
	
	@Test
	public void recuperarSenhaEmailInexistente(){
		
		
	}

}
