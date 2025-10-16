package com.developer.tabela_hash;

public class Registro {
    public final int num_digitos;
    public final int valor;

    public Registro(Integer valor, int num_digitos) {
        this.num_digitos = num_digitos;
        this.valor = valor;
    }

    public String toString() {
        String formato = "%0" + num_digitos + "d";
        return String.format(formato, valor);
    }
}
