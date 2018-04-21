package com.br.projeto.newcrawler;

import java.io.File;
import java.io.IOException;

public class LeitorDiretorio {

	public void ler(String diretorio) throws IOException{
		File diretorioDosArquivos = new File(diretorio);
    	File[] arquivos = diretorioDosArquivos.listFiles();
    	for(File f : arquivos){
    		System.out.println("Titulo: " + f.getAbsolutePath());
    	
    		if(f.getAbsolutePath().contains("txt")
    				|| f.getAbsolutePath().contains("pdf") 
    				|| f.getAbsolutePath().contains("doc") 
    				|| f.getAbsolutePath().contains("docx") 
    				|| f.getAbsolutePath().contains("ppt") 
    				|| f.getAbsolutePath().contains("pptx")) {
    		
    			new LeitorConteudoDocumento().ler(f);
    		}else {
    			this.ler(f.getAbsolutePath());
    		}
    	}
	}
}
