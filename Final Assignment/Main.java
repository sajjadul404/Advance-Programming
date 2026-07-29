/**
 * Entry point for the AquaFlow Solutions Smart Water Management demo.
 *
 * Scenario 1 reproduces the five required cases (valid, bad pH,
 * contamination, missing data, pump offline).
 *
 * Scenarios 2 and 3 are bonus demonstrations proving the remaining
 * required built-in exceptions are wired up correctly:
 *   - IllegalArgumentException (negative pH reading)
 *   - ArithmeticException (zero valid readings to average)
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("========== Scenario 1: Daily Zone Readings ==========");
        WaterAnalysis analysis = new WaterAnalysis();

        // 1. Valid data
        analysis.addReading(new WaterReading(7.2, 3.4, 0.5, "ACTIVE", "OPERATIONAL", "Dhanmondi"));

        // 2. Invalid pH level
        analysis.addReading(new WaterReading(9.1, 2.0, 0.4, "ACTIVE", "OPERATIONAL", "Gulshan"));

        // 3. Contamination alert (turbidity > 10 and chlorine < 0.2)
        analysis.addReading(new WaterReading(7.0, 12.5, 0.1, "ACTIVE", "OPERATIONAL", "Mirpur"));

        // 4. Missing sensor data (null turbidity)
        analysis.addReading(new WaterReading(7.1, null, 0.5, "ACTIVE", "OPERATIONAL", "Banani"));

        // 5. Pump offline
        analysis.addReading(new WaterReading(7.3, 3.0, 0.6, "OFFLINE", "OPERATIONAL", "Uttara"));

        analysis.analyzeAll();

        System.out.println();
        System.out.println("========== Scenario 2: Negative pH Sensor Glitch ==========");
        WaterAnalysis glitchAnalysis = new WaterAnalysis();
        // Simulates a faulty sensor reporting a physically impossible pH
        glitchAnalysis.addReading(new WaterReading(-1.0, 2.5, 0.5, "ACTIVE", "FAULTY", "Bashundhara"));
        glitchAnalysis.addReading(new WaterReading(7.4, 2.1, 0.6, "ACTIVE", "OPERATIONAL", "Motijheel"));
        glitchAnalysis.analyzeAll();

        System.out.println();
        System.out.println("========== Scenario 3: All Readings Invalid (no valid data to average) ==========");
        WaterAnalysis emptyAnalysis = new WaterAnalysis();
        emptyAnalysis.addReading(new WaterReading(9.5, 2.0, 0.5, "ACTIVE", "OPERATIONAL", "Tejgaon"));
        emptyAnalysis.addReading(new WaterReading(7.0, 3.0, 0.6, "OFFLINE", "OPERATIONAL", "Badda"));
        emptyAnalysis.analyzeAll();
    }
}
