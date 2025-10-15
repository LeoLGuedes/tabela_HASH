package com.developer.tabela_hash;

import com.developer.performance.Performance;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main_dev(String[] args){
        // hashs
        String[] hashs = {"mod", "mult", "fold"}; // todos lineares (+1)
        for(String hash : hashs){
            TabelaHashArvoreBinaria tabelaHashRehashing = new TabelaHashArvoreBinaria(10, 9, hash);
            System.out.println(tabelaHashRehashing.inserir(10));
            System.out.println(tabelaHashRehashing.inserir(20));
            System.out.println(tabelaHashRehashing.inserir(30));
            System.out.println(tabelaHashRehashing.inserir(40));
            System.out.println(tabelaHashRehashing.inserir(50));
            System.out.println(tabelaHashRehashing.inserir(15));
            System.out.println(tabelaHashRehashing.inserir(25));
            System.out.println(tabelaHashRehashing.inserir(35));
            System.out.println(tabelaHashRehashing.inserir(45));
            System.out.println(tabelaHashRehashing.inserir(55));
            System.out.println(tabelaHashRehashing.inserir(16));
            System.out.println(tabelaHashRehashing.inserir(26));
            System.out.println(tabelaHashRehashing.inserir(36));
            System.out.println(tabelaHashRehashing.inserir(46));
            System.out.println(tabelaHashRehashing.inserir(56));
            System.out.println(tabelaHashRehashing.inserir(17));
            System.out.println(tabelaHashRehashing.inserir(27));
            System.out.println(tabelaHashRehashing.inserir(37));
            System.out.println(tabelaHashRehashing.inserir(47));
            System.out.println(tabelaHashRehashing.inserir(57));
            System.out.println(tabelaHashRehashing.inserir(18));
            System.out.println(tabelaHashRehashing.inserir(28));
            System.out.println(tabelaHashRehashing.inserir(38));
            System.out.println(tabelaHashRehashing.inserir(48));
            System.out.println(tabelaHashRehashing.inserir(58));


            System.out.println(tabelaHashRehashing.buscar(10));
            System.out.println(tabelaHashRehashing.buscar(20));
            System.out.println(tabelaHashRehashing.buscar(30));
            System.out.println(tabelaHashRehashing.buscar(40));
            System.out.println(tabelaHashRehashing.buscar(50));
            System.out.println(tabelaHashRehashing.buscar(15));
            System.out.println(tabelaHashRehashing.buscar(25));
            System.out.println(tabelaHashRehashing.buscar(35));
            System.out.println(tabelaHashRehashing.buscar(45));
            System.out.println(tabelaHashRehashing.buscar(55));
            System.out.println(tabelaHashRehashing.buscar(16));
            System.out.println(tabelaHashRehashing.buscar(26));
            System.out.println(tabelaHashRehashing.buscar(36));
            System.out.println(tabelaHashRehashing.buscar(46));
            System.out.println(tabelaHashRehashing.buscar(56));
            System.out.println(tabelaHashRehashing.buscar(17));
            System.out.println(tabelaHashRehashing.buscar(27));
            System.out.println(tabelaHashRehashing.buscar(37));
            System.out.println(tabelaHashRehashing.buscar(47));
            System.out.println(tabelaHashRehashing.buscar(57));
            System.out.println(tabelaHashRehashing.buscar(18));
            System.out.println(tabelaHashRehashing.buscar(28));
            System.out.println(tabelaHashRehashing.buscar(38));
            System.out.println(tabelaHashRehashing.buscar(48));
            System.out.println(tabelaHashRehashing.buscar(58));
        }

    }

    public static void main(String[] args) throws IOException {
        boolean dev = true;
        if (dev){
            main_dev(args);
            System.exit(0);
        }

        System.out.println("TabelaHash");

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

        System.out.println("Gerando os dados");

        for(int i=0; i<tamanho_dados.length; i++){ // percorre tamanho_dados
            for(int j=0; j<tamanho_dados[i]; j++){ // percorre as quantidades dentro de tamanho_dados (DANGER)
                dados[i][j] = gerador.nextInt(Calculadora.potencia(10, numero_digitos)); // numeros de 0 a 1_000_000_000
            }
        }

        // hashs
        String[] hashs = {"mod", "mult", "fold"};
        int quantidade_etapas = tamanho_tabelas.length * tamanho_dados.length * hashs.length;
        int etapa = 0;
        System.out.println("Testando performance:");

        for(int i=0; i<tamanho_tabelas.length; i++){ // percorre tamanho_tabelas
            for(int j=0; j<tamanho_dados.length; j++){ // percorre tamanho_dados
                for (int k=0; k<hashs.length; k++){ // percorre hashs
                    etapa++;
                    System.out.println(etapa+"/"+quantidade_etapas);
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
                    performanceRehashing.analisarEstatisticas("gap_min,gap_max,gap_media,tamanho_final");
                    performanceEncadeada.analisarEstatisticas("gap_min,gap_max, gap_media,1_maior_listaEncadeada,2_maior_listaEncadeada,3_maior_listaEncadeada");
                    performanceEncadeada.analisarEstatisticas("gap_min,gap_max, gap_media,1_maior_arvoreBinaria,2_maior_arvoreBinaria,3_maior_arvoreBinaria");
                }
            }
        }
    }
}
