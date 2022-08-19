package mpei.ru.back.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author degtj on 17.08.2022
 * @project Comtrade_reader
 */

@Data
@Entity
@Table(name = "fault")
public class Fault {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "time")
    private int time;

    @Column(name = "time_unit_of_measurement")
    private String timeUnitOfMeasurement = "ms";

    @Column(name = "value")
    private int value;

    @Column(name = "value_unit_of_measurement")
    private String valueUnitOfMeasurement;

}
