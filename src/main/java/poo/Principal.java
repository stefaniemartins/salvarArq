package poo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {
    public void escrever(String linha){
        String nomeArquivo = "teste.txt";

        File arquivo = new File(nomeArquivo);
        FileWriter fwArquivo  = null;

        BufferedWriter bw = null;

        try{
            fwArquivo = new FileWriter(arquivo, true);
            bw = new BufferedWriter(fwArquivo);
            bw.write(linha + "\n");
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        p.escrever("Olá mundo");
    }
}
