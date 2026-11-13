package br.edu.ifpr.pgua.eic.tads.models.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.models.daos.UsuarioDao;
import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;

public class UsuarioRepositoryImpl implements UsuarioRepository{

    private UsuarioDao dao;

    public UsuarioRepositoryImpl(UsuarioDao dao){
        this.dao = dao;
    }

    @Override
    public Resultado<Usuario> criar(String nome, String cpf, String email, String telefone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criar'");
    }

    @Override
    public Resultado<List<Usuario>> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }
    
}
