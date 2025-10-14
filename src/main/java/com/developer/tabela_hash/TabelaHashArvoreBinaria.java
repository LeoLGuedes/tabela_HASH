package com.developer.tabela_hash;

import com.developer.arvorebinaria.ArvoreBinaria;

public class TabelaHashArvoreBinaria extends TabelaHash {
    private ArvoreBinaria[] tabela;

    public TabelaHashArvoreBinaria(int tamanho, int numero_digitos, String hash_escolhido) {
        super(tamanho, numero_digitos, hash_escolhido);
        tabela = new ArvoreBinaria[tamanho];
    }

    @Override
    public int calcularHash(int valor) {
        switch (hash) {
            case "mod": // Resto da divisão
                return valor % tamanho;

            case "mult": // Multiplicação de Knuth
                double CK = 0.6180339887; // constante de Knuth (fração de Golden Ratio)
                double frac = (valor * CK) % 1;
                return (int)(tamanho * frac);

            case "fold": // Folding (soma de partes do número)
                int soma = 0;
                int temp = valor;
                while (temp > 0) {
                    soma += temp % 1000;  // pega os últimos 3 dígitos
                    temp /= 1000;         // remove os últimos 3 dígitos
                }
                return soma % tamanho;    // ajusta ao tamanho da tabela

            default:
                return valor % tamanho; // resto
        }
    }

    @Override
    public int inserir(int valor) {
        int hash = calcularHash(valor);

        if (tabela[hash] == null) {
            tabela[hash] = new ArvoreBinaria();
        }

        tabela[hash].insereUltimo(valor);
        return 0;
    }


    @Override
    public Registro buscar(int chave) {
        int hash = calcularHash(chave);
        if (tabela[hash] == null){
            return null;
        }
        return tabela[hash].buscar(chave);
    }

    @Override
    public int[] calcularStats() {
        return new int[0];
    }

}
