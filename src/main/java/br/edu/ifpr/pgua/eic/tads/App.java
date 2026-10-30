package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.FuncionarioController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.controllers.UsuarioController;
import br.edu.ifpr.pgua.eic.tads.models.Restaurante;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {

    private static void povoarUsuarios(Restaurante restaurante){
        for(int i=0;i<10;i++){
            String nome = "Usuario "+i;
            String email = "usuario"+i+"@teste.com";
            String cpf = "123.456.789-"+i;
            String telefone = "123-11"+i;

            restaurante.cadastrarUsuario(nome, email, telefone, cpf);
        }
    }


    public static void main( String[] args ){
        var app = JavalinUtils.makeApp(8080);
        
        Restaurante restaurante = new Restaurante();
        povoarUsuarios(restaurante);

        IndexController indexController = new IndexController();
        UsuarioController usuariosController = new UsuarioController(restaurante);
        FuncionarioController funcionariosController = new FuncionarioController(restaurante);
        
        app.get("/", indexController::get);

        app.get("/usuarios/cadastro",usuariosController::get);
        app.post("/usuarios/cadastro",usuariosController::post);
        app.get("/usuarios/listar",usuariosController::listar);

        app.get("/funcionarios/cadastro",funcionariosController::get);
        app.post("/funcionarios/cadastro",funcionariosController::post);

        
    }
}
