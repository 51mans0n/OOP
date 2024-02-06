package lab3ex5;

public class Time implements Comparable<Time> {
    public int hour;
    public int minute;
    public int second;
    public Time() {
        this(0,0,0);
    }
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        checker();
    }
    public void checker() {
        if (hour > 24 || minute > 60 || second > 60) {
            System.out.println("Invalid data");
        }
    }
    public String toUniversal() {
        if (hour < 10) {
            System.out.print("0" + hour + ":");
        }
        else System.out.print(hour + ":");
        if (minute < 10) {
            System.out.print("0" + minute + ":");
        }
        else System.out.print(minute + ":");
        if (second < 10) {
            System.out.print("0" + second);
        }
        else System.out.print(second);
        return "\n";
    }
    public String toStandard() {
        boolean isAM = true;
        int tempHour = hour;
        int tempMinute = minute;
        int tempSecond = second;
        if (tempHour > 12) {
            tempHour -= 12;
            isAM = false;
            if (tempHour < 10) {
                System.out.print("0" + tempHour + ":");
            }
            else {
                System.out.print(tempHour + ":");
            }
        }
        else if (tempHour <= 12 && tempHour >= 10) {
            System.out.print(tempHour + ":");
        }
        else System.out.print("0" + tempHour + ":");
        if (tempMinute < 10) {
            System.out.print("0" + tempMinute + ":");
        }
        else System.out.print(tempMinute + ":");
        if (tempSecond < 10) {
            System.out.print("0" + tempSecond);
        }
        else System.out.print(tempSecond);
        if (isAM) {
            return " AM";
        }
        else return " PM";
    }
    public void add(Time t) {
        if((t.second + second) / 60 > 0){
            minute++;
        }
        second = t.second + second;
        if((t.minute + minute) / 60 > 0) {
            hour++;
        }
        minute = t.minute + minute;
        if ((t.hour + hour) / 24 > 0) {
            hour = t.hour + hour - 24;
        }
        else hour = t.hour + hour;
    }
    @Override
    public int compareTo(Time other) {
        if (this.hour != other.hour) {
            return this.hour - other.hour;
        }
        else if (this.minute != other.minute) {
            return this.minute - other.minute;
        }
        else {
            return this.second - other.second;
        }
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
