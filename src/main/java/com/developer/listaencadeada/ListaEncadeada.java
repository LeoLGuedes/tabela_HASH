package com.developer.listaencadeada;

import com.developer.tabela_hash.Registro;

public class ListaEncadeada {
    private Node Lista;

    public ListaEncadeada() {
        this.Lista = null;
    }

    public boolean vazia() {
        return Lista == null;
    }

    public int insereUltimo(int valor) {
        Node no = new Node();
        no.setValor(new Registro(valor));

        int contar_colisao = 0;

        if (vazia()) {
            Lista = no;
            return contar_colisao;
        } else {
            Node atual = Lista;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
                contar_colisao++;
            }
            atual.setProximo(no);
            contar_colisao++;
            return contar_colisao;
        }
    }

    public Registro remove(int indice) {
        if (vazia()) {
            return null;
        }
        if (indice == 0) {
            return removePrimeiro();
        }

        Node atual = Lista;
        Node atualProximo = atual.getProximo();
        Registro valor;

        if (atualProximo == null) {
            valor = atual.getValor();
            Lista = null;
            return valor;
        }

        while (atualProximo != null && atualProximo.getProximo() != null) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }

        valor = atualProximo.getValor();
        atual.setProximo(null);
        return valor;
    }

    public Registro remove(Node node) {
        if (vazia()) {
            return null;
        }
        if (node == Lista) {
            return removePrimeiro();
        }

        Node atual = Lista;
        Node atualProximo = atual.getProximo();

        Registro valor = null;

        while (atual.getProximo() != null && atual != node) {
            atual = atual.getProximo();
        }

        valor = atual.getValor();
        atual.setProximo(null);

        return valor;
    }

    public Registro removePrimeiro() {
        if (vazia()) {
            return null;
        }
        Registro valor = Lista.getValor();
        Node proximo = Lista.getProximo();


        Lista = proximo;
        return valor;

    }

    public Registro removeUltimo() {
        if (vazia()) {
            return null;
        }

        Node atual = Lista;
        Node atualProximo = atual.getProximo();
        Registro valor;

        if (atualProximo == null) {
            valor = atual.getValor();
            Lista = null;
            return valor;
        }

        while (atualProximo != null && atualProximo.getProximo() != null) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }

        valor = atualProximo.getValor();
        atual.setProximo(null);
        return valor;
    }

    public void imprime() {
        Node atual = Lista;
        while (atual != null) {
            System.out.print(atual.getValor() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("Null");
    }

    public Registro buscar(int chave) {
        if (vazia()) {
            System.err.println("Vazia");
            return null;
        } else {
            Node atual = Lista;

            while (atual.getProximo() != null) {
                if (atual.getChave() == chave) {
                    break;
                }
                atual = atual.getProximo();
            }
            if (atual.getValor() != null) {
                return atual.getValor();
            }
            System.out.println("Valor não encontrado");
            return null;
        }
    }

    public Node getInicio() {
        if (vazia()) {
            System.err.println("Vazia");
            return null;
        } else {
            return Lista;
        }
    }


}
