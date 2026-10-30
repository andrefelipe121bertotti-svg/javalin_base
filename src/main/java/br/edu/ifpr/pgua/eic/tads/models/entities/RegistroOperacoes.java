package br.edu.ifpr.pgua.eic.tads.models.entities;

import java.util.ArrayList;

public class RegistroOperacoes {
    private static final int MAX = 50; //constante
    private ArrayList<Operacao> operacoes;
    private int posicaoLivre;

    public RegistroOperacoes(){
        this.operacoes = new ArrayList<>();
        this.posicaoLivre = 0;
    }

    public boolean registrar(String tipoOperacao, double valor){

        this.operacoes.add(new Operacao(tipoOperacao,valor));
        return true;
        
    }

    public String listar(){
        String texto="";

        /*for(int i=0;i<operacoes.size();i++){
            Operacao operacao = operacoes.get(i);
            texto = texto +"\n"+operacao.toString();
        }*/
       
        //foreach
        for(Operacao operacao:operacoes){
            texto = texto +"\n"+operacao.toString();
        }

        return texto;
    }

}
