/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.developer.tabela_hash;

/**
 *
 * @author Lima
 */
public class TabelaHashRehashing extends TabelaHash{
    private Registro[] tabela;

    public TabelaHashRehashing(int capacidade, int numero_digitos) {
        super(capacidade, numero_digitos);
        tabela = new Registro[capacidade];
    }

    @Override
    public int calcularHash(int valor) {
        int hash = valor % capacidade;
        if (tabela[hash] == null) {
            return hash;
        } else {
            return calcularHash(hash + 1);
        }
    }
    
    @Override
    public void inserir(int valor) {
        int hash = calcularHash(valor);
        tabela[hash] = new Registro(valor, numero_digitos);
    }

    @Override
    public Registro buscar(int valor) {
        int hash = calcularHash(valor);
        return tabela[hash];
    }
}
