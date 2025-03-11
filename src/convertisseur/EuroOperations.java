package convertisseur;


public interface EuroOperations 
{
  String devise ();
  void devise (String newDevise);
  double taux ();
  void taux (double newTaux);
  double toEuro (double devise);
  double toDevise (double euro);
  void setTaux (double _taux);
  void setDevise (String _devise);
}