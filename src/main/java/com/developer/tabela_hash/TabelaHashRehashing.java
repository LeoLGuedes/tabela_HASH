package com.developer.tabela_hash;

public class TabelaHashRehashing extends TabelaHash {
    private Registro[] tabela;
    private int capacidade;
    private double taxaCheio;


    public TabelaHashRehashing(int tamanho, int numero_digitos, String hash) {
        super(tamanho, numero_digitos, hash);
        this.tabela = new Registro[tamanho];
        this.capacidade = 0;
        this.taxaCheio = 0.75;
    }

    @Override
    public int calcularHash(int valor) {
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
        if(tabela[resultado] != null) { // tem registro
            return calcularRehash(resultado);
        }
        return resultado;
    }

    public int calcularRehash(int valor){
        valor = calcularHash(valor + 1);
        if(tabela[valor] == null) {
            return valor;
        }
        return calcularRehash(valor);
    }

    public int calcularHashBusca(int valor) {
        int hash = calcularHash(valor);
        return calcularHashBusca(valor, hash); // Rehash
    }

    public int calcularHashBusca(int valor, int hash) {
        hash = calcularHash(hash);
        if (tabela[hash].getValor() == valor) {
            return hash;
        }
        return calcularHashBusca(valor, hash + 1); // Rehash

    }

    public boolean isCheia() {
        return ((double) capacidade / tabela.length) >= taxaCheio;
    }

    public void dobrarTabela() { // (DANGER)
        tamanho *= 2;
        Registro[] antiga = tabela;
        tabela = new Registro[tamanho];
        for(Registro registro : antiga) {
            if(registro != null) {
                tabela[calcularHash(registro.getValor())] = registro;
            }
        }
    }

    @Override
    public int inserir(int valor) {
        if (isCheia()){
            dobrarTabela(); // (DANGER)
        }
        int hash = calcularHash(valor);
        tabela[hash] = new Registro(valor, numero_digitos);
        capacidade++;
        return 0;
    }

    @Override
    public Registro buscar(int chave) {
        int hash = calcularHashBusca(chave);
        return tabela[hash];
    }

    @Override
    public int[] calcularStats() {
        return new int[0];
    }
}
