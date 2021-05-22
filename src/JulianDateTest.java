import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JulianDateTest {

    @Test
    public void getJulianDateTest1() {
        JulianDate julianTest = new JulianDate(20, 5, 2021);
        int output = julianTest.getJulianDate();
        assertEquals(2459355, output );
    }
    @Test
    public void getJulianDateTest2() {
        JulianDate julianTest = new JulianDate(10, 8, 1998);
        int output = julianTest.getJulianDate();
        assertEquals(2451036, output );
    }
    @Test
    public void getJdTodayTest() {
        JulianDate julianTest = new JulianDate(1,1,1);
        int output = julianTest.getJdToday();
        assertEquals(2459355, output );
    }
    @Test
    public void daysBetweenTest() {
        JulianDate julianTest = new JulianDate(1,1,2000);
        int output = julianTest.daysBetween(2,1,2000);
        assertEquals(1, output );
    }
    @Test
    public void getWeekdayTest() {
        JulianDate julianTest = new JulianDate(1,1,2000);
        String output = julianTest.getWeekday();
        assertEquals("Saturday", output );
    }
    @Test
    public void getWeekdayTest2() {
        JulianDate julianTest = new JulianDate(3,2,2019);
        String output = julianTest.getWeekday();
        assertEquals("Sunday", output );
    }
    @Test
    public void convertFromJulianTest() {
        MetricDate metricTest = new MetricDate(1,5,2000);
        String output = metricTest.convertFromJulian();
        assertEquals("66 Days 6 Months 2451 Years", output );
    }
    @Test
    public void convertFromJulianTest2() {
        MetricDate metricTest = new MetricDate(3,5,2000);
        String output = metricTest.convertFromJulian();
        assertEquals("68 Days 6 Months 2451 Years", output );
    }



}