package pt.wook.TestesFuncionais.cenarios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import pt.wook.TestesFuncionais.helpers.StringHelper;
import pt.wook.TestesFuncionais.paginas.PaginaBase;
import pt.wook.TestesFuncionais.paginas.PaginaConfirmarRegistro;
import pt.wook.TestesFuncionais.paginas.PaginaLogin;
import pt.wook.TestesFuncionais.paginas.PaginaPrincipal;
import pt.wook.TestesFuncionais.paginas.PaginaRegistro;

public class TestesRegistro {

	private PaginaRegistro registro;
	private String email;

	@Before
	public void antesDeCadaTeste() {
		
		System.out.println("\nIniciando Teste.");

		PaginaPrincipal principal = new PaginaPrincipal();
		principal.abrirPagina();
		principal.abrirMenu();

		PaginaLogin login = principal.clicarEmLogin();
		registro = login.clicarNovoRegistro();
		
		email = StringHelper.gerarEmail();

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
	public void registroComSucessoOptandoPorReceberComunicacoesDeMarketing() { // método - bloco de código
																			
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
	
	@Test
	public void naoConseguirSeRegistrarNaoInformandoEmail(){
		
		registro.confirmarEnderecoEmail(email);

		String password = "123456";
		registro.password(password);
		registro.confirmarPassword(password);
		registro.receberComunicacoesDeMarketing(true);
		registro.confirmar();
		
		String mensagemEsperada = "Campo de preenchimento obrigatório.";
		assertEquals(mensagemEsperada, registro.mensagemCampoObrigatorioEmail());
		
	}
	
	@Test
	public void naoConseguirSeRegistrarNaoConfirmandoEmail(){
		
		registro.enderecoEmail(email);

		String password = "123456";
		registro.password(password);
		registro.confirmarPassword(password);
		registro.receberComunicacoesDeMarketing(true);
		registro.confirmar();
		
		String mensagemEsperada = "Campo de preenchimento obrigatório.";
		assertEquals(mensagemEsperada, registro.mensagemCampoObrigatorioConfirmarEmail());
		
	}
	
	@Test
	public void naoConseguirSeRegistrarNaoInformandoPassword(){
		
		registro.enderecoEmail(email);
		registro.confirmarEnderecoEmail(email);

		String password = "123456";
		registro.confirmarPassword(password);
		registro.receberComunicacoesDeMarketing(true);
		registro.confirmar();
		
		String mensagemEsperada = "Campo de preenchimento obrigatório.";
		assertEquals(mensagemEsperada, registro.mensagemCampoObrigatorioPassword());
		
	}
	
	@Test
	public void naoConseguirSeRegistrarNaoConfirmandoPassword(){
		
		registro.enderecoEmail(email);
		registro.confirmarEnderecoEmail(email);

		String password = "123456";
		registro.password(password);
		registro.receberComunicacoesDeMarketing(true);
		registro.confirmar();
		
		String mensagemEsperada = "Campo de preenchimento obrigatório.";
		assertEquals(mensagemEsperada, registro.mensagemCampoObrigatorioConfirmarPassword());
		
	}

}
