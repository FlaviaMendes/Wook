package pt.wook.TestesFuncionais.cenarios;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pt.wook.TestesFuncionais.helpers.StringHelper;
import pt.wook.TestesFuncionais.paginas.PaginaBase;
import pt.wook.TestesFuncionais.paginas.PaginaConfirmarLogin;
import pt.wook.TestesFuncionais.paginas.PaginaLogin;
import pt.wook.TestesFuncionais.paginas.PaginaPrincipal;

public class TestesLogin {
	
	private PaginaLogin login;
	private String email;
	private PaginaPrincipal confirmarLogin;
	private Object emailInvalido;
	private Object passwordInvalido;

	@Before
	public void antesDeCadaTeste(){
		
		System.out.println("\nInciando Testes.");
		
		PaginaPrincipal principal = new PaginaPrincipal();
		principal.abrirPagina();
		principal.abrirMenu();
		
		login = principal.clicarEmLogin();
		
	}
	
	@After
	public void depoisDeCadaTeste(){
		
		PaginaBase.limparTodosCookies();
		
	}
	
	@AfterClass
	public static void despoisDeTodosOsTestes(){
		
		PaginaBase.fecharNavegador();
		
	}
	
	@Test
	public void efetuarLoginComSucesse(){
		
		login.enderecoEmail(email);
		
		String password = "123456";
		login.password(password);
		
		confirmarLogin = login.confirmar();
		
		PaginaPrincipal principal = new PaginaPrincipal();
		principal.abrirPagina();
		principal.abrirMenu();
		
		String emailEsperado = email;
		assertEquals(emailEsperado, login.enderecoEmail);
		
	}
	
	@Test
	public void emailInvalidoAoTentarEfetuarLogin(){
		
		login.enderecoEmailInvalido(emailInvalido);
		
		String password = "123456";
		login.password(password);
		
		confirmarLogin = login.confirmar();
		
		String mensagemEsperada = "Os dados de autenticação são inválidos. Por favor, corrija o email e/ou password.";
		assertEquals(mensagemEsperada, login.mensagemDeAutenticacaoInvalida);
		
	}
	
	@Test 
	public void passwordInvalidoAoTentarEfetuarLogin(){
		
		login.enderecoEmail(email);
		login.passwordInvalido(passwordInvalido);
		
		confirmarLogin = login.confirmar();
		
		String mensagemEsperada = "Os dados de autenticação são inválidos. Por favor, corrija o email e/ou password.";
		assertEquals(mensagemEsperada, login.mensagemDeAutenticacaoInvalida);
		
	}


}
