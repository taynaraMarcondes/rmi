import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends Distancemeter {
  public Server () {}

  public static void main(String args[]) {
    try {
      System.setProperty("java.rmi.hostname","localhost");
      Distancemeter obj = new Distancemeter();
      Distance stub = (Distance) UnicastRemoteObject.exportObject(obj, 0);
      Registry registry = LocateRegistry.createRegistry(1099);
      registry.rebind("Distance", stub);
      System.err.println("Servidor Pronto!");
    } catch (Exception e) {
      System.err.println("Erro no Servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}