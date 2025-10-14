package com.developer.tabela_hash;

public class Calculadora {
    public static int potencia(int base, int expoente) {
        // 10**9 = 1000000000
        int resultado = 1;
        for (int i = 0; i < expoente; i++) {
            resultado *= base;
        }
        return resultado;
    }
}
