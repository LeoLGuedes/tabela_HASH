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
    public void insereUltimo(int chave ,int valor) {
        //Declarando nosso novo nó
        Node no = new Node();
        no.setChave(chave);
        no.setInformacao(new Registro(valor));
        int contar_colizao = 0;
        if (vazia()) {
            Lista = no;

        } else {
            //Aqui se cria um apontador para a lista.
            Node atual = Lista;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
                contar_colizao++;
            }
            atual.setProximo(no);
            System.out.println("Nó atual no endereço" + atual);

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
            valor = atual.getInformacao();
            Lista = null;
            return valor;
        }

        while (atualProximo!=null && atualProximo.getProximo() != null) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }

        valor = atualProximo.getInformacao();
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

        valor = atual.getInformacao();
        atual.setProximo(null);

        return valor;
    }

    public Registro removePrimeiro(){
        if(vazia()){
            return null;
        }
        Registro valor = Lista.getInformacao();
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
            valor = atual.getInformacao();
            Lista = null;
            return valor;
        }

        while (atualProximo!=null && atualProximo.getProximo() != null) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }

        valor = atualProximo.getInformacao();
        atual.setProximo(null);
        return valor;
    }

    //Imprimindo elementos
    public void imprime() {
        Node atual = Lista;
        while (atual != null) {
            System.out.print(atual.getInformacao() + " -> ");
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
            return atual.getInformacao();
        }
    }



}
