package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaConfirmarRegistro extends PaginaBase{

	public String mensagemExibida() {
		
		WebElement mensagemRegistroComSucesso = navegador.findElement(By.xpath("//*[@id=\"overlayConfirmRegist\"]/div[2]/h1"));
		String mensagemRegistroExibida = mensagemRegistroComSucesso.getText();
			
		return mensagemRegistroExibida;
		
	}

}
