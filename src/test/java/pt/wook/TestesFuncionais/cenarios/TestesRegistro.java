package pt.wook.TestesFuncionais.cenarios;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
		principal.abrirPagina();
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
	
	@Test
	public void naoConseguirSeRegistrarNaoInformandoEmail(){
		
		String email = "flaviamendes29@mailinator.com";
		registro.confirmarEnderecoEmail(email);

		String password = "123456";
		registro.password(password);
		registro.confirmarPassword(password);
		registro.receberComunicacoesDeMarketing(true);
		registro.confirmar();
		
		String mensagemEsperada = "Campo de preenchimento obrigatório.";
		assertEquals(mensagemEsperada, registro.mensagemCamposObrigatorios());
		
	}
	
	@Test
	public void naoConseguirSeRegistrarNaoConfirmandoEmail(){
		
		String email = "flaviamendes29@mailinator.com";
		registro.enderecoEmail(email);

		String password = "123456";
		registro.password(password);
		registro.confirmarPassword(password);
		registro.receberComunicacoesDeMarketing(true);
		registro.confirmar();
		
		String mensagemEsperada = "Campo de preenchimento obrigatório.";
		assertEquals(mensagemEsperada, registro.mensagemCamposObrigatorios());
		
	}
	
	@Test
	public void naoConseguirSeRegistrarNaoInformandoPassword(){
		
		String email = "flaviamendes29@mailinator.com";
		registro.enderecoEmail(email);
		registro.confirmarEnderecoEmail(email);

		String password = "123456";
		registro.confirmarPassword(password);
		registro.receberComunicacoesDeMarketing(true);
		registro.confirmar();
		
		String mensagemEsperada = "Campo de preenchimento obrigatório.";
		assertEquals(mensagemEsperada, registro.mensagemCamposObrigatorios());
		
	}
	
	@Test
	public void naoConseguirSeRegistrarNaoConfirmandoPassword(){
		
		String email = "flaviamendes29@mailinator.com";
		registro.enderecoEmail(email);
		registro.confirmarEnderecoEmail(email);

		String password = "123456";
		registro.password(password);
		registro.receberComunicacoesDeMarketing(true);
		registro.confirmar();
		
		String mensagemEsperada = "Campo de preenchimento obrigatório.";
		assertEquals(mensagemEsperada, registro.mensagemCamposObrigatorios());
		
	}

}
