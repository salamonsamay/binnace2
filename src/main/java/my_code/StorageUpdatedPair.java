package my_code;

import com.binance.connector.client.WebSocketStreamClient;
import com.binance.connector.client.impl.WebSocketStreamClientImpl;

import java.util.*;

public class StorageUpdatedPair {
    public WebSocketStreamClient client = new WebSocketStreamClientImpl();
    public static List<PairData> pairDataList =new LinkedList<>();

    public void update() {
        ArrayList<String> streams = new ArrayList<>();
        streams.add("btcusdt");
        streams.add("bnbusdt");
        streams.add("ethbtc");
        streams.add("ethusdt");
        streams.add("slpusdt");

        for(String value:streams){
            client.symbolTicker(value, ((event) -> {
                synchronized (this){
                    PairData pairData =new PairData(event);
                    if(pairDataList.contains(pairData)){
                        int index= pairDataList.indexOf(pairData);
                        pairDataList.set(index, pairData);

                    }
                    else{
                        pairDataList.add(pairData);

                    }

                }
            }));

        }

    }

    public void stop(){
        client.closeAllConnections();
    }

    private void processData(String eventData) {
        // Your logic to process the data goes here
        //   System.out.println("Received data: " + eventData);
    }

    public static PairData get(String pair){
        for(PairData p:pairDataList){
            if(p.getSymbol().equals(pair.toUpperCase())){
                return p;
            }
        }
        return null;
    }

    public static  boolean contains(String pair){
       return pairDataList.stream().anyMatch(v -> v.getSymbol().equals(pair.toUpperCase()));

    }




    public static void main(String[] args) {

        StorageUpdatedPair storage = new StorageUpdatedPair();
        storage.update();

        while (true){

            System.out.println(storage.pairDataList.size());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Example of peeking at the data

    }


}
