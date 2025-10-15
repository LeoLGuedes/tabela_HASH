package com.developer.tabela_hash;

import com.developer.performance.Performance;
import com.developer.performance.Relatorio;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main_dev(String[] args){
        // hashs
        String[] hashs = {"mod"}; // todos lineares (+1)

        for(String hash : hashs){
            TabelaHashRehashing tabelaHashRehashing = new TabelaHashRehashing(10, 9, hash);
            TabelaHashEncadeada tabelaHashEncadeada = new TabelaHashEncadeada(10, 9, hash);
            TabelaHashArvoreBinaria tabelaHashArvoreBinaria = new TabelaHashArvoreBinaria(10, 9, hash);
            TabelaHash[] tabelas = {tabelaHashRehashing, tabelaHashEncadeada, tabelaHashArvoreBinaria};
            for(TabelaHash tabelaHash : tabelas){
                System.out.println(tabelaHash.getClass().getSimpleName()+" "+hash);
                System.out.println(tabelaHash.inserir(10));
                System.out.println(tabelaHash.inserir(20));
                System.out.println(tabelaHash.inserir(30));
                System.out.println(tabelaHash.inserir(40));
                System.out.println(tabelaHash.inserir(50));
                System.out.println(tabelaHash.inserir(15));
                System.out.println(tabelaHash.inserir(25));
                System.out.println(tabelaHash.inserir(35));
                System.out.println(tabelaHash.inserir(45));
                System.out.println(tabelaHash.inserir(55));
                System.out.println(tabelaHash.inserir(16));
                System.out.println(tabelaHash.inserir(26));
                System.out.println(tabelaHash.inserir(36));
                System.out.println(tabelaHash.inserir(46));
                System.out.println(tabelaHash.inserir(56));
                System.out.println(tabelaHash.inserir(17));
                System.out.println(tabelaHash.inserir(27));
                System.out.println(tabelaHash.inserir(37));
                System.out.println(tabelaHash.inserir(47));
                System.out.println(tabelaHash.inserir(57));
                System.out.println(tabelaHash.inserir(18));
                System.out.println(tabelaHash.inserir(28));
                System.out.println(tabelaHash.inserir(38));
                System.out.println(tabelaHash.inserir(48));
                System.out.println(tabelaHash.inserir(58));


                System.out.println(tabelaHash.buscar(10));
                System.out.println(tabelaHash.buscar(20));
                System.out.println(tabelaHash.buscar(30));
                System.out.println(tabelaHash.buscar(40));
                System.out.println(tabelaHash.buscar(50));
                System.out.println(tabelaHash.buscar(15));
                System.out.println(tabelaHash.buscar(25));
                System.out.println(tabelaHash.buscar(35));
                System.out.println(tabelaHash.buscar(45));
                System.out.println(tabelaHash.buscar(55));
                System.out.println(tabelaHash.buscar(16));
                System.out.println(tabelaHash.buscar(26));
                System.out.println(tabelaHash.buscar(36));
                System.out.println(tabelaHash.buscar(46));
                System.out.println(tabelaHash.buscar(56));
                System.out.println(tabelaHash.buscar(17));
                System.out.println(tabelaHash.buscar(27));
                System.out.println(tabelaHash.buscar(37));
                System.out.println(tabelaHash.buscar(47));
                System.out.println(tabelaHash.buscar(57));
                System.out.println(tabelaHash.buscar(18));
                System.out.println(tabelaHash.buscar(28));
                System.out.println(tabelaHash.buscar(38));
                System.out.println(tabelaHash.buscar(48));
                System.out.println(tabelaHash.buscar(58));
            }

        }

    }

    public static void main_relatorio(String[] args){
        Relatorio relatorio = new Relatorio();

    }

    public static void main(String[] args) throws IOException {
        boolean dev = false;
        if (dev){
            main_dev(args);
            System.exit(0);
        }
        boolean relatorio = false;
        if (relatorio){
            main_relatorio(args);
            System.exit(0);
        }

        // Problemas
        // uso de memoria
        // performance
        // rehashs sem entrar em loop inifinito
        // rehash sem ser linear +1
        // calculo de gaps

        System.out.println("TabelaHash");

        // tamanhos
        int[] tamanho_tabelas = {1_000, 10_000, 100_000}; // 1_000, 10_000, 100_000
        int[] tamanho_dados = {100_000, 1_000_000, 10_000_000}; // 100_000, 1_000_000, 10_000_000
        int numero_digitos = 9;

        // dados (matrix iregular)
        Registro[][] dados = new Registro[tamanho_dados.length][];
        for(int i=0; i<tamanho_dados.length; i++){
            dados[i] = new Registro[tamanho_dados[i]];
        }


        // Gerador de números aleatórios
        int seed = 4002_8922;
        Random gerador = new Random(seed);

        System.out.println("Gerando os dados");

        for(int i=0; i<tamanho_dados.length; i++){ // percorre tamanho_dados
            for(int j=0; j<tamanho_dados[i]; j++){ // percorre as quantidades dentro de tamanho_dados (DANGER)
                int numero = gerador.nextInt(Calculadora.potencia(10, numero_digitos)); // numeros de 0 a 1_000_000_000
                dados[i][j] = new Registro(numero, numero_digitos);
            }
        }

        // hashs
        String[] hashs = {"mod"};
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
//                    performanceRehashing.analisarEstatisticas("gap_min,gap_max,gap_media,tamanho_final");
//                    performanceEncadeada.analisarEstatisticas("gap_min,gap_max, gap_media,1_maior_listaEncadeada,2_maior_listaEncadeada,3_maior_listaEncadeada");
//                    performanceEncadeada.analisarEstatisticas("gap_min,gap_max, gap_media,1_maior_arvoreBinaria,2_maior_arvoreBinaria,3_maior_arvoreBinaria");
                }
            }
        }
    }
}
