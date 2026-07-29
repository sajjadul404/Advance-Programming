/**
 * Thrown when a water sample's pH level falls outside the
 * acceptable safe range of 6.5 - 8.5.
 */
public class InvalidPHLevelException extends Exception {
    public InvalidPHLevelException(String message) {
        super(message);
    }
}
