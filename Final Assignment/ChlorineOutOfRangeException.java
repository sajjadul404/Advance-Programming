/**
 * Thrown when the chlorine concentration falls outside the
 * safe disinfection range of 0.2 - 1.0 mg/L.
 */
public class ChlorineOutOfRangeException extends Exception {
    public ChlorineOutOfRangeException(String message) {
        super(message);
    }
}
