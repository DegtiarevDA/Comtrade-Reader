package mpei.ru.back.logic;

/**
 * @author degtj on 17.08.2022
 * @project Comtrade_reader
 */
public class Furie {

    private float[] sin = new float[80];
    private float[] cos = new float[80];
    private float[] bufY = new float[80];
    private float[] bufX = new float[80];
    private float sumX = 0, sumY = 0;
    private float ortX = 0, ortY = 0;
    private float tempValue = 0;
    private float k = (float) (Math.sqrt(2)/80);
    private int number = 0;

    public Furie() {
        for(int i=0; i<80; i++) {
            sin[i] = (float) Math.sin(2*Math.PI*i/80);
            cos[i] = (float) Math.cos(2*Math.PI*i/80);
        }
    }

    private float[] get0rt(float meanValue) {

        tempValue = meanValue*sin[number];
        sumX = sumX+ tempValue - bufX[number];
        bufX[number] = tempValue;

        tempValue = meanValue*sin[number];
        sumY = sumY+ tempValue - bufY[number];
        bufY[number] = tempValue;

        ortX = k*sumX;
        ortY = k*sumY;

        number++; if(number==80) number = 0;

        return new float[] {ortX, ortY};
    }

    public float getRMS(float meanValue) {
        get0rt(meanValue);
        return (float) Math.sqrt(ortX*ortX+ortY*ortY);
    }
    public float getAngl(float meanValue) {
        get0rt(meanValue);
        return (float) Math.atan2(ortY, ortX);
    }

}
