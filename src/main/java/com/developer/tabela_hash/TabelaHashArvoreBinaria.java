package com.developer.tabela_hash;

import com.developer.arvorebinaria.ArvoreBinaria;

public class TabelaHashArvoreBinaria extends TabelaHash {
    private ArvoreBinaria[] tabela;

    public TabelaHashArvoreBinaria(int tamanho, int numero_digitos, String hash_escolhido) {
        super(tamanho, numero_digitos, hash_escolhido);
        tabela = new ArvoreBinaria[tamanho];
    }

    @Override
    public int[] calcularHash(int valor) {
        // [hash, colicoes]
        int colisoes = 0;
        int hash = calcularHashSimples(valor);
        return new int[]{hash, colisoes};
    }

    @Override
    public int inserir(int valor) {
        int hash = calcularHash(valor)[0];

        if (tabela[hash] == null) {
            tabela[hash] = new ArvoreBinaria(numero_digitos);
        }

        int colisoes = tabela[hash].insere(valor);
        return colisoes;
    }

    @Override
    public int inserir(Registro valor) {
        int hash = calcularHash(valor.valor)[0];

        if (tabela[hash] == null) {
            tabela[hash] = new ArvoreBinaria(numero_digitos);
        }

        int colisoes = tabela[hash].insere(valor);
        return colisoes;
    }


    @Override
    public Registro buscar(int valor) {
        int hash = calcularHash(valor)[0];
        if (tabela[hash] == null){
            return null;
        }
        return tabela[hash].buscar(valor);
    }

    @Override
    public Registro buscar(Registro valor) {
        int hash = calcularHash(valor.valor)[0];
        if (tabela[hash] == null){
            return null;
        }
        return tabela[hash].buscar(valor);
    }

    @Override
    public int[] calcularStats() {
        return new int[0];
    }

}
