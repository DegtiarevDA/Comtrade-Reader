package mpei.ru.back.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */

@Data
@Entity
@Table(name = "fault")
public class Fault {
    @Id
    @Column(name = "value_name", nullable = false)
    private String ValueName;

    @Column(name = "time")
    private int time;

    @Column(name = "time_unit_of_measurement")
    private String timeUnitOfMeasurement = "ms";

    @Column(name = "fallback_value")
    private float fallbackValue;

    @Column(name = "value_unit_of_measurement")
    private String valueUnitOfMeasurement;

}
