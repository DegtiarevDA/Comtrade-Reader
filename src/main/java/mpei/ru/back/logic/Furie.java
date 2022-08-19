package mpei.ru.back.logic;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */
public class Furie {

    private static final int size = 400;

    private final float[] sin = new float[size];
    private final float[] cos = new float[size];
    private final float[] bufY = new float[size];
    private final float[] bufX = new float[size];
    private float sumX = 0, sumY = 0;
    private float ortX = 0, ortY = 0;
    private float tempValue = 0;
    private float k = (float) (Math.sqrt(2) / size);
    private int number = 0;

    public Furie() {
        for (int i = 0; i < size; i++) {
            sin[i] = (float) Math.sin(2 * Math.PI * i / size);
            cos[i] = (float) Math.cos(2 * Math.PI * i / size);
        }
    }

    private float[] get0rt(float meanValue) {

        tempValue = meanValue * sin[number];
        sumX = sumX + tempValue - bufX[number];
        bufX[number] = tempValue;

        tempValue = meanValue * cos[number];
        sumY = sumY + tempValue - bufY[number];
        bufY[number] = tempValue;

        ortX = k * sumX;
        ortY = k * sumY;

        number++;
        if (number == size) number = 0;

        return new float[]{ortX, ortY};
    }

    public float getRMS(float meanValue) {
        get0rt(meanValue);
        return (float) Math.sqrt(ortX * ortX + ortY * ortY);
    }

    public float getAngl(float meanValue) {
        get0rt(meanValue);
        return (float) Math.atan2(ortY, ortX);
    }

}
