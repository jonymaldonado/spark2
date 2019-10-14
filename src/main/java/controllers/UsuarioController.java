package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Usuario;
import repositories.RepositorioUsuario;
import repositories.factories.FactoryRepositorioUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class UsuarioController {
	private RepositorioUsuario repo;
	
	public UsuarioController() {
		this.repo= FactoryRepositorioUsuario.get();
	}
	
	
	public String saludo(Request request,Response response) {
		String nombre = request.params("nombre");
		String saludo = "Hola " + nombre;
		return saludo;
	}
	
	public ModelAndView mostrartodos(Request request,Response response) {
		
 		List<Usuario> usuarios = this.repo.buscarTodos();
 		Map<String, Object> parametros= new HashMap<>();
 		parametros.put("usuarios", usuarios);
 		
 		ModelAndView vista= new ModelAndView(parametros, "usuarios.hbs");
		
		return vista;
		
	}
	
	
	public ModelAndView mostrar(Request request,Response response) {
		int idUsers=new Integer(request.params("id"));
		Usuario usuarioBuscado=this.repo.buscar(idUsers);
		//List<Usuario> usuarios = this.repo.buscarTodos();
		Map<String, Object> parametros= new HashMap<>();
		parametros.put("usuario", usuarioBuscado);
		parametros.put("id", idUsers);
		
 		ModelAndView vista= new ModelAndView(parametros, "usuario.hbs");
		
		return vista;
	}
	public Response modificar(Request request,Response response) {
		
		int id=new Integer(request.params("id"));
		Usuario usuarioBuscado=this.repo.buscar(id);
		
		String nombre=request.queryParams("nombre");
		usuarioBuscado.setNombre(nombre);
		
		
		String telefonoString=request.queryParams("telefono");
		if (!telefonoString.isEmpty()) {
			int telefono = new Integer(telefonoString);
			usuarioBuscado.setTelefono(telefono);
		}
		this.repo.modificar(usuarioBuscado);
		response.redirect("/usuarios");
        return response;

	}
	
}
