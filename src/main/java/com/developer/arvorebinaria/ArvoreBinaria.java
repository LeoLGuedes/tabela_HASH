package com.developer.arvorebinaria;

import com.developer.tabela_hash.Registro;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public boolean vazia() {
        return raiz == null;
    }

    public int inserir(int chave, int valor) {
        No novoNo = new No();
        novoNo.setChave(chave);
        novoNo.setValor(new Registro(valor));

        int contar_colisao = 0;

        if (vazia()) {
            raiz = novoNo;
            return contar_colisao;
        } else {
            contar_colisao = inserirRecursivo(raiz, novoNo, 0);
            return contar_colisao;
        }
    }

    private int inserirRecursivo(No atual, No novoNo, int contador) {
        if (novoNo.getChave() < atual.getChave()) {
            contador++;
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                return contador;
            } else {
                return inserirRecursivo(atual.getEsquerda(), novoNo, contador);
            }
        } else {
            contador++;
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                return contador;
            } else {
                return inserirRecursivo(atual.getDireita(), novoNo, contador);
            }
        }
    }

    public Registro buscar(int chave) {
        if (vazia()) {
            System.err.println("Árvore vazia");
            return null;
        }

        No atual = raiz;

        while (atual != null) {
            if (chave == atual.getChave()) {
                return atual.getValor();
            } else if (chave < atual.getChave()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        System.out.println("Valor não encontrado");
        return null;
    }

    public void remover(int chave) {
        raiz = removerRecursivo(raiz, chave);
    }

    private No removerRecursivo(No atual, int chave) {
        if (atual == null) {
            return null;
        }

        if (chave < atual.getChave()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), chave));
        } else if (chave > atual.getChave()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), chave));
        } else {
            // Caso 1: sem filhos
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }

            // Caso 2: um filho
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            // Caso 3: dois filhos → substitui pelo menor da direita
            No sucessor = menorElemento(atual.getDireita());
            atual.setChave(sucessor.getChave());
            atual.setValor(sucessor.getValor());
            atual.setDireita(removerRecursivo(atual.getDireita(), sucessor.getChave()));
        }

        return atual;
    }

    private No menorElemento(No atual) {
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Árvore vazia");
        } else {
            System.out.print("Árvore (em ordem): ");
            imprimirInOrdem(raiz);
            System.out.println("Null");
        }
    }

    private void imprimirInOrdem(No atual) {
        if (atual == null) return;
        imprimirInOrdem(atual.getEsquerda());
        System.out.print(atual.getValor() + " -> ");
        imprimirInOrdem(atual.getDireita());
    }

    public No getRaiz() {
        return raiz;
    }
}
