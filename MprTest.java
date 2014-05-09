import com.sun.jna.Memory;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinError;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.WString;

public class MprTest
{

  public static final String username = "username";
  public static final String password = "password";
  public static final String remotename = "\\\\serv5\\Documents";

  public static void testA() {
    NETRESOURCEA lpNetResource;
    int dwFlags;
    int errorCode;

    lpNetResource = new NETRESOURCEA();
    lpNetResource.dwScope = 0;
    lpNetResource.dwType = NETRESOURCE.RESOURCETYPE_DISK;
    lpNetResource.dwDisplayType = NETRESOURCE.RESOURCEDISPLAYTYPE_SHARE;
    lpNetResource.dwUsage = NETRESOURCE.RESOURCEUSAGE_CONNECTABLE;
    lpNetResource.lpLocalName = null;
    lpNetResource.lpRemoteName = remotename;
    lpNetResource.lpComment = null;
    lpNetResource.lpProvider = null;

    String lpPassword = password;
    String lpUserName = username;

    dwFlags = Mpr.CONNECT_TEMPORARY;

    System.out.println("Mounting Windows Share [" + lpNetResource.lpRemoteName + "] [" + lpUserName + "] ...");

    errorCode = Mpr.INSTANCE.WNetAddConnection2A(lpNetResource, lpPassword, lpUserName, dwFlags);

    System.out.println("Mounting Windows Share: " + errorCode);

    if (errorCode == 0) {
        System.out.println("Cancelling connection: " + lpNetResource.lpRemoteName);
        errorCode = Mpr.INSTANCE.WNetCancelConnection2A(lpNetResource.lpRemoteName, 0, 1);
        System.out.println("Cancelling Error Code: " + errorCode);

    }
  }

  public static void testW() {
    NETRESOURCEW lpNetResource;
    int dwFlags;
    int errorCode;

    lpNetResource = new NETRESOURCEW();
    lpNetResource.dwScope = 0;
    lpNetResource.dwType = NETRESOURCE.RESOURCETYPE_DISK;
    lpNetResource.dwDisplayType = NETRESOURCE.RESOURCEDISPLAYTYPE_SHARE;
    lpNetResource.dwUsage = NETRESOURCE.RESOURCEUSAGE_CONNECTABLE;
    lpNetResource.lpLocalName = null;
    lpNetResource.lpRemoteName = new WString(remotename);
    lpNetResource.lpComment = null;
    lpNetResource.lpProvider = null;

    WString lpPassword = new WString(password);
    WString lpUserName = new WString(username);

    dwFlags = Mpr.CONNECT_TEMPORARY;

    System.out.println("Mounting Windows Share [" + lpNetResource.lpRemoteName + "] [" + lpUserName + "] ...");

    errorCode = Mpr.INSTANCE.WNetAddConnection2W(lpNetResource, lpPassword, lpUserName, dwFlags);

    System.out.println("Mounting Windows Share: " + errorCode);

    if (errorCode == 0) {
        System.out.println("Cancelling connection: " + lpNetResource.lpRemoteName);
        errorCode = Mpr.INSTANCE.WNetCancelConnection2W(lpNetResource.lpRemoteName, 0, 1);
        System.out.println("Cancelling Error Code: " + errorCode);

    }
  }

  public static void testEnumW()
  {
      WinNT.HANDLEByReference hbr = new WinNT.HANDLEByReference();
      NETRESOURCEW lpNetResource = new NETRESOURCEW();
      IntByReference rCount = new IntByReference();
      IntByReference rBufSize = new IntByReference();

      int bufSize = 128 * 1024;

      Memory mem = new Memory(bufSize);

      rCount.setValue(-1);
      rBufSize.setValue(bufSize);

      int errorCode = Mpr.INSTANCE.WNetOpenEnumW(NETRESOURCE.RESOURCE_CONNECTED, NETRESOURCE.RESOURCETYPE_ANY, 0, lpNetResource, hbr);
      System.out.println(errorCode);
      errorCode = Mpr.INSTANCE.WNetEnumResourceW(hbr.getValue(), rCount, mem, rBufSize);
      if (errorCode != WinError.NO_ERROR)
          if (errorCode != WinError.ERROR_NO_MORE_ITEMS)
              System.out.println(errorCode);
      int count = rCount.getValue();
      System.out.println(count);
      if (count > 0) {
          NETRESOURCEW item = new NETRESOURCEW(mem);
          NETRESOURCEW[] items = (NETRESOURCEW[])item.toArray(count);
        for (NETRESOURCEW x : items) {
            System.out.println(x.lpRemoteName);
        }
      }
      Mpr.INSTANCE.WNetCloseEnum(hbr.getValue());
  }

  public static void main(String args[]) throws Exception
  {
    //testA();
    //testW();
    testEnumW();
  } 
}
