import java.time.LocalDateTime;
import java.util.Scanner;

public class JulianDate {

    public static final LocalDateTime START_DATE = LocalDateTime.of(-4712,1,1,12,0,0,0);
    private static int jdToday = 2459355;
    private static int dayToday = 20;
    private static int monthToday = 5;
    protected static int JD;

    public JulianDate(int day, int month, int year) {
        int a = (14 - month) / 12;

        int y = year + 4800 - a;

        int m = month + 12*a - 3;

        int jd = day + (153*m + 2)/5 + 365*y + y/4 - y/100 + y/400 - 32045;

        this.JD = jd;
    }

    public int getJulianDate() {
        return this.JD;
    }

    public int getJdToday() {
        return this.jdToday;
    }

    public int getDayToday() {
        return this.dayToday;
    }
    public int getMonthToday() {
        return this.monthToday;
    }

    public int yesterday() {
        return getJdToday()-1;
    }

    public int tomorrow() {
        return getJdToday()+1;
    }

    public int daysBetween(int day, int month, int year) {
        int classJD = this.getJulianDate();
        JulianDate secondDate = new JulianDate(day, month, year);
        return Math.abs(classJD - secondDate.getJulianDate());
    }

    public String getWeekday() {
        String weekday = "";
        switch (this.JD % 7) {
            case (0):
                weekday = "Monday";
                break;
            case (1):
                weekday = "Tuesday";
                break;
            case (2):
                weekday = "Wednesday";
                break;
            case (3):
                weekday = "Thursday";
                break;
            case (4):
                weekday = "Friday";
                break;
            case (5):
                weekday = "Saturday";
                break;
            case (6):
                weekday = "Sunday";
                break;
        }
        return weekday;
    }

    public void userBirthday() {
        System.out.println("Enter your day of birth:");
        Scanner scan = new Scanner(System.in);
        int birthDay = scan.nextInt();

        System.out.println("Enter your month of birth:");
        Scanner scan1 = new Scanner(System.in);
        int birthMonth = scan1.nextInt();

        System.out.println("Enter your year of birth:");
        Scanner scan2 = new Scanner(System.in);
        int birthYear = scan2.nextInt();

        int dayToday = this.getDayToday();
        int monthToday = this.getMonthToday();

        JulianDate julianBirthday = new JulianDate(birthDay, birthMonth, birthYear);
        int daysLived = Math.abs(this.getJdToday() - julianBirthday.getJulianDate());

        System.out.println("You are " + daysLived + " days old.");
        if (birthDay == dayToday && birthMonth == monthToday) System.out.println("Happy Birthday!!!");
        if (daysLived % 100 == 0) System.out.println("Your days lived divided by 100 is 0!!!!");
        System.out.println("You were born on a " + this.getWeekday() + ".");
    }

    public static void main(String[] args) {
        JulianDate jul = new JulianDate(1,1, 2000 );
        jul.userBirthday();
    }


}