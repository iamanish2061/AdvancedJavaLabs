package lab5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OperationImpl extends UnicastRemoteObject implements Operation {

    public OperationImpl() throws RemoteException{
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x+y;
    }

    @Override
    public int sub(int x, int y) throws RemoteException {
        return x-y;
    }

    @Override
    public int mul(int x, int y) throws RemoteException {
        return x*y;
    }
}
