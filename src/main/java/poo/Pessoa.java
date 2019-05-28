package poo;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String email;
    private double salario;

    public Pessoa(String nome, String email, double salario) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nEmail: " + email + "\nSalário: " + salario;
    }
}
