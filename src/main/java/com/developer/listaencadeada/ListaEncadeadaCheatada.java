package com.developer.listaencadeada;

import com.developer.tabela_hash.Registro;
import java.util.Objects;

public class ListaEncadeadaCheatada {
    private Node primeiro;
    private Node ultimo;
    private int numero_digitos;
    private int tamanho; // contador de elementos

    public ListaEncadeadaCheatada(int numero_digitos) {
        this.primeiro = null;
        this.ultimo = null;
        this.numero_digitos = numero_digitos;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return primeiro == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int insereUltimo(int valor) {
        Node no = new Node();
        no.setValor(new Registro(valor, numero_digitos));

        int contar_colisao = tamanho;

        if (vazia()) {
            primeiro = no;
            ultimo = no;
        } else {
            ultimo.setProximo(no);
            ultimo = no;
        }
        tamanho++;
        return contar_colisao;
    }

    public int insereUltimo(Registro valor) {
        Node no = new Node();
        no.setValor(valor);

        int contar_colisao = 0;

        if (vazia()) {
            primeiro = no;
            ultimo = no;
        } else {
            ultimo.setProximo(no);
            ultimo = no;
            contar_colisao++;
        }
        tamanho++;
        return contar_colisao;
    }

    public Registro buscar(int valor) {
        if (vazia()) {
            System.out.println("Vazia");
            return null;
        } else {
            Node atual = primeiro;
            while (atual != null) {
                if (atual.getValor().valor == valor) {
                    return atual.getValor();
                }
                atual = atual.getProximo();
            }
            System.out.println("Valor não encontrado");
            return null;
        }
    }

    public Registro buscar(Registro valor) {
        if (vazia()) {
            System.out.println("Vazia");
            return null;
        } else {
            Node atual = primeiro;
            while (atual != null) {
                if (Objects.equals(atual.getValor().valor, valor.valor)) {
                    return atual.getValor();
                }
                atual = atual.getProximo();
            }
            System.out.println("Valor não encontrado");
            return null;
        }
    }
}
