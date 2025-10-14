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

    public int calcularHashSimples(int valor){
        int resultado;
        switch (hash) {
            case "mod": // Resto da divisão
                resultado = valor % tamanho;
                break;
            case "mult": // Multiplicação de Knuth
                double CK = 0.6180339887; // constante de Knuth (fração de Golden Ratio)
                double frac = (valor * CK) % 1;
                resultado = (int)(tamanho * frac);
                break;
            case "fold": // Folding (soma de partes do número)
                int soma = 0;
                int temp = valor;
                while (temp > 0) {
                    soma += temp % 1000;  // pega os últimos 3 dígitos
                    temp /= 1000;         // remove os últimos 3 dígitos
                }
                resultado = soma % tamanho;    // ajusta ao tamanho da tabela
                break;
            default:
                resultado = valor % tamanho; // resto
                break;
        }
        return resultado;
    }


    public abstract int[] calcularHash(int valor);

    public abstract int inserir(int valor);

    public abstract Registro buscar(int valor);

    public abstract int[] calcularStats();

}
