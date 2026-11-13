package br.edu.ifpr.pgua.eic.tads.models.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;

public interface UsuarioDao {

    public Resultado<Usuario> criar(Usuario u);
    public Resultado<Usuario> atualizar(Usuario u);
    public Resultado<List<Usuario>> listar();
    public Resultado<Usuario> buscarId(int id);
    public Resultado<Usuario> remover(int id);
    
}
