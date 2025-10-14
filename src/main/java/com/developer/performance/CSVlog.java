package com.developer.performance;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVlog {
    private String fileName;
    private boolean header;

    public CSVlog(String fileName) {
        this.fileName = fileName;
        this.header = false;
    }

    public void inserirHeader(String header) throws IOException {
        if (!this.header) {
            FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(header);
            pw.flush();
            pw.close();
            this.header = true;
        }
    }

    public void inserirLinha(String linha) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(linha);
        pw.flush();
        pw.close();
    }
}