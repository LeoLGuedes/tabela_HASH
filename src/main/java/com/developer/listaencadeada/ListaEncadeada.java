package com.developer.listaencadeada;


import com.developer.tabela_hash.Registro;

public class ListaEncadeada
{
    private Node Lista;

    public ListaEncadeada() {
        this.Lista = null;
    }

    public boolean vazia(){
        return Lista==null;
    }

    //Inserindo elementos
    public int insereUltimo(int chave ,int valor) {
        Node no = new Node();
        no.setChave(chave);
        no.setValor(new Registro(valor));

        int contar_colisao = 0;

        if (vazia()) {
            // Nenhuma colisão, pois é o primeiro elemento dessa lista
            Lista = no;
            return contar_colisao;
        } else {
            Node atual = Lista;
            // Conta todos os nós já existentes (ou seja, todas as colisões anteriores)
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
                contar_colisao++;
            }
            // Adiciona o novo nó ao final
            atual.setProximo(no);

            // Como já havia ao menos 1 elemento, soma 1 para incluir o nó atual
            contar_colisao++;

            System.out.println("Nó atual no endereço " + atual);
            return contar_colisao;
        }
    }


    //Removendo elementos
    public Registro remove(int indice){
        if(vazia()){
            return null;
        }
        if(indice==0){
            return removePrimeiro();
        }

        Node atual = Lista;
        Node atualProximo = atual.getProximo();
        Registro valor;

        if(atualProximo == null){
            valor = atual.getValor();
            Lista = null;
            return valor;
        }

        while (atualProximo!=null && atualProximo.getProximo() != null) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }

        valor = atualProximo.getValor();
        atual.setProximo(null);
        return valor;
    }

    public Registro remove(Node node){
        if(vazia()){
            return null;
        }
        if(node==Lista){
            return removePrimeiro();
        }

        Node atual = Lista;
        Node atualProximo = atual.getProximo();

        Registro valor = null;

        while (atual.getProximo() != null && atual!=node) {
            atual = atual.getProximo();
        }

        valor = atual.getValor();
        atual.setProximo(null);

        return valor;
    }

    public Registro removePrimeiro(){
        if(vazia()){
            return null;
        }
        Registro valor = Lista.getValor();
        Node proximo = Lista.getProximo();


        Lista = proximo;
        return valor;

    }

    public Registro removeUltimo(){
        if(vazia()){
            return null;
        }

        Node atual = Lista;
        Node atualProximo = atual.getProximo();
        Registro valor;

        if(atualProximo == null){
            valor = atual.getValor();
            Lista = null;
            return valor;
        }

        while (atualProximo!=null && atualProximo.getProximo() != null) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }

        valor = atualProximo.getValor();
        atual.setProximo(null);
        return valor;
    }

    //Imprimindo elementos
    public void imprime() {
        Node atual = Lista;
        while (atual != null) {
            System.out.print(atual.getValor() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("Null");
    }

    public Registro buscar(int chave){
        if(vazia()){
            return null;
        }else{
            Node atual = Lista;

            while (atual.getProximo() != null) {
                if(atual.getChave() == chave){break;}
                atual = atual.getProximo();
            }
            return atual.getValor();
        }
    }



}
