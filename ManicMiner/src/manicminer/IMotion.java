package manicminer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMotion extends Remote {
   public String start() throws RemoteException;
   public String moveTo(int x, int y) throws RemoteException;
   public String stop() throws RemoteException;
}
