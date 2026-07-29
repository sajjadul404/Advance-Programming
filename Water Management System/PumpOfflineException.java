/**
 * Thrown when a monitoring zone's pump status is "OFFLINE",
 * meaning water is not currently being distributed/monitored live.
 */
public class PumpOfflineException extends Exception {
    public PumpOfflineException(String message) {
        super(message);
    }
}
