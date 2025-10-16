package com.developer.arvorebinaria;

import com.developer.tabela_hash.Registro;

public class No {
    private Registro valor;
    private No direita;
    private No esquerda;

    public No() {
        this.valor = null;
        this.direita = null;
        this.esquerda = null;
    }

    public Registro getValor() {
        return valor;
    }

    public void setValor(Registro valor) {
        this.valor = valor;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getEsquerda() {
        return esquerda;
    }

}
