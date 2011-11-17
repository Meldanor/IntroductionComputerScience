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
            e.printStackTrace();
        }
        catch (Exception e) {
            // DO SOMETHING
            e.printStackTrace();
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minute;
    }

    public Time add(int min) {
        int m = this.minute + min;
        // if new time is less then 00:00, turn it to something between 00:00
        // and 23:59
        // 1440 = 60 (minutes per hour) * 24(hours per day)
        if (m < 0 || m >= 1440)
            m = Math.abs(m % 1440);
        return new Time(m % 60, this.hour + (m / 60));
    }

    public Time add(Time t) {
        return add((t.getHour() * 60) + t.getMinutes());
    }

    public Time sub(int min) {
        int m = this.minute - min;
        // if new time is less then 00:00, turn it to something between 00:00
        // and 23:59
        // 1440 = 60 (minutes per hour) * 24(hours per day)
        if (m < 0 || m >= 1440)
            m = Math.abs(m % 1440);
        return new Time(m % 60, this.hour - (m / 60));
    }

    public Time sub(Time t) {
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
        return hour + ":" + minute;
    }
}
