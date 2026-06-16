package Time;

import java.util.Scanner;

class Time {
    int hours, minutes, seconds;
    Time() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    Time(int h, int m, int s) {
        hours = h;
        minutes = m;
        seconds = s;
    }
    Time add_time(Time t1, Time t2) {
        Time result = new Time();

        result.seconds = t1.seconds + t2.seconds;
        result.minutes = t1.minutes + t2.minutes;
        result.hours = t1.hours + t2.hours;

        if (result.seconds >= 60) {
            result.minutes += result.seconds / 60;
            result.seconds %= 60;
        }
        if (result.minutes >= 60) {
            result.hours += result.minutes / 60;
            result.minutes %= 60;
        }
        return result;
    }
    void display() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h1 = sc.nextInt();
        int m1 = sc.nextInt();
        int s1 = sc.nextInt();

        int h2 = sc.nextInt();
        int m2 = sc.nextInt();
        int s2 = sc.nextInt();

        Time t1 = new Time(h1, m1, s1);
        Time t2 = new Time(h2, m2, s2);
        Time t3 = new Time();

        t3 = t3.add_time(t1, t2);

        t3.display();

        sc.close();
    }
}