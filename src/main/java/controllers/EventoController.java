package controllers;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class EventoController {
	
	private Map<String,Object> model=new HashMap<>(); 

	
	
	
	public ModelAndView mostrarTodos(Request req, Response res) {
 		ModelAndView vista= new ModelAndView(model,"guardarropa.hbs");
		
		return vista;
	}

}
