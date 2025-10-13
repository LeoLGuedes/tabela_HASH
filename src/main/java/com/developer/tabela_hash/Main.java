package com.developer.tabela_hash;

import java.util.Random;

/**
 * Classe principal para testar as implementações da Tabela Hash.
 *
 * @author Lima
 */
public class Main {

    public static void main(String[] args) {
        TabelaHashEncadeada tabelaEncadeada = new TabelaHashEncadeada(100000 , 9);
        TabelaHashRehashing tabelaHashRehashing = new TabelaHashRehashing(10, 9);

        int seed = 987654321; // numero aleatorio
        Random gerador = new Random(seed);

        long tempoInicial = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            int chaveAleatoria = gerador.nextInt(100000 );
            tabelaEncadeada.inserir(chaveAleatoria, chaveAleatoria);
        }
        System.out.println("\n\n\n\n------------------------------------------------------------------------------\n\n\n\n");
        tabelaEncadeada.imprimirTabela();

        long tempoFinalInsersao =  tabelaEncadeada.tempoTotal(tempoInicial);
        System.out.println("Tempo total para fazer a Insersao: " + tempoFinalInsersao);


        tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int chaveAleatoria = gerador.nextInt(1000);
            tabelaHashRehashing.inserir(chaveAleatoria, chaveAleatoria);

        tabelaHashRehashing.imprimirTabela();}

        long tempoFinalInsersao = tabelaHashRehashing.tempoTotal(tempoInicial);
        System.out.println("Tempo total para fazer a Insersao: " + tempoFinalInsersao);
    }
}