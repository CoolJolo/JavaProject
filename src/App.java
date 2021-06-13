// Java App, which manage everything
public class App {
    public static void main(String[] args) {
        WindowClass window = new WindowClass();
	    window.windowConstructor("first", "Actions:");

        ServerClass server = null;

        if (server != null) {
            System.out.println("Server exist!");
        } else {
            System.out.println("Server was created!");
            server = new ServerClass();
            server.serverConstructor(1337, window);
        }
    }
}
