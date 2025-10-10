/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.developer.tabela_hash;

/**
 *
 * @author Lima
 */
public class Registro {
    private int num_digitos;
    private Integer valor;

    public Registro(Integer valor, int num_digitos){
        this.num_digitos = num_digitos;
        this.valor = null;
        if(is_valido(valor)){
            this.valor = valor;
        }
    }
    
    private boolean is_valido(Integer valor){
        if(valor == null){
           return true;
        }
        // if(valor < 0){
        //    valor = -valor; // Converte negativo para posivo (ABS)
        // }
        return valor < Calculadora.potencia(10, num_digitos);
    }
    
    public void imprimir(){
        // %[argument_index$][flags][width][.precision]conversion
        // TODO: tentar usar o num_digits pra imprimir aqui depois
        System.out.printf("%09d", valor);
    }
    
    public void imprimirln(){
        // %n == \n (but better, acording to docs)
        System.out.printf("%09d%n", valor);
    }

    public String toString() {
        String formato = "%0"+num_digitos+"d%n";
        return String.format(formato, valor);
    }
}
