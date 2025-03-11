import convertisseur.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.util.Properties;

public class ServerPOA  {
    public static void main(String[] args) {
        try {
            System.out.println("Starting server...");

            ORB orb = ORB.init(args, null);

            POA poaRoot = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poaRoot.the_POAManager().activate();

            System.out.println("POA activated");

            EuroPOAImpl currencyService = new EuroPOAImpl();
            System.out.println("Service instance created");

            org.omg.CORBA.Object servantRef = poaRoot.servant_to_reference(currencyService);
            Euro currencyStub = EuroHelper.narrow(servantRef);

            System.out.println("Service registered");

            Properties config = new Properties();
            config.put("org.omg.CORBA.ORBInitialHost", "localhost");
            config.put("org.omg.CORBA.ORBInitialPort", "1050");

            ORB namingOrb = ORB.init(args, config);
            org.omg.CORBA.Object namingServiceRef = namingOrb.resolve_initial_references("NameService");
            NamingContextExt namingContext = NamingContextExtHelper.narrow(namingServiceRef);

            NameComponent[] serviceName = namingContext.to_name("Euro");
            namingContext.rebind(serviceName, currencyStub);

            System.out.println("Server is running...");

            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
