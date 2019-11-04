package manicminer;

import java.net.SocketPermission;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.*;

public class RobotClient {

    public static void main(String[] args) {
      System.setProperty( "java.security.policy", "Robot.policy" );
      System.out.println("Using security policy "+System.getProperty("java.security.policy"));
      if ( System.getSecurityManager() == null ) {
         System.setSecurityManager( new SecurityManager() );
      }
      try
        {
        //SocketPermission sp = new SocketPermission("localhost:1099","connect,accept");
        //Registry reg = LocateRegistry.getRegistry("localhost",1099);
        IMotion remObj = (IMotion) Naming.lookup( "RemoteRobot");
        System.out.println(remObj.start());
        System.out.println(remObj.moveTo(10,20));
        System.out.println(remObj.moveTo(23,40));
         }
      catch ( Exception x )
      {
         x.printStackTrace();
      }
    }
}
