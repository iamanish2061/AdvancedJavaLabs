package lab5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operation extends Remote {

    public int add(int x, int y) throws RemoteException;
    public int sub(int x, int y) throws RemoteException;
    public int mul(int x, int y) throws RemoteException;

}
