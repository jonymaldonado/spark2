package server;

import spark.Spark;
import spark.debug.DebugScreen;
// es el que va a levantar el servidor
public class Server {
	public static void main(String[] args) {
		Spark.port(9000);// es donde me dice en que puerto se comunicara 
		Router.init();
		DebugScreen.enableDebugScreen();//es para que me aparezca los errores en la vista, deberia estar comentado
	}
}
