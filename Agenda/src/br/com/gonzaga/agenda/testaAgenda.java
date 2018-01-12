package br.com.gonzaga.agenda;

import br.com.gonzaga.dao.ContatoDAO;

public class testaAgenda {
	public static void main(String[] args) {
		
		Contato a = new Contato();
		
//		a.setEmail("alexandrepom@gmail.com");
		a.setNome("alexandre");
		a.setTelefone("(73) 99194-0120");
		a.setId((long)2);
		
		ContatoDAO dao = new ContatoDAO();
		
//		dao.adiciona(a);
		System.out.println(dao.getLista());
		a.setEmail("alexandregonzaga@gmail.com");
		dao.update(a);
		System.out.println(dao.getLista());
	}
}
