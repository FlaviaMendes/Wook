package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaRegistro extends PaginaBase{

	public void enderecoEmail(String email) {
		
		System.out.println("Preenchendo Email: " + email);
		
		WebElement campoEnderecoEmail = navegador.findElement(By.name("email"));
		campoEnderecoEmail.sendKeys(email);
		
	}

	public void confirmarEnderecoEmail(String email) {

		System.out.println("Preenchendo confirmação de Email: " + email);
		
		WebElement campoConfirmarEnderecoEmail = navegador.findElement(By.name("confirm-email"));
		campoConfirmarEnderecoEmail.sendKeys(email);
		
	}

	public void password(String password) {
		
		System.out.println("Preenchendo password: " + password);
		
		WebElement campoPassword = navegador.findElement(By.name("pass"));
		campoPassword.sendKeys(password);
		
	}
	
	public void confirmarPassword(String password) {
		
		System.out.println("Confirmando password: " + password);
		
		WebElement campoConfirmarPassword = navegador.findElement(By.name("confirm-pass"));
		campoConfirmarPassword.sendKeys(password);
		
	}

	public void receberComunicacoesDeMarketing(boolean receber) {
		
		System.out.println("Recebendo comunicações? " + receber);
		
		WebElement confirmarComunicacaoMarketing = navegador.findElement(By.id("subscription-label"));
		
		if (confirmarComunicacaoMarketing.isSelected() != receber){
			
			confirmarComunicacaoMarketing.click();
			
		}
			
		
	}

	public PaginaConfirmarRegistro confirmar() {
		
		System.out.println("Confirmando registro.");
		
		WebElement botaoConfrimar = navegador.findElement(By.xpath("//*[@id=\"regist-user\"]/button/span"));
		botaoConfrimar.click();
			
		return new PaginaConfirmarRegistro();
		
	}

	public String mensagemCampoObrigatorioEmail() {
		
		System.out.println("Mensagem de Erro");
		
		WebElement mensagemCampoObrigatorio = navegador.findElement(By.id("email-error"));
		mensagemCampoObrigatorio.isDisplayed();
		
		return "Campo de preenchimento obrigatório.";
	}

	public String mensagemCampoObrigatorioConfirmarEmail() {

		System.out.println("Mensagem de Erro");
		
		WebElement mensagemCampoObrigatorio = navegador.findElement(By.id("confirm-email-error"));
		mensagemCampoObrigatorio.isDisplayed();
		
		return "Campo de preenchimento obrigatório.";
	}

	public String mensagemCampoObrigatorioPassword() {

		System.out.println("Mensagem de Erro");
				
		WebElement mensagemCampoObrigatorio = navegador.findElement(By.id("pass-error"));
		mensagemCampoObrigatorio.isDisplayed();
		
		return "Campo de preenchimento obrigatório.";
	}

	public String mensagemCampoObrigatorioConfirmarPassword() {
		
		System.out.println("Mensagem de Erro");
		
		WebElement mensagemCampoObrigatorio = navegador.findElement(By.id("confirm-pass-error"));
		mensagemCampoObrigatorio.isDisplayed();
		
		return "Campo de preenchimento obrigatório.";
	}

	

	

}
