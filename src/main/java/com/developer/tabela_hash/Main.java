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


        for(int i=0; i<tamanho_tabelas.length; i++){ // percorre tamanho_tabelas
            for(int j=0; j<tamanho_dados.length; j++){ // percorre tamanho_dados

                TabelaHashRehashing tabelaHashRehashing = new TabelaHashRehashing(tamanho_tabelas[i], numero_digitos);
                TabelaHashEncadeada tabelaHashEncadeada = new TabelaHashEncadeada(tamanho_tabelas[i], numero_digitos);
                // FALTA A ARVORE BINARIA AQUI

                Performance performanceRehashing = new Performance(tabelaHashRehashing, tamanho_dados[j]);
                Performance performanceEncadeada = new Performance(tabelaHashEncadeada, tamanho_dados[j]);
                // FALTA A ARVORE BINARIA AQUI

                // Insercao (DANGER)
                performanceRehashing.medirInsercao(dados[j]);
                performanceEncadeada.medirInsercao(dados[j]);
                // FALTA A ARVORE BINARIA AQUI

                // Busca (DANGER)
                performanceRehashing.medirBusca(dados[j]);
                performanceEncadeada.medirBusca(dados[j]);
                // FALTA A ARVORE BINARIA AQUI

                // Busca (DANGER)
                performanceRehashing.analisarEstatisticas("gap_min,gap_max,gap_media");
                performanceEncadeada.analisarEstatisticas("gap_min,gap_max, gap_media,1_listaEncadeada,2_listaEncadeada,3_listaEncadeada");
                // FALTA A ARVORE BINARIA AQUI

            }
        }
    }
}
