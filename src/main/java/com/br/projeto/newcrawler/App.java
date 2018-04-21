package com.br.projeto.newcrawler;

public class App 
{
    public static void main( String[] args ) 
    {
        String tipoFonte = args[0];
        TipoFonte.valueOf(tipoFonte).getCrawler().executa(args);
    }
}
