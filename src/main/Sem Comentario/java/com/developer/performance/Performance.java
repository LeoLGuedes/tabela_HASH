package com.developer.performance;

import com.developer.tabela_hash.Registro;
import com.developer.tabela_hash.TabelaHash;

import java.io.IOException;

public class Performance {
    private TabelaHash tabela;
    private String nomeTabela;
    private int tamanhoTabela;
    private int quantidadeDados;
    private String hash_escolhido;
    private String filename;
    private CSVlog csvlog;
    private CSVlog csvstats;

    public Performance(TabelaHash tabela, int quantidadeDadosInserir) throws IOException {
        this.tabela = tabela;
        this.nomeTabela = tabela.getClass().getSimpleName();
        this.tamanhoTabela = tabela.getTamanho();
        this.quantidadeDados = quantidadeDadosInserir;
        this.hash_escolhido = tabela.getHash();
        this.filename = nomeTabela + "_T" + tamanhoTabela + "_D" + quantidadeDadosInserir + "_H" + hash_escolhido +".csv";
        csvlog = new CSVlog(filename);
        csvlog.inserirHeader("operacao,dado,tempo_ns,colisoes");
        csvstats = new CSVlog("stats_" + filename);
    }

    public void medirInsercao(Registro[] dados) throws IOException {
        System.out.println(this.nomeTabela);
        int colisoes;
        for (int i = 0; i < quantidadeDados; i++) {
            long inicio = System.nanoTime();
            colisoes = tabela.inserir(dados[i]);
            long fim = System.nanoTime();
            long tempoTotal = fim - inicio;
            csvlog.inserirLinha("INSERCAO" + "," + dados[i] + "," + tempoTotal + "," + colisoes);
        }
    }

    public void medirBusca(Registro[] dados) throws IOException {
        System.out.println(this.nomeTabela);
        for (int i = 0; i < quantidadeDados; i++) {
            long inicio = System.nanoTime();
            tabela.buscar(dados[i]);
            long fim = System.nanoTime();
            long tempoBusca = fim - inicio;
            csvlog.inserirLinha("BUSCA" + "," + dados[i] + "," + tempoBusca + "," + 0);
        }
    }

    public void analisarEstatisticas(String header) throws IOException {
        int[] stats = tabela.calcularStats();
        csvstats.inserirHeader(header);
        String str_stats = "" + stats[0];
        for (int i = 1; i < stats.length; i++) {
            str_stats += "," + stats[i];
        }
        csvstats.inserirLinha(str_stats);
    }

}
