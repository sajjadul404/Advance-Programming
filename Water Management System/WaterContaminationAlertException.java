/**
 * Thrown when turbidity > 10 NTU AND chlorine level < 0.2 mg/L
 * occur together, signaling a likely contamination event.
 * This is treated as the most critical alert a sensor can raise.
 */
public class WaterContaminationAlertException extends Exception {
    public WaterContaminationAlertException(String message) {
        super(message);
    }
}
