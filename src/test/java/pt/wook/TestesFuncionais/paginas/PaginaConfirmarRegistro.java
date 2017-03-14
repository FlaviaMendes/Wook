package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaConfirmarRegistro extends PaginaBase{

	public String mensagemExibida() {
		
		WebElement mensagemRegistroComSucesso = navegador.findElement(By.id("overlayConfirmRegist"));
		String mensagemRegistroExibida = mensagemRegistroComSucesso.getText();
			
		return mensagemRegistroExibida;
		
	}

}
