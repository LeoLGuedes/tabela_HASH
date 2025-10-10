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
    private final int capacidade;
    private final int numero_digitos;


    public TabelaHash(int capacidade, int numero_digitos){
        this.capacidade = capacidade;
        this.numero_digitos = numero_digitos;
        alocarTabela();
    }

    private void alocarTabela(){
        tabela = new Registro[capacidade];
        for(int i=0; i<capacidade; i++){
            tabela[i] = new Registro(null, numero_digitos);
        }
    }

    private int calcularHash(int valor){
        return valor % capacidade;
    }

    public void inserir(int valor){
        inserir(valor, null);
    }

    public void inserir(int valor, Integer hash){
        if(hash == null){
            hash = calcularHash(valor);
        }else{
            hash = calcularHash(hash+1);
        }
        if (tabela[hash] != null){
            inserir(valor, hash);
        }else{
            tabela[hash] = new Registro(valor, numero_digitos);
        }
    }

    public Registro buscar(int valor){
        int hash = calcularHash(valor);
        return tabela[hash];
    }
}
