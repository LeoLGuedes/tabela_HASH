package com.developer.tabela_hash;

import com.developer.performance.Performance;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        // tamanhos
        int[] tamanho_tabelas = {10, 100, 1000}; // 1_000, 10_000, 100_000
        int[] tamanho_dados = {100, 1_000, 10_000}; // 100_000, 1_000_000, 100_000_000
        int numero_digitos = 9;

        // dados (matrix iregular)
        int[][] dados = new int[tamanho_dados.length][];
        for(int i=0; i<tamanho_dados.length; i++){
            dados[i] = new int[tamanho_dados[i]];
        }


        // Gerador de números aleatórios
        int seed = 40028922;
        Random gerador = new Random(seed);

        for(int i=0; i<tamanho_dados.length; i++){ // percorre tamanho_dados
            for(int j=0; j<tamanho_dados[i]; j++){ // percorre as quantidades dentro de tamanho_dados (DANGER)
                dados[i][j] = gerador.nextInt(Calculadora.potencia(10, numero_digitos)); // numeros de 0 a 1_000_000_000
            }
        }

        // hashs
        String[] hashs = {"mod", "mult", "fold"};

        for(int i=0; i<tamanho_tabelas.length; i++){ // percorre tamanho_tabelas
            for(int j=0; j<tamanho_dados.length; j++){ // percorre tamanho_dados
                for (int k=0; k<hashs.length; k++){ // percorre hashs
                    TabelaHashRehashing tabelaHashRehashing = new TabelaHashRehashing(tamanho_tabelas[i], numero_digitos, hashs[k]);
                    TabelaHashEncadeada tabelaHashEncadeada = new TabelaHashEncadeada(tamanho_tabelas[i], numero_digitos, hashs[k]);
                    TabelaHashArvoreBinaria tabelaHashArvoreBinaria = new TabelaHashArvoreBinaria(tamanho_tabelas[i], numero_digitos, hashs[k]);

                    Performance performanceRehashing = new Performance(tabelaHashRehashing, tamanho_dados[j]);
                    Performance performanceEncadeada = new Performance(tabelaHashEncadeada, tamanho_dados[j]);
                    Performance performanceArvoreBinaria = new Performance(tabelaHashArvoreBinaria, tamanho_dados[j]);

                    // Insercao (DANGER)
                    performanceRehashing.medirInsercao(dados[j]); // Quando tamanho_tabela "enche"(75%), o tamanho duplica e sao feitas as insercoes novamente
                    performanceEncadeada.medirInsercao(dados[j]);
                    performanceArvoreBinaria.medirInsercao(dados[j]);

                    // Busca (DANGER)
                    performanceRehashing.medirBusca(dados[j]);
                    performanceEncadeada.medirBusca(dados[j]);
                    performanceArvoreBinaria.medirBusca(dados[j]);

                    // Busca (DANGER)
                    performanceRehashing.analisarEstatisticas("gap_min,gap_max,gap_media");
                    performanceEncadeada.analisarEstatisticas("gap_min,gap_max, gap_media,1_maior_listaEncadeada,2_maior_listaEncadeada,3_maior_listaEncadeada");
                    performanceEncadeada.analisarEstatisticas("gap_min,gap_max, gap_media,1_maior_arvoreBinaria,2_maior_arvoreBinaria,3_maior_arvoreBinaria");
                }
            }
        }
    }
}
