package com.developer.tabela_hash;

import com.developer.listaencadeada.ListaEncadeada;

public class TabelaHashEncadeada extends TabelaHash
{
    private ListaEncadeada[] tabela;

    public TabelaHashEncadeada(int tamanho, int numero_digitos) {
        super(tamanho, numero_digitos);
        tabela = new ListaEncadeada[numero_digitos];
    }

    @Override
    public int calcularHash(int chave) {
        int hash = chave % capacidade;
        return hash;

    }

    @Override
    public void inserir(int chave, int valor) {
        int hash = calcularHash(chave);
        if  (tabela[hash] == null) {
            tabela[hash] = new ListaEncadeada();
        }
        tabela[hash].insereUltimo(chave, valor);
        tabela[hash].imprime();
    }

    @Override
    public Registro buscar(int chave) {
        int hash = calcularHash(chave);
        return tabela[hash].buscar(chave);
    }
}
