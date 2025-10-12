package com.developer.tabela_hash;

import com.developer.listaencadeada.ListaEncadeada;
import com.developer.listaencadeada.Node;

public class TabelaHashEncadeada extends TabelaHash {
    private ListaEncadeada[] tabela;
    private int totalColisoes = 0;
    private int totalElementos = 0;

    public TabelaHashEncadeada(int tamanho, int numero_digitos) {
        super(tamanho, numero_digitos);
        tabela = new ListaEncadeada[tamanho];
    }

    @Override
    public int calcularHash(int chave) {
        return chave % capacidade;
    }

    @Override
    public void inserir(int chave, int valor) {
        int hash = calcularHash(chave);

        if (tabela[hash] == null) {
            tabela[hash] = new ListaEncadeada();
        } else if (!tabela[hash].vazia()) {
            totalColisoes++;
        }

        tabela[hash].insereUltimo(chave, valor);
        totalElementos++;

        System.out.println("Número de colisões: " + totalColisoes + " ao inserir esse valor: " + valor);

        double fatorDeCarga = (double) totalElementos / capacidade;
        if (fatorDeCarga > 0.75) { // limite típico
            rehash();
        }

        tabela[hash].imprime();
    }
    private void rehash() {
        System.out.println("\n Iniciando rehash...");
        ListaEncadeada[] tabelaAntiga = tabela;
        int capacidadeAntiga = capacidade;

        capacidade *= 2; // dobra a capacidade
        tabela = new ListaEncadeada[capacidade];
        totalColisoes = 0;
        totalElementos = 0;

        // Reinsere todos os elementos na nova tabela (sem contar colisões antigas)
        for (int i = 0; i < capacidadeAntiga; i++) {
            ListaEncadeada lista = tabelaAntiga[i];
            if (lista != null && !lista.vazia()) {
                Node atual = lista.getInicio();
                while (atual != null) {
                    inserirSemRehash(atual.getChave(), atual.getValor().getValor());
                    atual = atual.getProximo();
                }
            }
        }

        System.out.println("Rehash completo. Nova capacidade: " + capacidade + "\n");
    }

    // insere sem recalcular fator de carga nem imprimir colisões
    private void inserirSemRehash(int chave, int valor) {
        int hash = calcularHash(chave);

        if (tabela[hash] == null) {
            tabela[hash] = new ListaEncadeada();
        } else if (!tabela[hash].vazia()) {
            totalColisoes++;
        }

        tabela[hash].insereUltimo(chave, valor);
        totalElementos++;
    }

    @Override
    public Registro buscar(int chave) {
        int hash = calcularHash(chave);
        if (tabela[hash] == null) return null;
        return tabela[hash].buscar(chave);
    }

}
