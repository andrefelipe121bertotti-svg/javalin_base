package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.models.FabricaConexoes;
import br.edu.ifpr.pgua.eic.tads.models.daos.MinhasInterfaces;
import br.edu.ifpr.pgua.eic.tads.models.daos.UsuarioDaoImpl;
import br.edu.ifpr.pgua.eic.tads.models.daos.UsuarioDao;
import br.edu.ifpr.pgua.eic.tads.models.daos.UsuarioDaoImpl;
import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;

public class TesteDB {
    public static void main(String[] args) {
    UsuarioDao dao = new UsuarioDaoImpl(FabricaConexoes.getInstance());
    
    dao.criar(new Usuario("123.456","Zé", "ze@teste.com", "(41)1234",0));
       
    }
}