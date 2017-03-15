package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaConfirmarLogin extends PaginaBase {
	
	public String emailExibido(){
		
		WebElement loginComSucesso = navegador.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/nav/nav/ul[1]/li/a/span[2]"));
		loginComSucesso.isDisplayed();
		
		return emailExibido();
		
	}

}
