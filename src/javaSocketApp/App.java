package javaSocketApp;
import javaSocketApp.gui.WindowClass;
import javaSocketApp.server.ServerClass;

// LUL

// Java App, which manage everything
public class App {
    public static void main(String[] args) {
        WindowClass window = new WindowClass();
	    window.windowConstructor("first", "Actions:", this);

        ServerClass server = null;

        // only start server/session when server not already locally exist
        // not work properly
        if (server != null) {
            System.out.println("Server exist!");
        } else {
            // to add: when "StartSession"-Button in Window-Object pressed, create Server-Object
            server = new ServerClass();
            server.serverConstructor(1337, window);
            System.out.println("Server was created!");
        }
    }


}