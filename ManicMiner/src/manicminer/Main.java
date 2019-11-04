package manicminer;
import java.net.SocketPermission;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {

    public static void main(String[] args) {
    System.setProperty( "java.security.policy", "Robot.policy" );
    System.out.println("Using security policy "+System.getProperty("java.security.policy"));
     if ( System.getSecurityManager() == null )
          System.setSecurityManager( new SecurityManager() );
      try
      {
        
          IMotion stub = new Robot();
          stub = (IMotion) UnicastRemoteObject.exportObject(stub, 0);
          Registry reg = LocateRegistry.getRegistry();
          //Registry reg = LocateRegistry.getRegistry(1099);
          //SocketPermission sp = new SocketPermission("localhost:1099","connect,accept");
          reg.rebind("RemoteRobot",stub);
         //Naming.rebind("RemoteRobot",stub);
         System.out.println( "Robot object bound to naming RMI" );
      }
      catch ( Exception remexc )
      {
         System.out.println(remexc.getMessage());
         remexc.printStackTrace();
      }
    }
    }

