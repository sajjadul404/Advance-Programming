import java.util.ArrayList;
import java.util.List;

/**
 * Drives water-quality analysis across many monitoring zones.
 * Holds a list of WaterReading objects, runs each through
 * WaterMonitor.processReading(), handles every exception that
 * can be thrown, and finally reports average pH and turbidity
 * across only the readings that passed validation.
 */
public class WaterAnalysis {

    private final List<WaterReading> readings;
    private final WaterMonitor monitor;
    private final List<Double> validPHReadings;
    private final List<Double> validTurbidityReadings;

    public WaterAnalysis() {
        this.readings = new ArrayList<>();
        this.monitor = new WaterMonitor();
        this.validPHReadings = new ArrayList<>();
        this.validTurbidityReadings = new ArrayList<>();
    }

    public void addReading(WaterReading reading) {
        readings.add(reading);
    }

    /**
     * Processes every stored reading, catching and reporting each
     * exception type individually, then prints the average pH and
     * turbidity across all readings that passed validation.
     */
    public void analyzeAll() {
        for (WaterReading reading : readings) {
            String zone = reading.getLocation() != null ? reading.getLocation() : "UNKNOWN";
            try {
                monitor.processReading(reading);
                System.out.println("[Zone: " + zone + "] \u2014 Valid reading processed successfully.");
                validPHReadings.add(reading.getPHLevel());
                validTurbidityReadings.add(reading.getTurbidity());

            } catch (InvalidPHLevelException e) {
                System.out.println("[Zone: " + zone + "] \u2014 InvalidPHLevelException: " + e.getMessage());
            } catch (HighTurbidityException e) {
                System.out.println("[Zone: " + zone + "] \u2014 HighTurbidityException: " + e.getMessage());
            } catch (ChlorineOutOfRangeException e) {
                System.out.println("[Zone: " + zone + "] \u2014 ChlorineOutOfRangeException: " + e.getMessage());
            } catch (PumpOfflineException e) {
                System.out.println("[Zone: " + zone + "] \u2014 PumpOfflineException: " + e.getMessage());
            } catch (WaterContaminationAlertException e) {
                System.out.println("[Zone: " + zone + "] \u2014 WaterContaminationAlertException: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("[Zone: " + zone + "] \u2014 NullPointerException: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("[Zone: " + zone + "] \u2014 IllegalArgumentException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[Zone: " + zone + "] \u2014 Unexpected error (" +
                        e.getClass().getSimpleName() + "): " + e.getMessage());
            } finally {
                System.out.println("Analysis complete for zone: " + zone);
            }
        }

        calculateAverages();
    }

    /**
     * Computes average pH and turbidity across valid readings only.
     * If there are zero valid readings, an ArithmeticException is
     * deliberately thrown (rather than letting a 0/0 division silently
     * produce NaN) and handled here.
     */
    private void calculateAverages() {
        try {
            if (validPHReadings.isEmpty()) {
                throw new ArithmeticException("No valid readings available to calculate averages.");
            }

            double sumPH = 0.0;
            double sumTurbidity = 0.0;
            for (double p : validPHReadings) {
                sumPH += p;
            }
            for (double t : validTurbidityReadings) {
                sumTurbidity += t;
            }

            double avgPH = sumPH / validPHReadings.size();
            double avgTurbidity = sumTurbidity / validTurbidityReadings.size();

            System.out.printf("Average pH Level: %.1f%n", avgPH);
            System.out.printf("Average Turbidity: %.1f NTU%n", avgTurbidity);

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }
    }
}
