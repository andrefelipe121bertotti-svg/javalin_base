package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        var app = JavalinUtils.makeApp(8090);

         IndexController indexController = new IndexController();

        
        app.get("/",indexController::(get));
        app.get("/teste",ctx->{ctx.result("Testando, testando, vc congueme ouvir... digo ler?");});
        app.get("/bem_vindo",ctx->{ctx.result("BEM-VINDO, caro espequitador. Eu sou Thiffany e serei sua anfitria.");});
        app.get("/bem_vindoV2",ctx->{ctx.result("duplicada~");});
       

    }
}
