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
    private int registro;
    public Registro(int registro){
        this.num_digitos = 9;
        this.registro = registro;
    }
    
    private boolean is_valido(int registro){
        return registro<Calculadora.potencia(10, 9);
    }
    
    public void imprimir(){
        // %[argument_index$][flags][width][.precision]conversion
        // TODO: tentar usar o num_digits pra imprimir aqui depois
        System.out.printf("%09d", registro);
    }
    
    public void imprimirln(){
        // %n == \n (but better, acording to docs)
        System.out.printf("%09d%n", registro);
    }

    public String toString() {
        String formato = "%0"+num_digitos+"d%n";
        return String.format(formato, registro);
    }
}
