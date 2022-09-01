package mpei.ru.back.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */

@Data
@Entity
@Table(name = "fault")
public class Fault implements Serializable {
    @Id
    @Column(name = "value_name", nullable = false)
    private String valueName;

    @Column(name = "time")
    private float time;

    @Column(name = "time_unit_of_measurement")
    private String timeUnitOfMeasurement;

    @Column(name = "fallback_value")
    private float fallbackValue;

    @Column(name = "value_unit_of_measurement")
    private String valueUnitOfMeasurement;

    public Fault(String valueName, float time, String timeUnitOfMeasurement, float fallbackValue, String valueUnitOfMeasurement) {
        this.valueName = valueName;
        this.time = time;
        this.timeUnitOfMeasurement = timeUnitOfMeasurement;
        this.fallbackValue = fallbackValue;
        this.valueUnitOfMeasurement = valueUnitOfMeasurement;
    }

    public Fault() {
    }
}
