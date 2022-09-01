package mpei.ru.back.service;

import mpei.ru.back.model.dto.DataDTO;
import mpei.ru.back.model.dto.FaultDTO;

import java.util.List;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */

public interface ComtradeReaderService {

    void read(String path, String name);
    void save();
    void checkTrigger();
    List<FaultDTO> getFault();
    List<DataDTO> getData();

}
