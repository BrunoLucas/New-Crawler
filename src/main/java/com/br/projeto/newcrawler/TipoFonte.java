package com.br.projeto.newcrawler;

public enum TipoFonte {

	GMAIL(new CrawlerGmail()),
	ARQUIVO(new CrawlerArquivo()),
	WEB(new CrawlerWeb());
	
	private Crawler crawler;
	
	private TipoFonte(Crawler crawler){
		this.crawler = crawler;
	}

	public Crawler getCrawler() {
		return crawler;
	}

	
}
