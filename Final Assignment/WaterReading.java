/**
 * Represents one set of sensor readings captured from a single
 * monitoring zone at a point in time.
 *
 * Numeric fields use the wrapper classes (Double) rather than
 * primitives so that a missing/faulty sensor reading can be
 * represented as null, which WaterMonitor detects and reports
 * as a NullPointerException.
 */
public class WaterReading {
    private Double pHLevel;
    private Double turbidity;      // in NTU
    private Double chlorineLevel;  // in mg/L
    private String pumpStatus;     // "ACTIVE", "IDLE", "OFFLINE"
    private String sensorStatus;   // "OPERATIONAL", "FAULTY"
    private String location;       // monitoring zone name

    public WaterReading(Double pHLevel, Double turbidity, Double chlorineLevel,
                         String pumpStatus, String sensorStatus, String location) {
        this.pHLevel = pHLevel;
        this.turbidity = turbidity;
        this.chlorineLevel = chlorineLevel;
        this.pumpStatus = pumpStatus;
        this.sensorStatus = sensorStatus;
        this.location = location;
    }

    public Double getPHLevel() {
        return pHLevel;
    }

    public Double getTurbidity() {
        return turbidity;
    }

    public Double getChlorineLevel() {
        return chlorineLevel;
    }

    public String getPumpStatus() {
        return pumpStatus;
    }

    public String getSensorStatus() {
        return sensorStatus;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "WaterReading{" +
                "location='" + location + '\'' +
                ", pHLevel=" + pHLevel +
                ", turbidity=" + turbidity +
                ", chlorineLevel=" + chlorineLevel +
                ", pumpStatus='" + pumpStatus + '\'' +
                ", sensorStatus='" + sensorStatus + '\'' +
                '}';
    }
}
