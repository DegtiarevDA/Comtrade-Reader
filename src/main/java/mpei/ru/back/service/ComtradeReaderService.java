package mpei.ru.back.service;

/**
 * @author degtj on 17.08.2022
 * @project Comtrade_reader
 */

public interface ComtradeReaderService {

    void read(String path, String name);
    String save();
    void checkTrigger();

}
