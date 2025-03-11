package convertisseur;

import java.util.HashMap;

public abstract class EuroPOA extends org.omg.PortableServer.Servant
        implements convertisseur.EuroOperations, org.omg.CORBA.portable.InvokeHandler {

    private static final HashMap<String, Integer> methodMap = new HashMap<>();

    static {
        methodMap.put("_get_devise", 0);
        methodMap.put("_set_devise", 1);
        methodMap.put("_get_taux", 2);
        methodMap.put("_set_taux", 3);
        methodMap.put("toEuro", 4);
        methodMap.put("toDevise", 5);
        methodMap.put("setTaux", 6);
        methodMap.put("setDevise", 7);
    }

    public org.omg.CORBA.portable.OutputStream _invoke(String methodName,
                                                       org.omg.CORBA.portable.InputStream inputStream,
                                                       org.omg.CORBA.portable.ResponseHandler responseHandler) {
        org.omg.CORBA.portable.OutputStream outputStream = null;
        Integer methodId = methodMap.get(methodName);

        if (methodId == null) {
            throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
        }

        switch (methodId) {
            case 0:
                String currencyResult = this.devise();
                outputStream = responseHandler.createReply();
                outputStream.write_string(currencyResult);
                break;

            case 1:
                String newCurrency = inputStream.read_string();
                this.devise(newCurrency);
                outputStream = responseHandler.createReply();
                break;

            case 2:
                double rateResult = this.taux();
                outputStream = responseHandler.createReply();
                outputStream.write_double(rateResult);
                break;

            case 3:
                double newRate = inputStream.read_double();
                this.taux(newRate);
                outputStream = responseHandler.createReply();
                break;

            case 4:
                double amountInCurrency = inputStream.read_double();
                double convertedToEuro = this.toEuro(amountInCurrency);
                outputStream = responseHandler.createReply();
                outputStream.write_double(convertedToEuro);
                break;

            case 5:
                double amountInEuro = inputStream.read_double();
                double convertedToCurrency = this.toDevise(amountInEuro);
                outputStream = responseHandler.createReply();
                outputStream.write_double(convertedToCurrency);
                break;

            case 6:
                double rate = inputStream.read_double();
                this.setTaux(rate);
                outputStream = responseHandler.createReply();
                break;

            case 7:
                String currency = inputStream.read_string();
                this.setDevise(currency);
                outputStream = responseHandler.createReply();
                break;

            default:
                throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
        }

        return outputStream;
    }

    private static final String[] interfaceIds = {"IDL:convertisseur/Euro:1.0"};

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] objectId) {
        return interfaceIds.clone();
    }

    public Euro _this() {
        return EuroHelper.narrow(super._this_object());
    }

    public Euro _this(org.omg.CORBA.ORB orb) {
        return EuroHelper.narrow(super._this_object(orb));
    }
}
