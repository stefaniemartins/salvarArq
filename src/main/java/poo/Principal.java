package poo;

import java.io.*;
import java.util.Scanner;

public class Principal {
    public void escrever(String linha){
        String nomeArquivo = "teste.txt";

        File arquivo = new File(nomeArquivo);
        FileWriter fwArquivo  = null;

        BufferedWriter bw = null;

        try{
            fwArquivo = new FileWriter(arquivo, arquivo.exists());
            bw = new BufferedWriter(fwArquivo);
            bw.write(linha + "\n");
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void imprimirConteudoArquivo(String nomeArquivo){
        File arquivo = new File(nomeArquivo);

        try {
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNext()){
                String linha = leitor.nextLine();
                System.out.println(linha);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void salvarPessoa(Pessoa p, String nomeArquivo){
        File arquivo = new File(nomeArquivo);

        try{
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(p);

            oos.flush(); // Descarregar o buffer.
            oos.close();
            fout.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pessoa lerPessoaDoDisco(String nomeArquivo){
        File arquivo = new File(nomeArquivo);

        try {
            FileInputStream fis =  new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);


            Pessoa p = (Pessoa) ois.readObject();

            ois.close();
            fis.close();

            return p;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.escrever("Olá mundo");
        principal.imprimirConteudoArquivo("teste.txt");

        Pessoa pessoa = new Pessoa("Maria","maria@gmail.com", 1200);
        Pessoa pessoa2 = new Pessoa("João", "joao@gmail.com",1000);

        principal.escrever(pessoa.toString());
        principal.escrever(pessoa2.toString());
//        principal.imprimirConteudoArquivo("teste.txt");

        // TESTE
//        String linha = "Pessoa(nome='João', email='jo@aem.com, salario=120.00)";
//        String[] vetor = linha.split((","));
//          vetor[0] = Pessoa(nome
//          vetor[1] = 'João', email
//          vetor[2] =
//
//        principal.salvarPessoa(pessoa,"teste.dat");
//        principal.salvarPessoa(pessoa2, "teste.dat");
//        principal.imprimirConteudoArquivo("teste.txt");
        Pessoa pessoa3 = principal.lerPessoaDoDisco("teste.dat");
        System.out.println(pessoa3);
    }
}
