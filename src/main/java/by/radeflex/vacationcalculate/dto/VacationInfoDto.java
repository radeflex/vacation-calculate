package by.radeflex.vacationcalculate.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class VacationInfoDto {
    @NotNull
    Double salary;
    Integer days;
    LocalDate start;
    LocalDate end;
}
