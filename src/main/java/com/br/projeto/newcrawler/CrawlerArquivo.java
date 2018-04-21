package com.br.projeto.newcrawler;

public class CrawlerArquivo implements Crawler{

	@Override
	public void executa(String[] parametros) {

		try{
        	String diretorio = parametros[1];
        	new LeitorDiretorio().ler(diretorio);
        	
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
	}

}
