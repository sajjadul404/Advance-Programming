/**
 * Thrown when turbidity (water cloudiness) exceeds the safe
 * limit of 5 NTU, indicating poor water quality.
 */
public class HighTurbidityException extends Exception {
    public HighTurbidityException(String message) {
        super(message);
    }
}
