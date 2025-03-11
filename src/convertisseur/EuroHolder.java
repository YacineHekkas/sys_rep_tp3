package convertisseur;

public final class EuroHolder implements org.omg.CORBA.portable.Streamable
{
  public convertisseur.Euro value = null;

  public EuroHolder ()
  {
  }

  public EuroHolder (convertisseur.Euro initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = convertisseur.EuroHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    convertisseur.EuroHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return convertisseur.EuroHelper.getTypeCode ();
  }

}
