import convertisseur.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        try {
            Properties config = new Properties();
            config.put("org.omg.CORBA.ORBInitialHost", "localhost");
            config.put("org.omg.CORBA.ORBInitialPort", "1050");

            ORB orb = ORB.init(args, config);

            org.omg.CORBA.Object namingServiceRef = orb.resolve_initial_references("NameService");
            NamingContextExt namingContext = NamingContextExtHelper.narrow(namingServiceRef);

            Euro currencyConverter = EuroHelper.narrow(namingContext.resolve_str("Euro"));

            currencyConverter.setTaux(240.00);
            currencyConverter.setDevise("DZD");

            double convertedToEuros = currencyConverter.toEuro(1500.0);
            double convertedToDZD = currencyConverter.toDevise(150.0);

            System.out.println("1500.0 DZD -> Euros: " + convertedToEuros);
            System.out.println("150.0 Euros -> DZD: " + convertedToDZD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
