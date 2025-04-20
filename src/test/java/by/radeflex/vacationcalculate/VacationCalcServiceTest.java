package by.radeflex.vacationcalculate;

import by.radeflex.vacationcalculate.dto.VacationInfoDto;
import by.radeflex.vacationcalculate.properties.CalcProperties;
import by.radeflex.vacationcalculate.service.VacationCalcService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = VacationCalculateApplication.class)
public class VacationCalcServiceTest {
    @Autowired
    private CalcProperties calcProperties;
    @Autowired
    private VacationCalcService vacationCalcService;

    @Test
    void checkCalculateVacations() {
        var info = VacationInfoDto.builder()
                .days(21)
                .salary(72000.0)
                .build();
        var expected = info.getDays() * info.getSalary() / calcProperties.getAvgMonthDays();

        assertEquals(expected, vacationCalcService.calculate(info), calcProperties.getPrecision());
    }

    @Test
    void checkCalculateVacationsWithDates() {
        var info = VacationInfoDto.builder()
                .start(LocalDate.of(2025, 1, 1))
                .end(LocalDate.of(2025, 1, 20))
                .salary(72000.0)
                .build();
        var expected = 7 * info.getSalary() / calcProperties.getAvgMonthDays();

        assertEquals(expected, vacationCalcService.calculate(info), calcProperties.getPrecision());
    }
}
