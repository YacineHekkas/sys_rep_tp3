package convertisseur;

import org.omg.CORBA.ORB;

public class EuroPOAImpl extends EuroPOA {
    private String devise;
    private double taux;

    @Override
    public String devise() {
        return devise;
    }

    @Override
    public void devise(String newDevise) {
        this.devise = newDevise;
    }

    @Override
    public double taux() {
        return taux;
    }

    @Override
    public void taux(double newTaux) {
        this.taux = newTaux;
    }

    @Override
    public double toEuro(double amount) {
        return amount / taux;
    }

    @Override
    public double toDevise(double amount) {
        return amount * taux;
    }

    @Override
    public void setTaux(double _taux) {
        this.taux = _taux;
    }

    @Override
    public void setDevise(String _devise) {
        this.devise = _devise;
    }
}