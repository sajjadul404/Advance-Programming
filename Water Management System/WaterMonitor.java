/**
 * Validates a single WaterReading against water-safety rules.
 * Throws custom exceptions for domain-specific violations and
 * built-in exceptions for missing or logically impossible data.
 */
public class WaterMonitor {

    /**
     * Validates the given reading.
     *
     * Order of checks matters:
     *   1. Missing data        -> NullPointerException
     *   2. Negative pH         -> IllegalArgumentException
     *   3. Contamination combo -> WaterContaminationAlertException (most critical)
     *   4. pH out of range     -> InvalidPHLevelException
     *   5. Turbidity too high  -> HighTurbidityException
     *   6. Chlorine out of range -> ChlorineOutOfRangeException
     *   7. Pump offline        -> PumpOfflineException
     */
    public void processReading(WaterReading reading) throws Exception {

        // --- Built-in exception: simulate missing sensor data ---
        if (reading.getPHLevel() == null || reading.getTurbidity() == null ||
                reading.getChlorineLevel() == null || reading.getPumpStatus() == null ||
                reading.getSensorStatus() == null) {
            throw new NullPointerException("Missing sensor data.");
        }

        double pH = reading.getPHLevel();
        double turbidity = reading.getTurbidity();
        double chlorine = reading.getChlorineLevel();
        String pumpStatus = reading.getPumpStatus();

        // --- Built-in exception: negative pH is physically illogical ---
        if (pH < 0) {
            throw new IllegalArgumentException(
                    "Invalid pH reading: negative value (" + pH + ") is not physically possible.");
        }

        // --- Custom exception: contamination alert (checked first, most critical) ---
        if (turbidity > 10 && chlorine < 0.2) {
            throw new WaterContaminationAlertException(
                    "Possible contamination! High turbidity and low chlorine.");
        }

        // --- Custom exception: pH range ---
        if (pH < 6.5 || pH > 8.5) {
            throw new InvalidPHLevelException(
                    "pH " + pH + " is outside acceptable range (6.5\u20138.5).");
        }

        // --- Custom exception: turbidity too high ---
        if (turbidity > 5) {
            throw new HighTurbidityException(
                    "Turbidity " + turbidity + " NTU exceeds the safe limit of 5 NTU.");
        }

        // --- Custom exception: chlorine out of range ---
        if (chlorine < 0.2 || chlorine > 1.0) {
            throw new ChlorineOutOfRangeException(
                    "Chlorine level " + chlorine + " mg/L is outside the safe range (0.2\u20131.0).");
        }

        // --- Custom exception: pump offline ---
        if ("OFFLINE".equalsIgnoreCase(pumpStatus)) {
            throw new PumpOfflineException("Pump is currently offline.");
        }

        // If we reach here, the reading is fully valid.
    }
}
