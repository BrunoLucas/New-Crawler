package com.br.projeto.newcrawler;

public class CrawlerGmail implements Crawler{

	public void executa(String[] parametros){
		String email = parametros[1];
    	String senha = parametros[2];
        new LeitorDeEmail().ler(new UsuarioEmail(email, senha));
	}
}
