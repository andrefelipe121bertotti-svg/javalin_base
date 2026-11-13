package br.edu.ifpr.pgua.eic.tads.models.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.models.FabricaConexoes;
import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{

    private FabricaConexoes fabrica;

    public UsuarioDaoImpl(FabricaConexoes fabrica){
        this.fabrica = fabrica;
    }


    @Override
    public Resultado<Usuario> atualizar(Usuario u) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Resultado<Usuario> buscarId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Resultado<Usuario> criar(Usuario u) {
        
        String sql = "INSERT INTO oo_usuario(nome,cpf,email,telefone) VALUES (?,?,?,?)";

        try(Connection con=fabrica.getConnection()){
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, u.getNome());
            pstm.setString(2, u.getCpf());
            pstm.setString(3, u.getEmail());
            pstm.setString(4, u.getTelefone());

            pstm.executeUpdate();

            return Resultado.sucesso("Usuario cadastrado!", u);

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Resultado.erro(e.getMessage());
        }

    }

    @Override
    public Resultado<List<Usuario>> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();

        try(Connection con=fabrica.getConnection()){
            String sql = "SELECT * FROM oo_usuario";

            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");

                Usuario u = new Usuario(id, nome, email, cpf, telefone);

                lista.add(u);
            }

            return lista;
        }catch(SQLException e){
            System.out.println("Erro ao listar usuarios..."+e.getMessage());
            return null;
        }

    }

    @Override
    public Resultado<Usuario> remover(int id) {
        // TODO Auto-generated method stub
        return null;
    }


    
}
