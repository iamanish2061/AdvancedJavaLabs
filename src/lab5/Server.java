package lab5;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args){
        try{

            LocateRegistry.createRegistry(1099);
            Operation operation = new OperationImpl();

            Naming.rebind("rmi://localhost/operation", operation);
            System.out.println("RMI Server is running...");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
