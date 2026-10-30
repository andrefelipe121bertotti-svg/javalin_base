package br.edu.ifpr.pgua.eic.tads.controllers;

import br.edu.ifpr.pgua.eic.tads.models.Restaurante;
import io.javalin.http.Context;

public class FuncionarioController {
    

    private Restaurante restaurante;

    public FuncionarioController(Restaurante restaurante){
        this.restaurante = restaurante;
    }

    public void get(Context ctx){
        ctx.render("funcionarios/cadastro.html");
    }

    public void post(Context ctx){
        String nome = ctx.formParam("nome");
        String email = ctx.formParam("email");
        String cpf = ctx.formParam("cpf");
        Double salario = Double.valueOf(ctx.formParam("salario"));
        String turno = ctx.formParam("turno");
        String cargo = ctx.formParam("cargo");

        String ret = restaurante.cadastrarFuncionario(nome, email, cpf, salario, cargo, turno);

        ctx.result(ret);
    }

}
