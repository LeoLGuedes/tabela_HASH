package com.developer.listaencadeada;

import com.developer.tabela_hash.Registro;

public class Node {
    private Registro valor;
    private int chave;
    private Node proximo;

    public Node() {
        this.valor = null;
        this.proximo = null;
    }

    public Registro getValor() {
        return valor;
    }

    public void setValor(Registro valor) {
        this.valor = valor;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
    public int getChave() {
        return chave;
    }
    public void setChave(int chave) {
        this.chave = chave;
    }
}