
package manicminer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Robot extends UnicastRemoteObject implements IMotion
{
   private Integer locX, locY;

   public Robot() throws RemoteException
   {super();
   }
   public String start() throws RemoteException
   { locX = new Integer(0);
     locY = new Integer(0);
     return "Robot started at ("+locX.toString() + ","+locY.toString()+")";
   }
   public String moveTo(int x, int y) throws RemoteException
   { String temp ="Robot moved from ("+locX.toString() + ","+locY.toString()+")";
	 locX = new Integer(x);
     locY = new Integer(y);
     return temp + " to ("+locX + ","+locY+")";
   }	;
   public String stop() throws RemoteException
   { return "Robot stopped at current ("+locX.toString() + ","+locY.toString()+")";
   }

 }

