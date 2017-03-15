package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaLogin extends PaginaBase {

	public String enderecoEmail;
	public String mensagemDeAutenticacaoInvalida;

	public PaginaRegistro clicarNovoRegistro() {
		
		System.out.println("Abrindo Página de Registro.");
		
		WebElement linkNovoRegistro = navegador.findElement(By.xpath("//*[@id=\"btns\"]/a"));
		linkNovoRegistro.click();
		
		return new PaginaRegistro();
	}

	public void enderecoEmail(String email) {

		System.out.println("Preenchendo Email: " + email);
		
		WebElement campoEnderecoEmail = navegador.findElement(By.name("email"));
		campoEnderecoEmail.sendKeys(email);
		
	}

	public void password(String password) {
		
		System.out.println("Preenchendo password: " + password);
		
		WebElement campoPassword = navegador.findElement(By.name("pass"));
		campoPassword.sendKeys(password);
		
	}

	public PaginaPrincipal confirmar() {
		
		System.out.println("Confirmar Login.");
		
		WebElement confirmarLogin = navegador.findElement(By.xpath("//*[@id=\"login-form\"]/button/span"));
		confirmarLogin.click();
		
		return new PaginaPrincipal();
	}

	public void enderecoEmailInvalido(Object emailInvalido) {
		// TODO Auto-generated method stub
		
	}

	public void passwordInvalido(Object passwordInvalido) {
		// TODO Auto-generated method stub
		
	}

}
