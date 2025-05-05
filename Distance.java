import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Distance extends Remote {
  public String euclidean(double[] a, double[] b, double[] c) throws RemoteException;
  public String cityBlock(double[] a, double[] b, double[] c) throws RemoteException;
}