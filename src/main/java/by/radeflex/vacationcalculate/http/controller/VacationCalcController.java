package by.radeflex.vacationcalculate.http.controller;

import by.radeflex.vacationcalculate.dto.VacationInfoDto;
import by.radeflex.vacationcalculate.service.VacationCalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class VacationCalcController {
    private final VacationCalcService vacationCalcService;

    @GetMapping("/calculacte")
    public ResponseEntity<?> calculate(VacationInfoDto vacationInfoDto) {
        var result = vacationCalcService.calculate(vacationInfoDto);
        return ResponseEntity.ok().body(Map.of("result", result));
    }
}
