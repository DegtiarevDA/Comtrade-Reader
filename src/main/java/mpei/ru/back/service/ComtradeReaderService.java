package mpei.ru.back.service;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */

public interface ComtradeReaderService {

    void read(String path, String name);
    void save();
    void checkTrigger();

}
