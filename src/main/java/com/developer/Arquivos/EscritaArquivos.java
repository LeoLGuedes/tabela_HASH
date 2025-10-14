package com.developer.Arquivos;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class EscritaArquivos {
    private String arquivo;
    private int tamanhoArquivo;

    public EscritaArquivos(String arquivo, int tamanhoArquivo) {
        this.arquivo = arquivo;
        this.tamanhoArquivo = 0;
    }

    public EscritaArquivos(String arquivo) {
        this.arquivo = arquivo;
    }

    public void escrever(int chave, long tempo) {
        try {
            // "true" faz com que o conteúdo seja adicionado, não sobrescrito
            FileWriter writer = new FileWriter(arquivo, true);
            writer.write(chave + " - " + tempo + "\n");
            writer.close();
            this.tamanhoArquivo++;
        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    public int[] lerBusca() {
        int[] valores = new int[tamanhoArquivo];

        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha;
            int i = 0;

            while ((linha = br.readLine()) != null && i < tamanhoArquivo) {
                linha = linha.trim();

                // procurar o "-"
                int posTraco = linha.indexOf('-');

                if (posTraco > 0) {
                    String parte = linha.substring(0, posTraco).trim();

                    try {
                        int valor = Integer.parseInt(parte);
                        valores[i] = valor;
                        i++;
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter número: " + linha);
                    }
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return valores;
    }

    public int getTamanhoArquivo() {return this.tamanhoArquivo;}
}