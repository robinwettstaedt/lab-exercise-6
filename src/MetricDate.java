import java.util.Scanner;

public class MetricDate extends JulianDate{

    private int metricDays;
    private int metricMonths;
    private int metricYears;
    double years;
    double months;
    double days;

    public MetricDate(int day, int month, int year) {
        super(day, month, year);

        double jd = this.JD;

        this.years = jd / 1000;
        this.months = ((years % 1) * 10);
        this.days = (months % 1) * 100;

        this.metricYears = (int) (jd / 1000);
        this.metricMonths = (int) ((years % 1) * 10);
        this.metricDays = (int) (months % 1 * 100);
    }

    public int convertToJulian() {
        return (int) (this.years * 1000);
    }

    public String convertFromJulian() {
        String s = this.metricDays + " Days " + this.metricMonths + " Months " + this.metricYears + " Years";
        return s;
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

        JulianDate julianBirthday = new JulianDate(birthDay, birthMonth, birthYear);
        int daysLived = Math.abs(this.getJdToday() - julianBirthday.getJulianDate());
        int yearsLived = daysLived / 1000;

        System.out.println("You are " + daysLived + " days old.");
        System.out.println("You have lived " + yearsLived + " years in the metric calendar.");
    }

    public static void main(String[] args) {
        MetricDate m = new MetricDate(1, 5, 2000);
        System.out.println(m.convertToJulian());
        System.out.println(m.convertFromJulian());
        m.userBirthday();

    }
}
