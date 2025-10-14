package com.developer.tabela_hash;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe principal para testar as implementações da Tabela Hash.
 *
 * @author Lima
 */
public class Main {

    public static void main(String[] args) {
        try {
            // Criação dos arquivos para registrar os resultados
            FileWriter tempoImplementacaoEncadeada = new FileWriter("tempoImplementacaoEncadeada.txt");

            // Instancia a tabela hash encadeada
            TabelaHashEncadeada tabelaEncadeada = new TabelaHashEncadeada(1000, 9);

            // Gerador de números aleatórios
            int seed = 987654321; // número aleatório usado como seed
            Random gerador = new Random(seed);

            // Inicia a contagem do tempo total
            long tempoInicial = System.currentTimeMillis();

            for (int i = 0; i < 1000; i++) {
                int chaveAleatoria = gerador.nextInt(1000);
                tabelaEncadeada.inserir(chaveAleatoria, chaveAleatoria);
                long tempoInsercao = tabelaEncadeada.tempoTotal(tempoInicial);
                tempoImplementacaoEncadeada.write(chaveAleatoria + " - " + tempoInsercao + "\n");
            }

            long tempoFinal = System.currentTimeMillis();
            long tempoExecucao = tempoFinal - tempoInicial;

            // Fecha os arquivos corretamente
            implementacaoEncadeada.close();
            tempoImplementacaoEncadeada.close();

            // Mostra o tempo total e imprime a tabela
            System.out.println("\n\n\n\n------------------------------------------------------------------------------\n");
            System.out.println("Tempo total de execução: " + tempoExecucao + " ms");
            System.out.println("------------------------------------------------------------------------------\n\n\n\n");
            tabelaEncadeada.imprimirTabela();

        } catch (IOException e) {
            System.out.println("Erro ao manipular os arquivos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
