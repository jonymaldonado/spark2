package controllers;


import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class PrincipalController {
	private Map<String,Object> model=new HashMap<>(); 


	public PrincipalController(){
		
	}
	
	public ModelAndView mostrarPaginaPrincipal(Request req, Response res) {
 		ModelAndView vista= new ModelAndView(model,"index.hbs");
		
		return vista;
	}
	
	public ModelAndView insertarUsuario(Request req, Response res) {
 		ModelAndView insertar= new ModelAndView(model,"usuario.hbs");
		
		return insertar;
	}
	
	public ModelAndView ingresarUsuario(Request req, Response res) {
 		ModelAndView ingresar= new ModelAndView(model,"usuario_ingreso.hbs");
		
		return ingresar;
	}



}
