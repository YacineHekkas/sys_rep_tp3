package convertisseur;

abstract public class EuroHelper {
  private static final String INTERFACE_ID = "IDL:convertisseur/Euro:1.0";

  public static void insert(org.omg.CORBA.Any any, convertisseur.Euro euroObject) {
    org.omg.CORBA.portable.OutputStream outputStream = any.create_output_stream();
    any.type(getTypeCode());
    write(outputStream, euroObject);
    any.read_value(outputStream.create_input_stream(), getTypeCode());
  }

  public static convertisseur.Euro extract(org.omg.CORBA.Any any) {
    return read(any.create_input_stream());
  }

  private static org.omg.CORBA.TypeCode typeCode = null;

  public static synchronized org.omg.CORBA.TypeCode getTypeCode() {
    if (typeCode == null) {
      typeCode = org.omg.CORBA.ORB.init().create_interface_tc(EuroHelper.getId(), "Euro");
    }
    return typeCode;
  }

  public static String getId() {
    return INTERFACE_ID;
  }

  public static convertisseur.Euro read(org.omg.CORBA.portable.InputStream inputStream) {
    return narrow(inputStream.read_Object(_EuroStub.class));
  }

  public static void write(org.omg.CORBA.portable.OutputStream outputStream, convertisseur.Euro euroObject) {
    outputStream.write_Object((org.omg.CORBA.Object) euroObject);
  }

  public static convertisseur.Euro narrow(org.omg.CORBA.Object corbaObject) {
    if (corbaObject == null) {
      return null;
    } else if (corbaObject instanceof convertisseur.Euro) {
      return (convertisseur.Euro) corbaObject;
    } else if (!corbaObject._is_a(getId())) {
      throw new org.omg.CORBA.BAD_PARAM();
    } else {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) corbaObject)._get_delegate();
      convertisseur._EuroStub stub = new convertisseur._EuroStub();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static convertisseur.Euro uncheckedNarrow(org.omg.CORBA.Object corbaObject) {
    if (corbaObject == null) {
      return null;
    } else if (corbaObject instanceof convertisseur.Euro) {
      return (convertisseur.Euro) corbaObject;
    } else {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) corbaObject)._get_delegate();
      convertisseur._EuroStub stub = new convertisseur._EuroStub();
      stub._set_delegate(delegate);
      return stub;
    }
  }
}
