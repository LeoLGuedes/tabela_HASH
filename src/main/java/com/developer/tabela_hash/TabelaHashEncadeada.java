package com.developer.tabela_hash;

import com.developer.listaencadeada.ListaEncadeada;

public class TabelaHashEncadeada extends TabelaHash {
    private ListaEncadeada[] tabela;

    public TabelaHashEncadeada(int tamanho, int numero_digitos, String hash) {
        super(tamanho, numero_digitos, hash);
        tabela = new ListaEncadeada[tamanho];
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
            tabela[hash] = new ListaEncadeada(numero_digitos);
        }

        int colisoes = tabela[hash].insereUltimo(valor);
        return colisoes;
    }


    @Override
    public Registro buscar(int chave) {
        int hash = calcularHash(chave)[0];
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
