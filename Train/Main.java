package Train;

public class Main {
    public static void main(String[] args) {

        Train t1 = new Train("Express", 9);
        Train t2 = new Train("Intercity", 11);
        Train t3 = new Train("Mail", 14);
        Train t4 = new Train("Local", 10);
        Train t5 = new Train("Fast", 12);

        t1.display();
        t2.display();
        t3.display();
        t4.display();
        t5.display();

        System.out.println("\nNumber of trains started after 10 a.m.: " + Train.getTrainsAfter10AM());
    }
}