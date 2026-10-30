package br.edu.ifpr.pgua.eic.tads.models.entities;

public final class Usuario extends Pessoa{

    //atributos

    private String telefone;
    private double saldo;
    
    private RegistroOperacoes movimentacoes;

    public Usuario(String cpf, String pnome, String pemail, String ptelefone, double psaldo){
        
        super(pnome,pemail,cpf);

        telefone = ptelefone;
        saldo = psaldo;
        
        this.movimentacoes = new RegistroOperacoes();
    }

    public String getTelefone(){
        return telefone;
    }
    
    public boolean inserirCredito(double valor){
        if(valor > 0){
            saldo = saldo + valor;
            movimentacoes.registrar("crédito", valor);
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
            movimentacoes.registrar("débito", valor);
            return true;
        }
        return false;
    }

    public String gerarExtrato(){
        return movimentacoes.listar();
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
