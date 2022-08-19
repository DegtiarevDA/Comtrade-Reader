package mpei.ru.back.logic;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */
public class Trigger {

    private ArrayList<Integer> timeOfTrigger = new ArrayList<>();
    private ArrayList<Float> fallbackValue = new ArrayList<>();
    private ArrayList<String> triggeredValueName = new ArrayList<>();
    private ArrayList<String> triggeredUnitOfMeasurement = new ArrayList<>();
    private float setParameter;

    public ArrayList<String> getTriggeredUnitOfMeasurement() {
        return triggeredUnitOfMeasurement;
    }

    public ArrayList<Integer> getTimeOfTrigger() {
        return timeOfTrigger;
    }

    public ArrayList<Float> getFallbackValue() {
        return fallbackValue;
    }

    public ArrayList<String> getTriggeredValueName() {
        return triggeredValueName;
    }

    public Trigger(float setParameter) {
        this.setParameter = setParameter;
    }

    public void checkTrigger(LinkedList<ArrayList<Float>> value, Integer[] time, String[] valueName, String[] unitOfMeasurement) {
        int j = 0;
        for (ArrayList<Float> array : value) {
            int i = 0;
            ArrayList<Integer> tempTime = new ArrayList<>();
            ArrayList<Float> tempVal = new ArrayList<>();
            boolean trigger = false;
            for (float element : array) {
                if (j < 3 && element > setParameter) {
                    tempTime.add(time[i]);
                    tempVal.add(element);
                    trigger = true;
                }
                i++;
            }
            if (trigger) {
                triggeredValueName.add(valueName[j]);
                triggeredUnitOfMeasurement.add(unitOfMeasurement[j]);
                if (tempVal.size() != 0 && tempVal != null) {
                    fallbackValue.add(tempVal.get((int) tempVal.size() / 2));
                }
                if (tempTime.size() != 0 && tempTime != null) {
                    timeOfTrigger.add(tempTime.get(0));
                }
            }
            j++;
        }
    }
}
