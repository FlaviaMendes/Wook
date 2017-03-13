package pt.wook.TestesFuncionais.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaConfirmarRegistro extends PaginaBase{

	public String mensagemExibida() {
		
		WebElement mensagemRegistroComSucesso = navegador.findElement(By.xpath("//*[@id=\"overlayConfirmRegist\"]/div[2]/h1"));
		String mensagemRegistroExibida = mensagemRegistroComSucesso.getText();
		String mensagemRegistroEsperada = "O seu registo foi efetuado com sucesso.";
		assertEquals(mensagemRegistroEsperada, mensagemRegistroExibida);
		
		/*WebElement mensagemExibida = navegador.findElement(By.xpath("//*[@id=\"overlayConfirmRegist\"]/div[2]/h1"));
		assertTrue(mensagemExibida.isDisplayed());*/
			
		return "O seu registo foi efetuado com sucesso.";
		
	}

	

	

}
