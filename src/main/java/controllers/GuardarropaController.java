package controllers;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class GuardarropaController {
	
	private Map<String,Object> model=new HashMap<>(); 

	
	
	
	public ModelAndView mostrarGuardarropasUsuario(Request req, Response res) {
 		ModelAndView vista= new ModelAndView(model,"index.hbs");
		
		return vista;
	}
















}
