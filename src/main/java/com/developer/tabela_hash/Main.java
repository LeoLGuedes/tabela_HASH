/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.developer.tabela_hash;

/**
 *
 * @author Lima
 */
public class Main {

    public static void main(String[] args) {
        /*
            TabelaHashRehashing tabela = new TabelaHashRehashing(10, 9);
            tabela.inserir(0,0);
            tabela.inserir(10,10);
            tabela.inserir(20,20);
            tabela.inserir(30,30);
            System.out.println(tabela.buscar(0));
            System.out.println(tabela.buscar(10));
            System.out.println(tabela.buscar(20));
            System.out.println(tabela.buscar(30));
        */
        TabelaHashEncadeada tabela = new TabelaHashEncadeada(5, 9);
        tabela.inserir(0,0);
        tabela.inserir(10,10);
        tabela.inserir(20,20);
        tabela.inserir(30,30);
        System.out.println(tabela.buscar(0));
        System.out.println(tabela.buscar(10));
        System.out.println(tabela.buscar(20));
        System.out.println(tabela.buscar(30));
    }
}
