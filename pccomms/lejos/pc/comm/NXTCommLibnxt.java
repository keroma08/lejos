package lejos.pc.comm;

public class NXTCommLibnxt implements NXTComm {
	private NXTInfo nxtInfo;
	
	public native int jlibnxt_find();
	public native void jlibnxt_open(int nxt);
	public native void jlibnxt_close(int nxt);
	public native void jlibnxt_send_data(int nxt, byte [] message);
	public native byte[] jlibnxt_read_data(int nxt, int len);
	
	public NXTInfo[] search(String name, int protocol) {
		if ((protocol | NXTCommand.USB) == 0) {
			return new NXTInfo[0];
		}
		int nxt = jlibnxt_find();
		if (nxt != 0) {
			NXTInfo[] nxtInfo = new NXTInfo[1];
			nxtInfo[0] = new NXTInfo();
			nxtInfo[0].protocol = NXTCommand.USB;
			nxtInfo[0].name = "Unknown";
			nxtInfo[0].usbNXT = nxt;
			return nxtInfo;
		}
		return new NXTInfo[0];
	}

	public void open(NXTInfo nxtInfo) {
		this.nxtInfo = nxtInfo;
		jlibnxt_open(nxtInfo.usbNXT);
	}
	
	public void close() {
		if (nxtInfo != null && nxtInfo.usbNXT != 0) jlibnxt_close(nxtInfo.usbNXT);
	}
	
	public byte[] sendRequest(byte [] data, int replyLen) {
		jlibnxt_send_data(nxtInfo.usbNXT, data);
		try {
			Thread.sleep(10);
		} catch (InterruptedException ie) {}

		return jlibnxt_read_data(nxtInfo.usbNXT, replyLen);
	}
	
	static {
		System.loadLibrary("jlibnxt");
	}

}
