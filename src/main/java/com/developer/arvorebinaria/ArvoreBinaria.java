package com.developer.arvorebinaria;

import com.developer.tabela_hash.Registro;

public class ArvoreBinaria {
    private No raiz;
    private int numero_digitos;

    public ArvoreBinaria(int numero_digitos){
        this.raiz = null;
        this.numero_digitos = numero_digitos;
    }

    boolean vazia(){
        return raiz==null;
    }

    public int insere(int info){
        if (vazia()) {
            No no = new No();
            no.setValor(new Registro(info, numero_digitos));
            raiz = no;
            return 0;
        } else {
            return insere(raiz, info, 1);
        }
    }

    private int insere(No raiz, int info, int colisoes){
        int raiz_info = raiz.getValor().getValor();
        if(info < raiz_info){
            No esquerda = raiz.getEsquerda();
            if(esquerda!=null){
                return insere(esquerda, info, colisoes+1);
            }else{
                No no = new No();
                no.setValor(new Registro(info, numero_digitos));
                raiz.setEsquerda(no);
                return colisoes;
            }
        }else{ // (info >= raiz_info)
            No direita = raiz.getDireita();
            if(direita!=null){
                return insere(direita, info, colisoes+1);
            }else{
                No no = new No();
                no.setValor(new Registro(info, numero_digitos));
                raiz.setDireita(no);
                return colisoes;
            }
        }
    }

    public Registro buscar(int info) {
        if (vazia()) {
            return null;
        }
        return buscar(raiz, info);
    }

    private Registro buscar(No raiz, int info) { // logica ficou mais bonita nesse, nao vou arrumar a insercao
        if (raiz == null) {
            return null;
        }

        int raizInfo = raiz.getValor().getValor();

        if (info == raizInfo) {
            return raiz.getValor();
        } else if (info < raizInfo) {
            return buscar(raiz.getEsquerda(), info);
        } else {
            return buscar(raiz.getDireita(), info);
        }
    }


}
