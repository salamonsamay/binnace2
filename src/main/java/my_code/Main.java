package my_code;

import com.binance.connector.client.impl.SpotClientImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;

//ApNtmkWVI5OhYXYUkZM5K0th0nWAto2YI3A0bQ2xLzFkmpMIU7bSrRUp7PKhNRla
public class Main {
    public static long extractTimeFromLastIndex(String jsonString) {
        try {
            // Parse the JSON string
            JSONArray jsonArray = new JSONArray(jsonString);

            // Get the last element in the array
            JSONObject lastObject = jsonArray.getJSONObject(jsonArray.length() - 1);

            // Extract the "time" field from the last object
            System.out.println(lastObject.getString("status"));
            return lastObject.getLong("time");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
            return -1; // Return a default value or handle the error accordingly
        }
    }
    public static void main(String[] args) throws InterruptedException {
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY, PrivateConfig.BASE_URL);
        parameters.put("symbol", "BTCUSDT");
        String result=client.createTrade().getOrders(parameters);
        System.out.println(result);
        System.out.println(extractTimeFromLastIndex(result));
    }
}
