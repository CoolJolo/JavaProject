package javaSocketApp;
import javaSocketApp.gui.WindowClass;
import javaSocketApp.server.ServerClass;

// Java App, which manage everything
public class App {
    public static void main(String[] args) {
        WindowClass window = new WindowClass();
	    window.windowConstructor("first", "Actions:");

        ServerClass server = null;

        // only start server/session when server not already locally exist
        // not work properly
        if (server != null) {
            System.out.println("Server exist!");
        } else {
            // to add: when "StartSession"-Button in Window-Object pressed, start Server-Object
            System.out.println("Server was created!");
            server = new ServerClass();
            server.serverConstructor(1337, window);
        }
    }
}
