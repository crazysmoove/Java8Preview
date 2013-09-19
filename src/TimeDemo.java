import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjuster;
import java.util.Locale;

public class TimeDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeDemo demo = new TimeDemo();
        demo.testEnums();
        //demo.testDates();
        //demo.testTimes();
        //demo.testTimeZones();
        //demo.testInstant();
        //demo.testParsersAndFormatters();
        //demo.testTemporals();
        //demo.testTimeSpans();
        //demo.testClock();
    }

    private void testClock() throws InterruptedException {
        Clock stuck = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        System.out.println(stuck);
        System.out.println(Instant.now(stuck));
        Thread.sleep(1000);
        System.out.println(Instant.now(stuck));
    }

    private void testTimeSpans() {
        Instant now = Instant.now();
        Instant in45Mins = now.plus(Duration.ofMinutes(45));
        System.out.println(now);
        System.out.println(in45Mins);
        System.out.println(Duration.between(now, in45Mins).getSeconds());
        System.out.println(ChronoUnit.NANOS.between(now, in45Mins));
        LocalDate nextBday = LocalDate.of(1975, 4, 15).withYear(2014);
        Period pDiff = Period.between(LocalDate.now(), nextBday);
        System.out.println(pDiff.getMonths() + " months and " + pDiff.getDays() + " days left");
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), nextBday) + " days left");
    }

    private void testTemporals() {
        System.out.println(LocalTime.now().get(ChronoField.SECOND_OF_DAY));
        System.out.println(LocalDate.now().get(IsoFields.DAY_OF_QUARTER));
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.with(TemporalAdjuster.firstDayOfMonth()));
        System.out.println(now.with(TemporalAdjuster.dayOfWeekInMonth(2, DayOfWeek.FRIDAY)));
        System.out.println(now.with(TemporalAdjuster.lastInMonth(DayOfWeek.SUNDAY)));
        System.out.println(now.with(TemporalAdjuster.firstDayOfNextYear()).getDayOfWeek());
    }

    private void testParsersAndFormatters() {
        String birthDateStr = "19750415";
        System.out.println(LocalDate.parse(birthDateStr, DateTimeFormatter.BASIC_ISO_DATE).getDayOfWeek());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M*d*yyyy");
        LocalDate ld = LocalDate.parse("4*15*1975", dtf);
        System.out.println(ld.getDayOfYear());
        System.out.println(ld.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(ld.format(DateTimeFormatter.ofPattern("y: MMM, d")));
    }

    private void testInstant() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(LocalDateTime.now());
        System.out.println(now.getEpochSecond() + " ... " + now.getNano());
        System.out.println(now.toEpochMilli());
        Instant theFuture = now.plusSeconds(60 * 60);
        System.out.println(theFuture);
        System.out.println(now.plus(1, ChronoUnit.HOURS));
        System.out.println(now.isBefore(theFuture));
        System.out.println(now.isAfter(theFuture));
        System.out.println(now.until(theFuture, ChronoUnit.SECONDS));
        System.out.println(LocalDateTime.ofInstant(theFuture, ZoneId.systemDefault()));
    }

    private void testTimeZones() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a z");
        LocalDateTime ldt1 = LocalDateTime.of(2013, 9, 19, 12, 55, 0);
        ZoneId zone1 = ZoneId.of("America/Chicago");
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, zone1);
        System.out.println("ZDT: " + zdt1.format(fmt));

        LocalDateTime ldt2 = LocalDateTime.of(2013, 9, 19, 14, 15, 0);
        ZoneOffset zoff = ZoneOffset.of("+06:00");
        OffsetDateTime odt1 = OffsetDateTime.of(ldt2, zoff);
        System.out.println("ODT: " + odt1.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    private void testTimes() {
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        LocalDateTime jugTime = LocalDateTime.of(2013, 9, 19, 18, 30);
        System.out.println(jugTime);
        System.out.println(jugTime.plusMinutes(90));
        System.out.println(jugTime.minusDays(1));
    }

    private void testDates() {
        System.out.println(LocalDate.now());
        LocalDate anniv = LocalDate.of(2006, Month.OCTOBER, 14);
        System.out.println(anniv);
        LocalDate nextSun = anniv.with(TemporalAdjuster.next(DayOfWeek.SUNDAY));
        System.out.println(nextSun);
        System.out.println(anniv.getDayOfWeek());
        System.out.println(Year.of(2012).isLeap());
    }

    private void testEnums() {
        System.out.println(DayOfWeek.THURSDAY.plus(2));
        DayOfWeek humpDay = DayOfWeek.WEDNESDAY;
        Locale loc = Locale.getDefault();
        System.out.println(humpDay.getDisplayName(TextStyle.FULL, loc));
        System.out.println(humpDay.getDisplayName(TextStyle.SHORT, loc));
        System.out.println(humpDay.getDisplayName(TextStyle.NARROW, loc));
        System.out.println(Month.APRIL.maxLength());
    }
}
