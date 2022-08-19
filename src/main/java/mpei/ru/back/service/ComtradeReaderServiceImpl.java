package mpei.ru.back.service;

import mpei.ru.back.logic.ComtradeReader;
import mpei.ru.back.logic.Furie;
import mpei.ru.back.logic.Trigger;
import mpei.ru.back.model.entity.Fault;
import mpei.ru.back.repository.FaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */

@Service
public class ComtradeReaderServiceImpl implements ComtradeReaderService {

    @Autowired
    private FaultRepository faultRepository;

    private ArrayList<ArrayList<Float>> value;
    private LinkedList<ArrayList<Float>> valueRMS;
    private String[] valueName;
    private Integer[] time;
    private String[] unitOfMeasurement;
    private ArrayList<Integer> timeOfTrigger = new ArrayList<>();
    private ArrayList<Float> fallbackValue = new ArrayList<>();
    private ArrayList<String> triggeredValueName = new ArrayList<>();
    private ArrayList<String> triggeredUnitOfMeasurement = new ArrayList<>();

    @Override
    public void read(String path, String name) {
        ComtradeReader comtradeReader = new ComtradeReader(path, name);
        value = comtradeReader.read();
        valueName = comtradeReader.getValName();
        time = comtradeReader.getTime().toArray(new Integer[comtradeReader.getTime().size()]);
        unitOfMeasurement = comtradeReader.getUnitOfMeasurement();
        valueRMS = new LinkedList<>();
        for (ArrayList<Float> array : value) {
            valueRMS.add(new ArrayList<>());
            Furie furie = new Furie();
            for (Float element : array) {
                valueRMS.getLast().add(furie.getRMS(element));
            }
        }
    }

    @Override
    public void save() {
        for (int i = 0; i < triggeredValueName.size(); i++) {
            Fault fault = new Fault();
            fault.setValueName(triggeredValueName.get(i));
            fault.setTime(timeOfTrigger.get(i));
            fault.setFallbackValue(fallbackValue.get(i));
            fault.setValueUnitOfMeasurement(triggeredUnitOfMeasurement.get(i));
            try {
                faultRepository.save(fault);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void checkTrigger() {
        Trigger trigger = new Trigger(0.6f);
        trigger.checkTrigger(valueRMS, time, valueName, unitOfMeasurement);
        timeOfTrigger = trigger.getTimeOfTrigger();
        fallbackValue = trigger.getFallbackValue();
        triggeredValueName = trigger.getTriggeredValueName();
        triggeredUnitOfMeasurement = trigger.getTriggeredUnitOfMeasurement();
    }
}
