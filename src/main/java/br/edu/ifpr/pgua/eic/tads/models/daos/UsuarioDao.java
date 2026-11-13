package br.edu.ifpr.pgua.eic.tads.models.daos;

import java.util.List;

import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;

public interface UsuarioDao {

    public Usuario criar(Usuario u);
    public Usuario atualizar(Usuario u);
    public List<Usuario> listar();
    public Usuario buscarId(int id);
    public Usuario remover(int id);
    
}
