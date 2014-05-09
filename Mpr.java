import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APIOptions;
import com.sun.jna.WString;

public interface Mpr extends WinNT
{
    Mpr INSTANCE = (Mpr)Native.loadLibrary("Mpr", Mpr.class, W32APIOptions.UNICODE_OPTIONS);

    public static final int CONNECT_UPDATE_PROFILE = 0x00000001;
    public static final int CONNECT_UPDATE_RECENT  = 0x00000002;
    public static final int CONNECT_TEMPORARY      = 0x00000004;
    public static final int CONNECT_INTERACTIVE    = 0x00000008;
    public static final int CONNECT_PROMPT         = 0x00000010;
    public static final int CONNECT_NEED_DRIVE     = 0x00000020;
    public static final int CONNECT_REFCOUNT       = 0x00000040;
    public static final int CONNECT_REDIRECT       = 0x00000080;
    public static final int CONNECT_LOCALDRIVE     = 0x00000100;
    public static final int CONNECT_CURRENT_MEDIA  = 0x00000200;
    public static final int CONNECT_DEFERRED       = 0x00000400;
    public static final int CONNECT_RESERVED       = 0xFF000000;
    public static final int CONNECT_COMMANDLINE    = 0x00000800;
    public static final int CONNECT_CMD_SAVECRED   = 0x00001000;
    public static final int CONNECT_CRED_RESET     = 0x00002000;

    public int WNetAddConnection2A(NETRESOURCEA lpNetResource, String lpPassword, String lpUserName, int dwFlags);
    public int WNetAddConnection2W(NETRESOURCEW lpNetResource, WString lpPassword, WString lpUserName, int dwFlags);

    public int WNetCancelConnection2A(String lpName, int dwFlags, int FORCE);
    public int WNetCancelConnection2W(WString lpName, int dwFlags, int FORCE);

    public int WNetOpenEnumA(int dwScope, int dwType, int dwUsage, NETRESOURCEA lpNetResource, WinNT.HANDLEByReference handle);
    public int WNetOpenEnumW(int dwScope, int dwType, int dwUsage, NETRESOURCEW lpNetResource, WinNT.HANDLEByReference handle);

    public int WNetEnumResourceA(HANDLE handle, IntByReference lpcCount, Memory lpBuffer, IntByReference lpcBufferSize);
    public int WNetEnumResourceW(HANDLE handle, IntByReference lpcCount, Memory lpBuffer, IntByReference lpcBufferSize);

    public int WNetCloseEnum(HANDLE handle);
}
