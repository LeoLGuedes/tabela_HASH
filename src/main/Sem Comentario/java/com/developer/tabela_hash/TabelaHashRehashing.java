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
    public int[] calcularHash(int valor) {
        int colisoes = 0;
        int hash = calcularHashSimples(valor);
        if(tabela[hash] != null) {
            colisoes++;
            int[] rehash = calcularRehash(hash, colisoes);
            hash = rehash[0];
            colisoes = rehash[1];
        }
        return new int[]{hash, colisoes};
    }

    public int[] calcularRehash(int valor, int colisoes){
        valor = calcularHashSimples(valor + 1);
        if(tabela[valor] == null) {
            return new int[]{valor, colisoes};
        }
        colisoes++;
        return calcularRehash(valor, colisoes);


    }

    public int calcularHashBusca(int valor) {
        int hash = calcularHashSimples(valor);
        return calcularHashBusca(valor, hash);
    }

    public int calcularHashBusca(int valor, int hash) {
        if (tabela[hash] != null) {
            if (tabela[hash].valor == valor) {
                return hash;
            }
        }

        return calcularHashBusca(valor, (hash + 1)%tamanho);

    }

    public boolean isCheia() {
        return ((double) capacidade / tabela.length) >= taxaCheio;
    }

    public void dobrarTabela() {
        tamanho *= 2;
        Registro[] antiga = tabela;
        tabela = new Registro[tamanho];
        for(Registro registro : antiga) {
            if(registro != null) {
                tabela[calcularHash(registro.valor)[0]] = registro;
            }
        }
    }

    @Override
    public int inserir(int valor) {
        if (isCheia()){
            dobrarTabela();
        }
        int[] hash = calcularHash(valor);
        tabela[hash[0]] = new Registro(valor, numero_digitos);
        capacidade++;
        return hash[1];
    }

    @Override
    public int inserir(Registro valor) {
        if (isCheia()){
            dobrarTabela();
        }
        int[] hash = calcularHash(valor.valor);
        tabela[hash[0]] = valor;
        capacidade++;
        return hash[1];
    }

    @Override
    public Registro buscar(int valor) {
        int hash = calcularHashBusca(valor);
        return tabela[hash];
    }

    @Override
    public Registro buscar(Registro valor) {
        int hash = calcularHashBusca(valor.valor);
        return tabela[hash];
    }

    @Override
    public int[] calcularStats() {
        return new int[0];
    }
}
