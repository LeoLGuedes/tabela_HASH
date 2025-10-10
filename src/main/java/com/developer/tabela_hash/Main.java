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
        TabelaHash tabela = new TabelaHash(10);
        tabela.inserir(2);
        Registro a = tabela.buscar(2);
        System.out.println(a);
    }
}
