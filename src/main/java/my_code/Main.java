package my_code;

import com.binance.connector.client.WebSocketStreamClient;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.WebSocketStreamClientImpl;
import com.binance.connector.client.impl.spot.Market;

import java.util.LinkedHashMap;
import java.util.Map;

//ApNtmkWVI5OhYXYUkZM5K0th0nWAto2YI3A0bQ2xLzFkmpMIU7bSrRUp7PKhNRla
public class Main {
    public static void main(String[] args) throws InterruptedException {
        double number= ExtractStepSize.extract("BTCUSDT");


        // Using String.format
        String formattedNumber1 = String.format("%.5f", number);
        System.out.println(formattedNumber1);

    }
}
