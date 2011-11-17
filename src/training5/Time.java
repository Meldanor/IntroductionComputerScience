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
        this.hour = minute / 60;
        this.minute = minute % 60;
    }

    public Time(String time) {
        String[] split = time.split(":");
        this.hour = Integer.parseInt(split[0]);
        this.minute = Integer.parseInt(split[1]);
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minute;
    }

    public Time add(int min) {
        int m = this.minute + min;
        int h = this.hour;
        while (m >= 60) {
            ++h;
            m -= 60;
        }
        return new Time(m, h);
    }

    public Time add(Time t) {
        return add((t.getHour() * 60) + t.getMinutes());
    }

    public Time sub(int min) {
        int m = this.minute - min;
        int h = this.hour;
        while (m < 0) {
            --h;
            m += 60;
        }
        return new Time(m, h);
    }

    public Time sub(Time t) {
        return sub((t.getHour() * 60) + t.getMinutes());
    }

    public int compareTo(Time t) {
        int totalThis = (hour * 60) + minute;
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
