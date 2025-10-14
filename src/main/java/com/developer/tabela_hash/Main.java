package com.developer.tabela_hash;

import com.developer.Arquivos.EscritaArquivos;

import java.util.Random;


/**
 * Classe principal para testar as implementações da Tabela Hash.
 *
 * @author Lima
 */
public class Main {

    public static void main(String[] args) {

        TabelaHashEncadeada tabelaEncadeada = new TabelaHashEncadeada(1000, 9);
        EscritaArquivos arquivos = new EscritaArquivos("InserirEncadeado1000.txt");

        // Gerador de números aleatórios
        int seed = 987654321; // número aleatório usado como seed
        Random gerador = new Random(seed);

        // Inicia a contagem do tempo total
        long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int chaveAleatoria = gerador.nextInt(1000);
            tabelaEncadeada.inserir(chaveAleatoria, chaveAleatoria);
            long tempoInsercao = tabelaEncadeada.tempoTotal(tempoInicial);
            arquivos.escrever(chaveAleatoria, tempoInsercao);
        }

        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;


        // Mostra o tempo total e imprime a tabela
        System.out.println("\n\n\n\n------------------------------------------------------------------------------\n");
        System.out.println("Tempo total de execução: " + tempoExecucao + " ms");
        System.out.println("------------------------------------------------------------------------------\n\n\n\n");
        tabelaEncadeada.imprimirTabela();

        int[] ler = arquivos.lerBusca();
        for (int i = 0; i < arquivos.getTamanhoArquivo(); i++) {
            System.out.print(ler[i] + " ");
        }


    }
}
