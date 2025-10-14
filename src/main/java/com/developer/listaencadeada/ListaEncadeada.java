package com.developer.listaencadeada;

import com.developer.tabela_hash.Registro;

public class ListaEncadeada {
    private Node Lista;
    private int numero_digitos;

    public ListaEncadeada(int numero_digitos) {
        this.Lista = null;
        this.numero_digitos = numero_digitos;
    }

    public boolean vazia() {
        return Lista == null;
    }

    public int insereUltimo(int valor) {
        Node no = new Node();
        no.setValor(new Registro(valor, numero_digitos));

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

}
