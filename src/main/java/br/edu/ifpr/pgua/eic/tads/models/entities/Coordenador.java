package br.edu.ifpr.pgua.eic.tads.models.entities;

public class Coordenador extends Funcionario{
    
    private double adicional;

    public Coordenador(String nome, String email,
                       String cpf, double salario,
                       String cargo, String turno, double adicional){
        
        super(nome,email,cpf,salario,cargo,turno);

        this.adicional = adicional;
    }

    public double getAdicional() {
        return adicional;
    }

    public void setAdicional(double adicional) {
        this.adicional = adicional;
    }

    @Override 
    public double calcularSalario(){
        System.out.println("---Classe Coordenador");
        return super.calcularSalario()+adicional;
    }

    @Override
    public String toString() {
        return "Coordenador ["+super.toString()+", adicional=" + adicional + "]";
    }

    


}
