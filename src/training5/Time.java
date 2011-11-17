/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training5;

public class Time implements Comparable<Time> {

    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time(int minute) {
        minute = Math.abs(minute % 1440);
        this.hour = minute / 60;
        this.minute = minute % 60;
    }

    public Time(String time) {
        try {
            String[] split = time.split(":");
            this.hour = Integer.parseInt(split[0]);
            this.minute = Integer.parseInt(split[1]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please use the format HH:MM");
        }
        catch (Exception e) {
            // DO SOMETHING
            e.printStackTrace();
        }
    }

    /**
     * @return Number between inclusive 0 and exclusive 24
     */
    public int getHour() {
        return hour;
    }

    /**
     * @return Number between inclusive 0 and exclusive 60
     */
    public int getMinutes() {
        return minute;
    }

    /**
     * Add minutes to this time and return a new Time object representing the
     * new time
     * 
     * @param min
     *            Positive integer
     * @return This time plus minutes
     */
    public Time add(int min) {
        int m = (this.minute + (60 * hour)) + min;
        // if new time is less then 00:00, turn it to something between 00:00
        // and 23:59
        // 1440 = 60 (minutes per hour) * 24(hours per day)
        if (m >= 1440)
            m = Math.abs(m % 1440);

        return new Time(m / 60, m % 60);
    }

    public Time add(Time t) {
        // use add methode by converting the time object into minutes from 0 to
        // 1439
        return add((t.getHour() * 60) + t.getMinutes());
    }

    /**
     * Differ minutes to this time and return a new Time object representing the
     * new time
     * 
     * @param min
     *            Positive integer
     * @return This time minus minutes
     */
    public Time sub(int min) {
        int m = (this.minute + (60 * hour)) - min;
        // if new time is less then 00:00, turn it to something between 00:00
        // and 23:59
        // 1440 = 60 (minutes per hour) * 24(hours per day)
        if (m < 0)
            m = 1440 - Math.abs(m % 1440);
        return new Time(m / 60, m % 60);
    }

    public Time sub(Time t) {
        // use sub methode by converting the time object into minutes from 0 to
        // 1439
        return sub((t.getHour() * 60) + t.getMinutes());
    }

    public int compareTo(Time t) {
        int totalThis = (this.hour * 60) + this.minute;
        int totalOther = (t.getHour() * 60) + t.getMinutes();
        if (totalOther > totalThis)
            return -1;
        if (totalOther == totalThis)
            return 0;
        else
            return 1;
    }

    @Override
    public String toString() {
        String result = "";
        if (hour < 10)
            result += "0";
        result += hour + ":";
        if (minute < 10)
            result += "0";
        return result + minute;
    }

    public static void test() {
        // 23:59
        Time t3 = new Time(-1439);
        System.out.println(t3);
        Time t1 = new Time("12:00");
        Time t2 = new Time("12:10");
        // 23:50
        System.out.println(t1.sub(t2));
        // 12:05
        System.out.println(t2.sub(5));
    }
}
