package by.radeflex.vacationcalculate.service;

import by.radeflex.vacationcalculate.dto.VacationInfoDto;
import by.radeflex.vacationcalculate.utils.CalculationUtils;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VacationCalcService {
    private final CalculationUtils calculationUtils;

    public Double calculate(VacationInfoDto vacationInfoDto) {
        var days = vacationInfoDto.getDays();
        var salary = vacationInfoDto.getSalary();
        LocalDate start = vacationInfoDto.getStart(), end = vacationInfoDto.getEnd();

        try {
            if (start != null && end != null) {
                return calculationUtils.calculateWithDates(salary, start, end);
            }

            return calculationUtils.calculate(salary, days);
        } catch (NullPointerException e) {
            throw new ValidationException();
        }
    }
}
