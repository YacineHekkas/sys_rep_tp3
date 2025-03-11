package convertisseur;

public class _EuroStub extends org.omg.CORBA.portable.ObjectImpl implements convertisseur.Euro {

    public String devise() {
        org.omg.CORBA.portable.InputStream inputStream = null;
        try {
            org.omg.CORBA.portable.OutputStream outputStream = _request("_get_devise", true);
            inputStream = _invoke(outputStream);
            return inputStream.read_string();
        } catch (org.omg.CORBA.portable.ApplicationException ex) {
            throw new org.omg.CORBA.MARSHAL(ex.getId());
        } catch (org.omg.CORBA.portable.RemarshalException re) {
            return devise();
        } finally {
            _releaseReply(inputStream);
        }
    }

    public void devise(String newDevise) {
        org.omg.CORBA.portable.InputStream inputStream = null;
        try {
            org.omg.CORBA.portable.OutputStream outputStream = _request("_set_devise", true);
            outputStream.write_string(newDevise);
            inputStream = _invoke(outputStream);
        } catch (org.omg.CORBA.portable.ApplicationException ex) {
            throw new org.omg.CORBA.MARSHAL(ex.getId());
        } catch (org.omg.CORBA.portable.RemarshalException re) {
            devise(newDevise);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public double taux() {
        org.omg.CORBA.portable.InputStream inputStream = null;
        try {
            org.omg.CORBA.portable.OutputStream outputStream = _request("_get_taux", true);
            inputStream = _invoke(outputStream);
            return inputStream.read_double();
        } catch (org.omg.CORBA.portable.ApplicationException ex) {
            throw new org.omg.CORBA.MARSHAL(ex.getId());
        } catch (org.omg.CORBA.portable.RemarshalException re) {
            return taux();
        } finally {
            _releaseReply(inputStream);
        }
    }

    public void taux(double newTaux) {
        org.omg.CORBA.portable.InputStream inputStream = null;
        try {
            org.omg.CORBA.portable.OutputStream outputStream = _request("_set_taux", true);
            outputStream.write_double(newTaux);
            inputStream = _invoke(outputStream);
        } catch (org.omg.CORBA.portable.ApplicationException ex) {
            throw new org.omg.CORBA.MARSHAL(ex.getId());
        } catch (org.omg.CORBA.portable.RemarshalException re) {
            taux(newTaux);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public double toEuro(double amount) {
        org.omg.CORBA.portable.InputStream inputStream = null;
        try {
            org.omg.CORBA.portable.OutputStream outputStream = _request("toEuro", true);
            outputStream.write_double(amount);
            inputStream = _invoke(outputStream);
            return inputStream.read_double();
        } catch (org.omg.CORBA.portable.ApplicationException ex) {
            throw new org.omg.CORBA.MARSHAL(ex.getId());
        } catch (org.omg.CORBA.portable.RemarshalException re) {
            return toEuro(amount);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public double toDevise(double euroAmount) {
        org.omg.CORBA.portable.InputStream inputStream = null;
        try {
            org.omg.CORBA.portable.OutputStream outputStream = _request("toDevise", true);
            outputStream.write_double(euroAmount);
            inputStream = _invoke(outputStream);
            return inputStream.read_double();
        } catch (org.omg.CORBA.portable.ApplicationException ex) {
            throw new org.omg.CORBA.MARSHAL(ex.getId());
        } catch (org.omg.CORBA.portable.RemarshalException re) {
            return toDevise(euroAmount);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public void setTaux(double newRate) {
        org.omg.CORBA.portable.InputStream inputStream = null;
        try {
            org.omg.CORBA.portable.OutputStream outputStream = _request("setTaux", true);
            outputStream.write_double(newRate);
            inputStream = _invoke(outputStream);
        } catch (org.omg.CORBA.portable.ApplicationException ex) {
            throw new org.omg.CORBA.MARSHAL(ex.getId());
        } catch (org.omg.CORBA.portable.RemarshalException re) {
            setTaux(newRate);
        } finally {
            _releaseReply(inputStream);
        }
    }

    public void setDevise(String currency) {
        org.omg.CORBA.portable.InputStream inputStream = null;
        try {
            org.omg.CORBA.portable.OutputStream outputStream = _request("setDevise", true);
            outputStream.write_string(currency);
            inputStream = _invoke(outputStream);
        } catch (org.omg.CORBA.portable.ApplicationException ex) {
            throw new org.omg.CORBA.MARSHAL(ex.getId());
        } catch (org.omg.CORBA.portable.RemarshalException re) {
            setDevise(currency);
        } finally {
            _releaseReply(inputStream);
        }
    }

    private static final String[] interfaceIds = {"IDL:convertisseur/Euro:1.0"};

    public String[] _ids() {
        return interfaceIds.clone();
    }

    private void readObject(java.io.ObjectInputStream inputStream) throws java.io.IOException {
        String objectString = inputStream.readUTF();
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init((String[]) null, null);
        try {
            org.omg.CORBA.Object obj = orb.string_to_object(objectString);
            _set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate());
        } finally {
            orb.destroy();
        }
    }

    private void writeObject(java.io.ObjectOutputStream outputStream) throws java.io.IOException {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init((String[]) null, null);
        try {
            String objectString = orb.object_to_string(this);
            outputStream.writeUTF(objectString);
        } finally {
            orb.destroy();
        }
    }
}
