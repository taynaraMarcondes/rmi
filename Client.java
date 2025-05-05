import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.*;
import java.util.Scanner;

public class Client {
  public Client () {}
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      Distance stub = (Distance) Naming.lookup("Distance");

      double[] A = {5.1, 3.5, 1.4, 0.2};
      double[] B = {5.9, 3.0, 5.1, 1.8};
      double[] C = {4.9, 3.1, 1.5, 0.1};

      int op = 1;
      while (op != 0) {
        System.out.println("\t        |    Pétala (mm)   |    Sépala (mm)");
        System.out.println("\tObjeto  | Largura | Altura | Largura | Altura");
        System.out.println("\t   A    |   " + Double.toString(A[0]) + "   |   " + Double.toString(A[1]) +"  |   "+ Double.toString(A[2]) +"   |   "+ Double.toString(A[3]));
        System.out.println("\t   B    |   " + Double.toString(B[0]) + "   |   " + Double.toString(B[1]) +"  |   "+ Double.toString(B[2]) +"   |   "+ Double.toString(B[3]));
        System.out.println("\t   C    |   " + Double.toString(C[0]) + "   |   " + Double.toString(C[1]) +"  |   "+ Double.toString(C[2]) +"   |   "+ Double.toString(C[3]));
        
        System.out.println("\nDigite a opção desejada para calcular a distância entre os objetos da tabela acima: ");
        System.out.println("0 - Sair");
        System.out.println("1 - Distância Euclidiana");
        System.out.println("2 - Distância City Block\n");

        Scanner keyboard = new Scanner(System.in);
        op = Integer.parseInt(keyboard.nextLine());

        switch (op) {
          case 1:
              System.out.println(stub.euclidean(A, B, C));
              break;
          case 2:
              System.out.println(stub.cityBlock(A, B, C));
              break;
          case 0:
          default:
              break;
        }

      }
    }catch (Exception e) {
      System.err.println("Erro no Servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}