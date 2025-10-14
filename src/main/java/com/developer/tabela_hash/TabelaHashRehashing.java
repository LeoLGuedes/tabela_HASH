package com.developer.tabela_hash;

public class TabelaHashRehashing extends TabelaHash {
    private Registro[] tabela;


    public TabelaHashRehashing(int tamanho, int numero_digitos, String hash) {
        super(tamanho, numero_digitos, hash);
        tabela = new Registro[tamanho];
    }

    @Override
    public int calcularHash(int valor) {
        switch (hash) {
            case "mod": // Resto da divisão
                return valor % tamanho;

            case "mult": // Multiplicação de Knuth
                double CK = 0.6180339887; // constante de Knuth (fração de Golden Ratio)
                double frac = (valor * CK) % 1;
                return (int)(tamanho * frac);

            case "fold": // Folding (soma de partes do número)
                int soma = 0;
                int temp = valor;
                while (temp > 0) {
                    soma += temp % 1000;  // pega os últimos 3 dígitos
                    temp /= 1000;         // remove os últimos 3 dígitos
                }
                return soma % tamanho;    // ajusta ao tamanho da tabela

            default:
                return valor % tamanho; // resto
        }
    }

    public int calcularHashBusca(int valor) {
        int hash = valor % tamanho;
        return calcularHashBusca(valor, hash); // Rehash
    }

    public int calcularHashBusca(int valor, int hash) {
        hash = hash % tamanho;
        if (tabela[hash].getValor() == valor) {
            return hash;
        }
        return calcularHashBusca(valor, hash + 1); // Rehash

    }

    @Override
    public int inserir(int valor) {
        int hash = calcularHash(valor);
        tabela[hash] = new Registro(valor, numero_digitos);
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
