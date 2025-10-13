/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.developer.tabela_hash;

// TabelaHash
//     TabelaHashEncadeada
//     TabelaHashRehasing

import com.developer.listaencadeada.ListaEncadeada;

/**
 *
 * @author Lima
 */

public abstract class TabelaHash {
    int capacidade;
    int numero_digitos;

    public TabelaHash(int capacidade, int numero_digitos) {
        this.capacidade = capacidade;
        this.numero_digitos = numero_digitos;
    }

    public abstract int calcularHash(int chave);

    public abstract void inserir(int chave, int valor);

    public abstract Registro buscar(int chave);

    public abstract void imprimirTabela ();

    public static long tempoTotal(long tempo0 )
    {
        long tempo_final = System.currentTimeMillis();
        return tempo_final - tempo0;
    }

}
