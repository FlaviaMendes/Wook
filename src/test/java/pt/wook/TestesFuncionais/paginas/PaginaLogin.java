package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaLogin extends PaginaBase {

	public PaginaRegistro clicarNovoRegistro() {
		
		System.out.println("Abrindo Página de Registro.");
		
		WebElement linkNovoRegistro = navegador.findElement(By.xpath("//*[@id=\"btns\"]/a"));
		linkNovoRegistro.click();
		
		return new PaginaRegistro();
	}

}
