package br.edu.ifpr.pgua.eic.tads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDB {
    public static void main(String[] args) {
        
        String url = "jdbc:sqlite:app.db;
        String username = "tads26_andrefelipe";
        String password = "Thiffany121";

        try(Connection con = DriverManager.getConnection(url,username,password);){
                     
            String nome = "Zé";
            String cpf = "123.456.789-00";
            String telefone = "12-456-78900";
            String email = "ze@teste.com";


            String sql = "INSERT INTO oo_usuarios(nome,cpf,telefone,email) VALUES (?,?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2,cpf);
            pstm.setString(3, telefone);
            pstm.setString(4, email);

            int ret = pstm.executeUpdate();

            if(ret == 1){
                System.err.println("inserção ugabuga");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}