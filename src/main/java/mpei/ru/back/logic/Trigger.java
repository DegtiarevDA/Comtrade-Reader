package mpei.ru.back.logic;

import java.util.ArrayList;

/**
 * @author degtj on 17.08.2022
 * @project Comtrade_reader
 */
public class Trigger {

    private int[] timeOfTrigger;
    private float[] fallbackValue;
    private String[] triggeredValueName;

    public int[] getTimeOfTrigger() {
        return timeOfTrigger;
    }

    public float[] getFallbackValue() {
        return fallbackValue;
    }

    public String[] getTriggeredValueName() {
        return triggeredValueName;
    }

    private float setParameter;

    public Trigger(float setParameter) {
        this.setParameter = setParameter;
    }

    public void checkTrigger(float[][] value, int[] time, String[] valueName) {
        int j = 0;
        for (float[] array : value) {
            int i = 0;
            int k = 0;
            ArrayList<Integer> tempTime = new ArrayList<>();
            ArrayList<Float> tempVal = new ArrayList<>();
            ;
            for (float element : array) {
                if (j < 3 && element > setParameter) {
                    triggeredValueName[j] = valueName[j];
                    tempTime.add(time[i]);
                    tempVal.add(element);
                    k++;
                }
                if(tempVal.size() != 0 || tempVal != null) {
                    fallbackValue[j] = tempVal.get((int) tempVal.size() / 2);
                }
                if(tempTime.size() != 0 || tempTime != null) {
                    timeOfTrigger[j] = tempTime.get(0);
                }
                i++;
            }
            j++;
        }
    }

}
