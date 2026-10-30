package br.edu.ifpr.pgua.eic.tads.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.pgua.eic.tads.models.entities.Funcionario;
import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;

public class Restaurante {
    
    
    private ArrayList<Usuario> usuarios;

    private ArrayList<Funcionario> funcionarios;

    public Restaurante(){
        usuarios = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }


    public Usuario buscarCpf(String cpf){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getCpf().equals(cpf)){
                return usuarios.get(i);
                
            }
        }
        return null;
    }

    public Usuario buscarEmail(String email){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getEmail().equals(email)){
                return usuarios.get(i);
            }
        }
        return null;
    }

    public boolean cadastrarUsuario(String nome, String email, 
                                    String telefone, String cpf){
        
        String url = "jdbc:sqlite:app.db";


        try(Connection con=DriverManager.getConnection(url)){

            String sql = "INSERT INTO oo_usuario(nome,cpf,telefone,email) VALUES (?,?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2,cpf);
            pstm.setString(3, telefone);
            pstm.setString(4, email);

            int ret = pstm.executeUpdate();
            return true;


        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
    }

    public Funcionario buscarFuncionarioCpf(String cpf){
        for(Funcionario f:funcionarios){
            if(f.getCpf().equals(cpf)){
                return f;
            }
        }
        return null;
    }


    public String cadastrarFuncionario(int ID, String nome, String email, String cpf,
                                       double salario, String cargo, String turno
    ){

        if(buscarFuncionarioCpf(cpf) == null){
            Funcionario f = new Funcionario(Id, nome, email, cpf,salario, cargo, turno);
            funcionarios.add(f);
            return "Funcionário cadastrado!";
        }
        return "Funcionário não cadastrado!";
    }

    public String listarFuncionarios(){
        String texto = "";

        for(Funcionario f:funcionarios){
            texto += f.toString()+"\n";
        }
        return texto;
    }


    public String depositar(String cpf, double valor){
        Usuario usuario = buscarCpf(cpf);
        if(usuario == null){
            return "Usuário não encontrado!";
        }
        if(valor <= 0){
            return "Valor inválido!";
        }

        if(usuario.inserirCredito(valor)){
            return "Depósito realizado!";
        }else{
            return "Valor inválido!";
        }
    }

    public String consumir(String cpf, double valor){
        Usuario usuario = buscarCpf(cpf);
        if(usuario == null){
            return "Usuário não encontrado!";
        }
        if(valor <= 0){
            return "Valor inválido!";
        }

        if(usuario.consumirRefeicao(valor)){
            return "Depósito realizado!";
        }else{
            return "Valor inválido!";
        }
    }

    public String gerarExtrato(String cpf){
        Usuario usuario = buscarCpf(cpf);
        if(usuario == null){
            return "Usuário não encontrado!";
        }
        return usuario.gerarExtrato();
    }


    public ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();

        String url = "jdbc:mysql:app.db";

        try(Connection con=DriverManager.getConnection(url)){
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

    public String listar(){

        String texto="Usuários Cadastrados\n";

        for(int i=0;i<usuarios.size();i++){
            texto += usuarios.get(i).toString()+"\n";
            
            
        }
        return texto;

    }


}
