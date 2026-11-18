package br.edu.ifpr.pgua.eic.tads.models.entities;

import java.util.List;

public final class Usuario extends Pessoa{

    //atributos

    private String telefone;
    private double saldo;
    
    private List<Operacao> movimentacoes;

    public Usuario(int id, String nome, String email, String cpf, String telefone) {
        super(id, nome, email, cpf);
        this.telefone = telefone;
    }

    public Usuario(int id, String cpf, String pnome, String pemail, String ptelefone, double psaldo){
        
        super(id,pnome,pemail,cpf);

        telefone = ptelefone;
        saldo = psaldo;
        
    }


    public void setMovimentacoes(List<Operacao> movimentacoes){
        this.movimentacoes = movimentacoes;
    }

    public String getTelefone(){
        return telefone;
    }
    
    public boolean inserirCredito(double valor){
        if(valor > 0){
            saldo = saldo + valor;
            return true;
        }
        return false;
        
    }

    public double consultarCredito(){
        return saldo;
    }

    public boolean consumirRefeicao(double valor){
        if(valor > 0){
            saldo = saldo - valor;
            return true;
        }
        return false;
    }


    public String toString(){
        String str = "";

        str += "Nome:"+nome;
        str += " Email:"+email;
        str += " Telefone:"+telefone;
        str += " Saldo R$:"+saldo;

        return str;
    }

}
