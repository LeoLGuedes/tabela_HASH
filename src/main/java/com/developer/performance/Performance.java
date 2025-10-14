package com.developer.performance;

import com.developer.tabela_hash.TabelaHash;

import java.io.IOException;

public class Performance {
    private TabelaHash tabela;
    private String nomeTabela;
    private int tamanhoTabela;
    private int quantidadeDados;
    private CSVlog csvlog;
    private CSVlog csvstats;

    public Performance(TabelaHash tabela, int quantidadeDadosInserir) throws IOException {
        nomeTabela = tabela.getClass().getSimpleName();
        tamanhoTabela = tabela.getTamanho();
        quantidadeDados = quantidadeDadosInserir;
        String filename = nomeTabela + "_T" + tamanhoTabela + "_D" + quantidadeDadosInserir +".csv";
        csvlog = new CSVlog(filename);
        csvlog.inserirHeader("operacao,dados,tempo_ns,colisoes");
        csvstats = new CSVlog("stats_" + filename);
    }

    public long medirInsercao(int[] dados) throws IOException {
        long inicio = System.nanoTime();
        int colisoes = 0;
        for (int i = 0; i < quantidadeDados; i++) {
            colisoes += tabela.inserir(dados[i]);
        }
        long fim = System.nanoTime();
        long tempoTotal = fim - inicio;
        csvlog.inserirLinha("INSERCAO" + "," + quantidadeDados + "," + tempoTotal + "," + colisoes);
        return tempoTotal;
    }

    public long medirBusca(int[] dados) throws IOException {
        long inicio = System.nanoTime();
        for (int i = 0; i < quantidadeDados; i++) {
            tabela.buscar(dados[i]);
        }
        long fim = System.nanoTime();
        long tempoBusca = fim - inicio;
        csvlog.inserirLinha("BUSCA" + "," + quantidadeDados + "," + tempoBusca + "," + 0);
        return tempoBusca;
    }

    public void analisarEstatisticas(String header) throws IOException {
        int[] stats = tabela.calcularStats(); // [gap_min, gap_max, gap_media, 1_listaEncadeada, 2_listaEncadeada, 3_listaEncadeada]
        csvlog.inserirHeader(header);
        String str_stats = "ESTATISTICAS";
        for (String coluna : header.split(",")){
            str_stats += "," + coluna;
        }
        csvlog.inserirLinha(str_stats);
    }

}
