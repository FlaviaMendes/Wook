package pt.wook.TestesFuncionais.cenarios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AfterBeforeExample {

	@BeforeClass
	public static void antesDeTodos(){
		System.out.println("1");
	}
	
	@Before
	public void antesDeCada() {
		System.out.println("2");
	}
	
	@Test
	public void teste1() {
		System.out.println("Testei 1");
	}
	
	@Test
	public void teste2() {
		System.out.println("Testei 2");
	}
	
	@After
	public void depoisDeCada() {
		System.out.println("3");
	}
	
	@AfterClass
	public static void depoisDeTodos() {
		System.out.println("4");
	}

}

