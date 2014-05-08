
public class NETRESOURCE {
	public static final int RESOURCE_CONNECTED  = 0x01;
	public static final int RESOURCE_GLOBALNET  = 0x02;
	public static final int RESOURCE_REMEMBERED = 0x03;

	public static final int RESOURCETYPE_ANY       = 0x00000000;
	public static final int RESOURCETYPE_DISK      = 0x00000001;
	public static final int RESOURCETYPE_PRINT     = 0x00000002;
	public static final int RESOURCETYPE_RESERVED  = 0x00000008;
	public static final int RESOURCETYPE_UNKNOWN   = 0xffffffff;

    public static final int RESOURCEDISPLAYTYPE_GENERIC      = 0x00000000;
    public static final int RESOURCEDISPLAYTYPE_DOMAIN       = 0x00000001;
    public static final int RESOURCEDISPLAYTYPE_SERVER       = 0x00000002;
    public static final int RESOURCEDISPLAYTYPE_SHARE        = 0x00000003;
    public static final int RESOURCEDISPLAYTYPE_FILE         = 0x00000004;
    public static final int RESOURCEDISPLAYTYPE_GROUP        = 0x00000005;
    public static final int RESOURCEDISPLAYTYPE_NETWORK      = 0x00000006;
    public static final int RESOURCEDISPLAYTYPE_ROOT         = 0x00000007;
    public static final int RESOURCEDISPLAYTYPE_SHAREADMIN   = 0x00000008;
    public static final int RESOURCEDISPLAYTYPE_DIRECTORY    = 0x00000009;
    public static final int RESOURCEDISPLAYTYPE_TREE         = 0x0000000a;
    public static final int RESOURCEDISPLAYTYPE_NDSCONTAINER = 0x0000000b;

    public static final int RESOURCEUSAGE_CONNECTABLE   = 0x00000001;
    public static final int RESOURCEUSAGE_CONTAINER     = 0x00000002;
    public static final int RESOURCEUSAGE_NOLOCALDEVICE = 0x00000004;
    public static final int RESOURCEUSAGE_SIBLING       = 0x00000008;
    public static final int RESOURCEUSAGE_ATTACHED      = 0x00000010;
    public static final int RESOURCEUSAGE_ALL			= 0x0000001f; // bitwise or of all previous items
    public static final int RESOURCEUSAGE_RESERVED      = 0x80000000;

};
