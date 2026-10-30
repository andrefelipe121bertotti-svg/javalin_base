package br.edu.ifpr.pgua.eic.tads.models.entities;
import java.time.LocalDateTime;

public class Operacao {
    
    private LocalDateTime dataHora;
    private double valor;
    private String tipoOperacao;

    public Operacao(String tipoOperacao, double valor){
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
        this.dataHora = LocalDateTime.now();
    }

    public String toString(){
        return this.dataHora+"-"+this.tipoOperacao+" R$ "+this.valor;
    }



}
