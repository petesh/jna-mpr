import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.WString;

/**
 * http://msdn.microsoft.com/en-us/library/windows/desktop/aa385353(v=vs.85).aspx
 */
public class NETRESOURCEW extends Structure
{
  public static final java.util.List<String> fieldOrder = java.util.Arrays.asList(new String[]
  {
    "dwScope",
    "dwType",
    "dwDisplayType",
    "dwUsage",
    "lpLocalName",
    "lpRemoteName",
    "lpComment",
    "lpProvider"
  });

  public int dwScope;
  public int dwType;
  public int dwDisplayType;
  public int dwUsage;
  public WString lpLocalName;
  public WString lpRemoteName;
  public WString lpComment;
  public WString lpProvider;

  @Override
  protected java.util.List getFieldOrder()
  {
    return fieldOrder;
  }

  public NETRESOURCEW(Pointer mem)
  {
      super(mem);
      read();
  }

  public NETRESOURCEW()
  {
      super();
  }
}
