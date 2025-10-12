/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.developer.tabela_hash;


public class Main {

    public static void main(String[] args) {
        TabelaHashRehashing tabela = new TabelaHashRehashing(10, 9);
        tabela.inserir(1,0);
        tabela.inserir(11,10);
        tabela.inserir(21,20);
        tabela.inserir(31,30);
        System.out.println(tabela.buscar(1));
        System.out.println(tabela.buscar(11));
        System.out.println(tabela.buscar(21));
        System.out.println(tabela.buscar(31));

        int totalColisao = tabela.getColisao();
        System.out.printf("Total de colisões feitas: %d", totalColisao);
    }
}
