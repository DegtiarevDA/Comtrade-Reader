package mpei.ru.back.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Degtiarev Dmitry on 01.09.2022
 * @project Comtrade_reader
 */

@Data
public class DataDTO {

    private String name;
    private String type;
    private List<?> values;
    private boolean clicked = false;
    private List<Float> RMS;

}
