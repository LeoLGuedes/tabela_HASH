/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.developer.tabela_hash;


public class TabelaHashRehashing extends TabelaHash{
    private Registro[] tabela;
    int colisao = 0;



    public TabelaHashRehashing(int capacidade, int numero_digitos) {
        super(capacidade, numero_digitos);
        tabela = new Registro[capacidade];
    }

    @Override
    public int calcularHash(int chave) {
        int hash = chave % capacidade;
        if (tabela[hash] == null) {
            return hash;
        } else {
            colisao++;
            return calcularHash(hash + 1);// Rehash
        }
    }

    public int getColisao() {
        return colisao;
    }

    public int calcularHashBusca(int chave) {
        int hash = chave % capacidade;
        return calcularHashBusca(chave, hash); // Rehash
    }

    public int calcularHashBusca(int chave, int hash) {
        hash = hash % capacidade;
        if (tabela[hash].getChave() == chave) {
            return hash;
        }
        return calcularHashBusca(chave, hash + 1); // Rehash

    }


    @Override
    public void inserir(int chave, int valor) {
        int hash = calcularHash(chave);
        tabela[hash] = new Registro(chave, valor, numero_digitos);
    }

    @Override
    public Registro buscar(int chave) {
        int hash = calcularHashBusca(chave);
        return tabela[hash];
    }
}
