package com.developer.tabela_hash;

import com.developer.arvorebinaria.ArvoreBinaria;

public class TabelaHashArvoreBinaria extends TabelaHash {
    private ArvoreBinaria[] tabela;

    public TabelaHashArvoreBinaria(int tamanho, int numero_digitos, String hash_escolhido) {
        super(tamanho, numero_digitos, hash_escolhido);
        tabela = new ArvoreBinaria[tamanho];
    }

    @Override
    public int calcularHash(int chave) {
        return chave % tamanho;
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
