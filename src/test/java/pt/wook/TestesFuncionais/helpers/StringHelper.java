package pt.wook.TestesFuncionais.helpers;

import java.util.UUID;

public class StringHelper {
	
	public static String gerarEmail(){
		
		String uuid = UUID.randomUUID().toString();
		
		return uuid + "@mailinator.com";
		
	}

}
