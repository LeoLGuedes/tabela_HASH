package com.developer.tabela_hash;

public abstract class TabelaHash {
    int tamanho;
    int numero_digitos;

    public TabelaHash(int tamanho, int numero_digitos) {
        this.tamanho = tamanho;
        this.numero_digitos = numero_digitos;
    }

    public int getTamanho(){
        return tamanho;
    };

    public int getNumero_digitos(){
        return numero_digitos;
    };

    public abstract int calcularHash(int valor);

    public abstract int inserir(int valor);

    public abstract Registro buscar(int valor);

    public abstract void imprimirTabela();

    public abstract int[] calcularStats();

}
