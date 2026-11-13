package br.edu.ifpr.pgua.eic.tads.models.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;

public interface UsuarioRepository {
    
    public Resultado<Usuario> criar(String nome, String cpf, String email, String telefone);
    public Resultado<List<Usuario>> listar();    
}
