package br.edu.ifpr.pgua.eic.tads.controllers;

import io.javalin.http.Context;

public class IndexController {
    
    public void QuartoThif(Context ctx ){

        ctx.render("index.html");
    } 

}
