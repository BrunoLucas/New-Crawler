package com.br.projeto.newcrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorConteudoDocumento {

	public void ler(File documento) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(documento.getAbsoluteFile()));
		StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = br.readLine();
	    }
	    String everything = sb.toString();
	    System.out.println("Documento: " + everything);
	}
}
