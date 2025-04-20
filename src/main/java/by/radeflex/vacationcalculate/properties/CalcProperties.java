package by.radeflex.vacationcalculate.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "calc")
@Component
@Data
public class CalcProperties {
    private Integer precision;
    private Double avgMonthDays;
    private List<String> holidays;
}
