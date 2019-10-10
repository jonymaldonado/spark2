package server;

import controllers.UsuarioController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
    	
    	UsuarioController usuarioController=new UsuarioController();
    	
    	//Spark.get("/saludo",(req,res)->"Hola");
    	Spark.get("/saludo/:nombre",usuarioController::saludo);
    	//Spark.get("/saludo/:nombre",(req,res)->"Hola "+ req.params("apellido")+" "+req.params("nombre"));
    	Spark.get("/saludo",(req,res)->"Hola "+ req.queryParams("apellido")+" "+req.queryParams("nombre"));
    	//Spark.get("/saludo/*/:nombre",(req,res)->"Hola "+ req.splat()[0]+" "+req.params("nombre"));
    	
    	Spark.get("/usuarios", usuarioController::mostrartodos,Router.engine);
    	Spark.get("/usuarios/:id", usuarioController::mostrar,Router.engine);
    	Spark.post("/usuarios/:id", usuarioController::modificar);
    	

    }
}
