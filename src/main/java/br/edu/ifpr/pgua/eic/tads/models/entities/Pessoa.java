package br.edu.ifpr.pgua.eic.tads.models.entities;

public class Pessoa {
    protected int Id;
    protected String nome;
    protected String email;
    protected String cpf;



    public Pessoa(int Id, String nome, String email, String cpf) {
        this.Id = Id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", email=" + email + ", cpf=" + cpf + "]";
    }



    public int getId() {
        return Id;
    }
    
    
}
