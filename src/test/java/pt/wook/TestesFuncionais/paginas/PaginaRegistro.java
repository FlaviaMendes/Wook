package pt.wook.TestesFuncionais.paginas;

public class PaginaRegistro {

	public void enderecoEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println("Preenchendo Email: " + email);
	}

	public void confirmarEnderecoEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println("Preenchendo confirmação de Email: " + email);
		
	}

	public void password(String password) {
		// TODO Auto-generated method stub
		System.out.println("Preenchendo password: " + password);
		
	}
	
	public void confirmarPassword(String password) {
		// TODO Auto-generated method stub
		System.out.println("Confirmando password: " + password);
		
	}

	public void receberComunicacoesDeMarketing(boolean receber) {
		// TODO Auto-generated method stub
		System.out.println("Recebendo comunicações? " + receber);
	}

	public PaginaConfirmarRegistro confirmar() {
		// TODO Auto-generated method stub
		System.out.println("Confirmando registro.");
		return new PaginaConfirmarRegistro();
		
	}

	

	

}
