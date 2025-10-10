/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.developer.tabela_hash;

// TabelaHash
//     TabelaHashEncadeada
//     TabelaHashRehasing

/**
 *
 * @author Lima
 */
public class TabelaHash {
    private Registro[] tabela;
    private int capacidade;

    public TabelaHash(int capacidade){
        this.capacidade = capacidade;
        alocarTabela(capacidade);
    }

    private void alocarTabela(int capacidade){
        tabela = new Registro[capacidade];
        for(int i=0; i<capacidade; i++){
            tabela[i] = null;
        }
    }

    private int calcularHash(int valor){
        return valor % capacidade;
    }

    public void inserir(int valor){
        int hash = calcularHash(valor);
        tabela[hash] = new Registro(valor);
    }

    public Registro buscar(int valor){
        int hash = calcularHash(valor);
        return tabela[hash];
    }
}
