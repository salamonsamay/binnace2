package my_code;

public class Coin {

    private long eventTime;
    private String symbol;
    private String price;
    private String quantity;
    long firstTradeId;
    long lastTradeId;
    private long tradeTime;
    private boolean isBuyerMarketMaker;
    private boolean isTradeMaker;

    public Coin(String eventType, long eventTime, String symbol, long aggregatedTradeId,
                String price, String quantity, long firstTradeId, long lastTradeId,
                long tradeTime, boolean isBuyerMarketMaker, boolean isTradeMaker) {
        this.eventTime = eventTime;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.firstTradeId = firstTradeId;
        this.lastTradeId = lastTradeId;
        this.tradeTime = tradeTime;
        this.isBuyerMarketMaker = isBuyerMarketMaker;
        this.isTradeMaker = isTradeMaker;
    }



    // Example usage:
    public static void main(String[] args) {
        // Sample coin data
        String eventType = "aggTrade";
        long eventTime = 1700762654302L;
        String symbol = "BTCUSDT";
        long aggregatedTradeId = 2766318485L;
        String price = "37189.92000000";
        String quantity = "0.00236000";
        long firstTradeId = 3292972015L;
        long lastTradeId = 3292972015L;
        long tradeTime = 1700762654302L;
        boolean isBuyerMarketMaker = true;
        boolean isTradeMaker = true;

        // Create Coin instance
        Coin coinInstance = new Coin(eventType, eventTime, symbol, aggregatedTradeId,
                price, quantity, firstTradeId, lastTradeId, tradeTime,
                isBuyerMarketMaker, isTradeMaker);

        // Print coin details
        System.out.println(coinInstance);
    }
}
