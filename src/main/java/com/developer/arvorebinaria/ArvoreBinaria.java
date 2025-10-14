package com.developer.arvorebinaria;

import com.developer.tabela_hash.Registro;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    boolean vazia(){
        return raiz==null;
    }

    boolean insere(int info){
        if (vazia()) {
            No no = new No();
            no.setValor(info);
            raiz = no;
            return true;
        } else {
            return insere(raiz, info);
        }
    }

    private boolean insere(No raiz, int info){
        int raiz_info = raiz.getValor();
        if(info < raiz_info){
            No esquerda = raiz.getEsquerda();
            if(esquerda!=null){
                insere(esquerda, info);
            }else{
                No no = new No();
                no.setValor(info);
                raiz.setEsquerda(no);
                return true;
            }
        }else{ // (info >= raiz_info)
            No direita = raiz.getDireita();
            if(direita!=null){
                insere(direita, info);
            }else{
                No no = new No();
                no.setValor(info);
                raiz.setDireita(no);
                return true;
            }
        }
        return false;
    }

    void preOrdem(){
        if(vazia()){
            return;
        }
        System.out.print("[");
        preOrdem(raiz);
        System.out.println("]");
    }

    private void preOrdem(No raiz){ // I,E,D
        if(raiz==null){
            return;
        }
        System.out.print(raiz.getValor()+",");
        preOrdem(raiz.getEsquerda());
        preOrdem(raiz.getDireita());
    }

    void inOrdem(){
        if(vazia()){
            return;
        }
        System.out.print("[");
        inOrdem(raiz);
        System.out.println("]");
    }

    private void inOrdem(No raiz){ // E,I,D
        if(raiz==null){
            return;
        }
        inOrdem(raiz.getEsquerda());
        System.out.print(raiz.getValor()+",");
        inOrdem(raiz.getDireita());
    }

    void posOrdem(){
        if(vazia()){
            return;
        }
        System.out.print("[");
        posOrdem(raiz);
        System.out.println("]");
    }

    private void posOrdem(No raiz){ // E,D,I
        if(raiz==null){
            return;
        }
        posOrdem(raiz.getEsquerda());
        posOrdem(raiz.getDireita());
        System.out.print(raiz.getValor()+",");
    }

    No getMaior(){
        if (vazia()) {
            return null;
        } else {
            return getMaior(raiz);
        }
    }

    private No getMaior(No raiz){
        if(raiz==null){
            return raiz;
        }
        No maior = null;
        No direita = raiz.getDireita();
        if(direita!=null){
            maior = getMaior(direita);
        } else {
            return raiz;
        }
        return maior;
    }

    No getMenor(){
        if (vazia()) {
            return null;
        } else {
            return getMenor(raiz);
        }
    }

    private No getMenor(No raiz){
        if(raiz==null){
            return raiz;
        }
        No maior = null;
        No esquerda = raiz.getEsquerda();
        if(esquerda!=null){
            maior = getMenor(esquerda);
        } else {
            return raiz;
        }
        return maior;
    }

    No removeMaior(){ // ineficiente, mas to sem tempo
        No maior = getMaior();
        return remove(maior.getValor());
    }

    No removeMenor(){ // ineficiente, mas to sem tempo
        No menor = getMenor();
        return remove(menor.getValor());
    }

    No remove(int info){
        if (vazia()) {
            return null;
        } else {
            return remove(raiz, raiz, info);
        }
    }

    private No remove(No raiz, No raiz_quadrada, int info){
        if(raiz==null){
            return null;
        }
        int raiz_info = raiz.getValor();
        if (info < raiz_info) {
            No esquerda = raiz.getEsquerda();
            if (esquerda!=null){
                return remove(esquerda, raiz, info);
            }else{
                return null;
            }

        }else if (info > raiz_info){
            No direita = raiz.getDireita();
            if (direita!=null){
                return remove(direita, raiz, info);
            }else{
                return null;
            }
        }else{ // (info == raiz_info)
            // removendo o no
            No esquerda = raiz.getEsquerda();
            if(esquerda!=null){
                No maior = getMaior(esquerda);
                maior.setDireita(raiz.getDireita());

                if(raiz_quadrada.getEsquerda()==raiz){
                    raiz_quadrada.setEsquerda(esquerda);
                }else{
                    raiz_quadrada.setDireita(esquerda);
                }
            }else{
                No direita = raiz.getDireita();
                if(direita!=null){
                    raiz_quadrada.setEsquerda(direita);
                }else{
                    if(raiz_quadrada.getEsquerda()==raiz){
                        raiz_quadrada.setEsquerda(null);
                    }else{
                        raiz_quadrada.setDireita(null);
                    }
                }
            }
            return raiz;
        }
    }

}
