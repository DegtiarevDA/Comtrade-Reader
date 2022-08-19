package mpei.ru.back.service;

import mpei.ru.back.logic.ComtradeReader;
import mpei.ru.back.logic.Furie;
import org.springframework.stereotype.Service;

/**
 * @author degtj on 17.08.2022
 * @project Comtrade_reader
 */
@Service
public class ComtradeReaderServiceImpl implements ComtradeReaderService {

    private float[][] val;
    private float[][] valRMS;
    private String[] valName;
    private int[] time;
    private String[] unitOfMeasurement;


    @Override
    public void read(String path, String name) {
        ComtradeReader comtradeReader = new ComtradeReader(path, name);
        val = comtradeReader.read();
        valName = comtradeReader.getValName();
        time = comtradeReader.getTime();
        unitOfMeasurement = comtradeReader.getUnitOfMeasurement();
        int j = 0;
        for (float[] array : val) {
            Furie furie = new Furie();
            int i = 0;
            for (float element : array) {
                valRMS[j][i] = furie.getRMS(element);
                i++;
            }
            j++;
        }
    }

    @Override
    public String save() {
        return null;
    }

    @Override
    public void checkTrigger() {

    }
}
