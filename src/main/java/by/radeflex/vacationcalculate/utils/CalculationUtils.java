package by.radeflex.vacationcalculate.utils;

import by.radeflex.vacationcalculate.properties.CalcProperties;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class CalculationUtils {
    private final Double precision;
    private final Double avgMonthDays;
    private final List<LocalDate> holidays;

    public CalculationUtils(CalcProperties calcProperties) {
        this.holidays = calcProperties.getHolidays().stream()
                .map(h -> LocalDate.parse(h + "." + Year.now().getValue(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .toList();
        this.avgMonthDays = calcProperties.getAvgMonthDays();
        this.precision = Math.pow(10, calcProperties.getPrecision());
    }

    private double withPrecision(Double c) {
        return Math.round(c * precision) / precision;
    }

    public double calculateWithDates(Double salary, LocalDate start, LocalDate end) {
        var calculation = 0.0;
        for (; start.isBefore(end); start = start.plusDays(1)) {
            var day = start.getDayOfWeek();
            if (!holidays.contains(start)
                && day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY) {
                calculation += salary / avgMonthDays;
            }
        }
        return withPrecision(calculation);
    }

    public double calculate(Double salary, Integer days) {
        return withPrecision(days * salary / avgMonthDays);
    }
}
