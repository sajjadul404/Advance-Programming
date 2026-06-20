package Train;
class Train {
    private String trainName;
    private int departureHour;

    private static int trainsAfter10AM = 0;

    public Train(String trainName, int departureHour) {
        this.trainName = trainName;
        this.departureHour = departureHour;

        if (departureHour > 10) {
            trainsAfter10AM++;
        }
    }

    public static int getTrainsAfter10AM() {
        return trainsAfter10AM;
    }

    public void display() {
        System.out.println("Train: " + trainName + ", Departure Time: " + departureHour + ":00");
    }
}
