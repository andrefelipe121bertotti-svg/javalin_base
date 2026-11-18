package br.edu.ifpr.pgua.eic.tads.models.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.models.entities.Operacao;

public interface OperacaoDao {
    
    public Resultado<Operacao> criar(Operacao op);
    public Resultado<List<Operacao>> listarOperacoesUsuario(int idUsuario);

}
