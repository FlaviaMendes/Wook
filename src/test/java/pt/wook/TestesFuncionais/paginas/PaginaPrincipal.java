package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaPrincipal extends PaginaBase{
	
	public void abrirPagina(){
		
		navegador.get(URL_SITE);
		
	}

	public void abrirMenu() {

		System.out.println("Abrindo o Menu.");
		
		String xpath = "//*[@id=\"header-navbar\"]/button[1]";
		WebElement botaoMenu = navegador.findElement(By.xpath(xpath));
		botaoMenu.click();
		
	}

	public PaginaLogin clicarEmLogin() {

		System.out.println("Abrindo Página de Login.");
		
		String xpath = "//*[@id=\"sidebar-wrapper\"]/nav/nav/ul[1]/li/a";
		navegador.findElement(By.xpath(xpath)).click();;
		
		return new PaginaLogin();
		
	}

}
