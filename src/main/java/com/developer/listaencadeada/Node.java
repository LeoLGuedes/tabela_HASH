package com.developer.listaencadeada;

import com.developer.tabela_hash.Registro;

public class Node {
    private Registro informacao;
    private int chave;
    private Node proximo;

    public Node() {
        this.informacao = null;
        this.proximo = null;
    }

    public Registro getInformacao() {
        return informacao;
    }

    public void setInformacao(Registro informacao) {
        this.informacao = informacao;
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