package com.developer.performance;

import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class TranformacaoDadosJson {
    // Gerar um único JSON com tudo resumido
    public void converter() throws IOException {
        File pasta = new File("src/main/resources");
        JSONArray estruturasArray = new JSONArray();

        if (pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();
            for (File arquivo : arquivos) {
                if (arquivo.getName().endsWith(".csv")) {
                    // Extrair informações do nome do arquivo
                    String nomeArquivo = arquivo.getName().replace(".csv", "");
                    String[] partes = nomeArquivo.split("_");
                    String nomeClasse = partes[0];
                    int tamanhoTabela = Integer.parseInt(partes[1].substring(1));
                    int tamanhoDados = Integer.parseInt(partes[2].substring(1));
                    String hash = partes[3].substring(1);

                    BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                    String line = reader.readLine(); // header

                    long somaTempoInsercao = 0, minTempoInsercao = Long.MAX_VALUE, maxTempoInsercao = Long.MIN_VALUE;
                    int countInsercao = 0;
                    long somaTempoBusca = 0, countBusca = 0;

                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        String operacao = data[0];
                        long tempo = 0;
                        try{
                            tempo = Long.parseLong(data[2]);
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        if (operacao.equalsIgnoreCase("INSERCAO")) {
                            somaTempoInsercao += tempo;
                            if (tempo < minTempoInsercao) minTempoInsercao = tempo;
                            if (tempo > maxTempoInsercao) maxTempoInsercao = tempo;
                            countInsercao++;
                        } else if (operacao.equalsIgnoreCase("BUSCA")) {
                            somaTempoBusca += tempo;
                            countBusca++;
                        }
                    }
                    reader.close();

                    JSONObject estruturaObj = new JSONObject();
                    estruturaObj.put("nome_classe", nomeClasse);
                    estruturaObj.put("tamanho_tabela", tamanhoTabela);
                    estruturaObj.put("tamanho_dados", tamanhoDados);
                    estruturaObj.put("hash", hash);

                    JSONObject insercaoObj = new JSONObject();
                    insercaoObj.put("total", countInsercao);
                    insercaoObj.put("media_tempo_ns", countInsercao > 0 ? somaTempoInsercao / countInsercao : 0);
                    insercaoObj.put("min_tempo_ns", countInsercao > 0 ? minTempoInsercao : 0);
                    insercaoObj.put("max_tempo_ns", countInsercao > 0 ? maxTempoInsercao : 0);

                    JSONObject buscaObj = new JSONObject();
                    buscaObj.put("total", countBusca);
                    buscaObj.put("media_tempo_ns", countBusca > 0 ? somaTempoBusca / countBusca : 0);

                    estruturaObj.put("insercao", insercaoObj);
                    estruturaObj.put("busca", buscaObj);

                    estruturasArray.put(estruturaObj);
                    
                }
            }

            // Escrever o JSON geral
            JSONObject resultadoFinal = new JSONObject();
            resultadoFinal.put("estruturas", estruturasArray);

            FileWriter writer = new FileWriter("src/main/resources/result.json");
            writer.write(resultadoFinal.toString(4)); // identado
            writer.close();
        }
    }
}
