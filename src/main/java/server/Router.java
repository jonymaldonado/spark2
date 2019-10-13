package server;

import org.eclipse.jetty.server.Response;
import org.hibernate.jpa.boot.scan.spi.PackageInfoArchiveEntryHandler;

import controllers.PrincipalController;
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
    	PrincipalController paginaController=new PrincipalController();
    	
    	//Spark.get("/saludo",(req,res)->"Hola");
    	Spark.get("/saludo/:nombre",usuarioController::saludo);
    	//Spark.get("/saludo/:nombre",(req,res)->"Hola "+ req.params("apellido")+" "+req.params("nombre"));
    	//Spark.get("/saludo",(req,res)->"Hola "+ req.queryParams("apellido")+" "+req.queryParams("nombre"));
    	//Spark.get("/saludo/*/:nombre",(req,res)->"Hola "+ req.splat()[0]+" "+req.params("nombre"));
    	
    	Spark.get("/usuarios", usuarioController::mostrartodos,Router.engine);
    	Spark.get("/usuarios/:id", usuarioController::mostrar,Router.engine);
    	Spark.post("/usuarios/:id", usuarioController::modificar);
    	Spark.get("/ingresarUsuario.", usuarioController::mostrartodos,Router.engine);
    	Spark.get("/index", paginaController::mostrarPaginaPrincipal, Router.engine);
    	Spark.get("/insertarUsuario", paginaController::insertarUsuario,Router.engine);
    	Spark.get("/ingresarUsuario", paginaController::ingresarUsuario,Router.engine);
    	Spark.get("/", paginaController::mostrarPaginaPrincipal, Router.engine);

    	

    }
}
