package com.olaoye.klasha.constants;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class CsvCurrencyConstants {

    public static Double EUR_NGN;
    public static Double USD_NGN;
    public static Double JPY_NGN;
    public static Double GBP_NGN;
    public static Double EUR_UGX;
    public static Double USD_UGX;
    public static Double JPY_UGX;
    public static Double GBP_UGX;

    private static final String FILE_PATH = "src/main/resources/exchange_rate.csv";

public void init() {
        List<String[]> currencyList = readCSV(FILE_PATH);
        EUR_NGN = Double.parseDouble(currencyList.get(0)[2]);
        USD_NGN = Double.parseDouble(currencyList.get(1)[2]);
        JPY_NGN = Double.parseDouble(currencyList.get(2)[2]);
        GBP_NGN = Double.parseDouble(currencyList.get(3)[2]);
        EUR_UGX = Double.parseDouble(currencyList.get(4)[2]);
        USD_UGX = Double.parseDouble(currencyList.get(5)[2]);
        JPY_UGX = Double.parseDouble(currencyList.get(6)[2]);
        GBP_UGX = Double.parseDouble(currencyList.get(7)[2]);

        for (String[] currency : currencyList) {
            //for debuging purpose
            log.info("[Source Currency:] "  + currency[0] +"  [Target Currency:] " + currency[1]+"  [Rate:] " + currency[2]+'\n');
        }

    }

    private static List<String[]> readCSV(String filePath) {

        List<String[]> currencyList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] currency = line.split(",");
                currencyList.add(currency);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return currencyList;
    }


}
