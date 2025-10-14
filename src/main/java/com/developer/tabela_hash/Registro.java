package com.developer.tabela_hash;

public class Registro {
    private int num_digitos;
    private int chave;
    private Integer valor;

    public Registro(int chave, Integer valor, int num_digitos) {
        this.num_digitos = num_digitos;
        this.chave = chave;
        this.valor = null;
        if (is_valido(valor)) {
            this.valor = valor;
        }
    }

    public Registro(Integer valor) {
        this.valor = valor;
        this.num_digitos = 9;
        if (is_valido(valor)) {
            this.valor = valor;
        }
    }

    public Integer getValor() {
        return valor;
    }

    private boolean is_valido(Integer valor) {
        if (valor == null) {
            return true;
        }
        // if(valor < 0){
        //    valor = -valor; // Converte negativo para posivo (ABS)
        // }
        return valor < Calculadora.potencia(10, num_digitos);
    }

    public void imprimir() {
        // %[argument_index$][flags][width][.precision]conversion
        // TODO: tentar usar o num_digits pra imprimir aqui depois
        System.out.printf("%09d", valor);
    }

    public void imprimirln() {
        // %n == \n (but better, acording to docs)
        System.out.printf("%09d%n", valor);
    }

    public int getChave() {
        return chave;
    }

    public String toString() {
        if (valor == null) {
            return null;
        }
        String formato = "%0" + num_digitos + "d";
        return String.format(formato, valor);
    }
}
