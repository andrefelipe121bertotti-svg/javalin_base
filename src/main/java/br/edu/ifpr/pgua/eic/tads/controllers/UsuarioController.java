package br.edu.ifpr.pgua.eic.tads.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifpr.pgua.eic.tads.models.Restaurante;
import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;
import io.javalin.http.Context;

public class UsuarioController {
    

    private Restaurante restaurante;

    public UsuarioController(Restaurante restaurante){
        this.restaurante = restaurante;
    }

    public void get(Context ctx){
        System.out.println("Renderizando cadastro.html");
        ctx.render("/usuarios/cadastro.html");
    }

    public void post(Context ctx){
        String nome = ctx.formParam("nome");
        String cpf = ctx.formParam("cpf");
        String email = ctx.formParam("email");
        String telefone = ctx.formParam("telefone");

        Boolean ret = restaurante.cadastrarUsuario(nome, email, telefone, cpf);

        String mensagem;
        if(ret){
            mensagem = "Usuário cadastrado com sucesso!";
        }else{
            mensagem = "Erro ao cadastrar usuário!";
        }


        Map<String,Object> dados = new HashMap<>();

        dados.put("mensagem",mensagem);

        ctx.render("/usuarios/cadastro.html",dados);
    }

    public void listar(Context ctx){

        ArrayList<Usuario> usuarios = restaurante.getUsuarios();

        Map<String,Object> dados = Map.of("usuarios",usuarios);

        ctx.render("/usuarios/lista.html",dados);
    }

}
