package br.edu.ifpr.pgua.eic.tads.models.entities;
import java.time.LocalDateTime;

public class Operacao {
    
    private int id;
    private LocalDateTime dataHora;
    private double valor;
    private String tipoOperacao;
    private Usuario usuario;

    public Operacao(String tipoOperacao, double valor){
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
        this.dataHora = LocalDateTime.now();
    }

    public Operacao(int id, String tipoOperacao, double valor, LocalDateTime dataHora, Usuario usuario){
        this.id = id;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.dataHora = dataHora;
        this.usuario = usuario;
    }

    public String toString(){
        return this.dataHora+"-"+this.tipoOperacao+" R$ "+this.valor;
    }



}
