package com.developer.tabela_hash;

public abstract class TabelaHash {
    int tamanho;
    int numero_digitos;
    String hash;

    public TabelaHash(int tamanho, int numero_digitos, String hash) {
        this.tamanho = tamanho;
        this.numero_digitos = numero_digitos;
        this.hash = hash;
    }

    public int getTamanho(){
        return tamanho;
    };

    public int getNumero_digitos(){
        return numero_digitos;
    };

    public String getHash(){
        return hash;
    };

    public abstract int calcularHash(int valor);

    public abstract int inserir(int valor);

    public abstract Registro buscar(int valor);

    public abstract int[] calcularStats();

}
