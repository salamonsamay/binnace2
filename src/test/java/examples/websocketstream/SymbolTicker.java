package examples.websocketstream;

import com.binance.connector.client.WebSocketStreamClient;
import com.binance.connector.client.impl.WebSocketStreamClientImpl;

public final class SymbolTicker {
    private SymbolTicker() {
    }

    public static void main(String[] args) {
        WebSocketStreamClient client = new WebSocketStreamClientImpl();
        client.symbolTicker("ethusdt", ((event) -> {
            System.out.println(event);
            client.closeAllConnections();
            try {
                Thread.sleep(2000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
    }
}
