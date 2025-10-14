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

    public boolean insere(int info){
        if (vazia()) {
            No no = new No();
            no.setValor(new Registro(info, numero_digitos));
            raiz = no;
            return true;
        } else {
            return insere(raiz, info);
        }
    }

    private boolean insere(No raiz, int info){
        int raiz_info = raiz.getValor().getValor();
        if(info < raiz_info){
            No esquerda = raiz.getEsquerda();
            if(esquerda!=null){
                insere(esquerda, info);
            }else{
                No no = new No();
                no.setValor(new Registro(info, numero_digitos));
                raiz.setEsquerda(no);
                return true;
            }
        }else{ // (info >= raiz_info)
            No direita = raiz.getDireita();
            if(direita!=null){
                insere(direita, info);
            }else{
                No no = new No();
                no.setValor(new Registro(info, numero_digitos));
                raiz.setDireita(no);
                return true;
            }
        }
        return false;
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
