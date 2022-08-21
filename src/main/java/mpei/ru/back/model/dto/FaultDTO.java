package mpei.ru.back.model.dto;

import lombok.Data;
import mpei.ru.back.model.entity.Fault;

import javax.persistence.Column;

/**
 * @author Degtiarev Dmitry on 21.08.2022
 * @project Comtrade_reader
 */
@Data
public class FaultDTO {

    private String valueName;
    private float time;
    private String timeUnitOfMeasurement;
    private float fallbackValue;
    private String valueUnitOfMeasurement;

    public FaultDTO(String valueName, float time, String timeUnitOfMeasurement, float fallbackValue, String valueUnitOfMeasurement) {
        this.valueName = valueName;
        this.time = time;
        this.timeUnitOfMeasurement = timeUnitOfMeasurement;
        this.fallbackValue = fallbackValue;
        this.valueUnitOfMeasurement = valueUnitOfMeasurement;
    }

    public FaultDTO(Fault fault){
        this.valueName = fault.getValueName();
        this.time = fault.getTime();
        this.timeUnitOfMeasurement = fault.getTimeUnitOfMeasurement();
        this.fallbackValue = fault.getFallbackValue();
        this.valueUnitOfMeasurement = fault.getValueUnitOfMeasurement();
    }
}
