package br.edu.ifpr.pgua.eic.tads.models.entities;


public class Funcionario extends Pessoa {
    
    private double salario;
    private String cargo;
    private String turno;
    
    public Funcionario(String nome, String email,
                       String cpf, double salario,
                       String cargo, String turno){

        super(nome,email,cpf);

        this.cargo = cargo;
        this.turno = turno;
        this.salario = salario;
    }

    public Funcionario(String nome, String email,
                       String cpf,String cargo, String turno){
        
        this(nome,email,cpf,0.0,cargo,turno);
        /*this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.turno = turno;
        this.cargo = cargo;*/

    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double calcularSalario(){
        System.out.println("---Classe Funcionario");
        return salario;
    }

    @Override
    public String toString() {
        
        //usando os métodos get definidos na super classe Pessoa
        //return "Funcionario [nome=" + getNome() + ", email=" + getEmail() + ", cpf=" + getCpf() + ", salario=" + salario + ", cargo="
        //        + cargo + ", turno=" + turno + "]";
        
        //invocando o método toString da super classe Pessoa
        return "Funcionario ["+super.toString()+", salario=" + salario + ", cargo="
                + cargo + ", turno=" + turno + "]";

        //definindo nome, email e cpf como protected na super classe Pessoa
        //return "Funcionario [nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", salario=" + salario + ", cargo="
        //        + cargo + ", turno=" + turno + "]";
        
        
    }

    


}
