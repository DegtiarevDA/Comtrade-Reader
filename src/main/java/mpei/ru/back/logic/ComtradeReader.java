package mpei.ru.back.logic;

import java.io.*;

/**
 * @author degtj on 17.08.2022
 * @project Comtrade_reader
 */

public class ComtradeReader {

    private String line;
    private File dataCfg;
    private File dataDat;

    private float[] k1 = new float[18];
    private float[] k2 = new float[18];

    private String[] valName = new String[18];
    private int[] time;
    private String[] unitOfMeasurement = new String[18];

    public String[] getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public int[] getTime() {
        return time;
    }

    public String[] getValName() {
        return valName;
    }

    public ComtradeReader(String path, String name) {
        if (path == null || name == null) {
            path = "src/main/resources/comtrade/";
            name = "*";
        }
        dataCfg = new File(path + name + ".cfg");
        dataDat = new File(path + name + ".dat");
    }

    public float[][] read() {
        BufferedReader bufReadCfg = null;
        BufferedReader bufReadDat = null;
        try {


            bufReadCfg = new BufferedReader(new FileReader(dataCfg));
            bufReadDat = new BufferedReader(new FileReader(dataDat));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int number = 0;
        String[] parse;
        try {
            while ((line = bufReadCfg.readLine()) != null) {
                if (number >= 2 && number <= 19) {
                    parse = line.split(",");
                    unitOfMeasurement[number - 2] = parse[4];
                    k1[number - 2] = Float.parseFloat(parse[5]);
                    k2[number - 2] = Float.parseFloat(parse[6]);
                    valName[number - 2] = parse[1];
                }
                number++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        float[][] value = new float[18][];

        int j = 0;
        try {
            while ((line = bufReadDat.readLine()) != null) {
                parse = line.split(",");
                int i = 0;
                for (String el : parse) {
                    if (i >= 2 && i <= 19) {
                        value[i - 2][j] = Float.parseFloat(el) * k1[j] + k2[j];
                    } else if (i == 1) {
                        time[j] = Integer.parseInt(el);
                    }
                    i++;
                }
                j++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
