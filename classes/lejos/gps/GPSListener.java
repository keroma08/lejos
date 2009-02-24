package lejos.gps;

/**
 * This is the interface to manage events with GPS
 * 
 * @author Juan Antonio Brenha Moral
 *
 */

public interface GPSListener {
	
	public void ggaSentenceReceived (GPS gpsReceiver, GGASentence ggaSentence);
	
	public void rmcSentenceReceived (GPS gpsReceiver, RMCSentence rmcSentence);

	public void vtgSentenceReceived (GPS gpsReceiver, VTGSentence vtgSentence);

	public void gsvSentenceReceived (GPS gpsReceiver, GSVSentence gsvSentence);

	public void gsaSentenceReceived (GPS gpsReceiver, GSASentence gsagSentence);

}
