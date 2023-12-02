package my_code;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PairData {
    private String eventType;
    private long eventTime;
    private String symbol;
    private String priceChange;
    private String priceChangePercent;
    private String weightedAvgPrice;
    private String prevClosePrice;
    private String lastPrice;
    private String lastQty;
    private String bidPrice;
    private String bidQty;
    private String askPrice;
    private String askQty;
    private String openPrice;
    private String highPrice;
    private String lowPrice;
    private String volume;
    private String quoteVolume;
    private long openTime;
    private long closeTime;
    private long firstTradeId;
    private long lastTradeId;
    private long tradeCount;

    public PairData(
            @JsonProperty("e") String eventType,
            @JsonProperty("E") long eventTime,
            @JsonProperty("s") String symbol,
            @JsonProperty("p") String priceChange,
            @JsonProperty("P") String priceChangePercent,
            @JsonProperty("w") String weightedAvgPrice,
            @JsonProperty("x") String prevClosePrice,
            @JsonProperty("c") String lastPrice,
            @JsonProperty("Q") String lastQty,
            @JsonProperty("b") String bidPrice,
            @JsonProperty("B") String bidQty,
            @JsonProperty("a") String askPrice,
            @JsonProperty("A") String askQty,
            @JsonProperty("o") String openPrice,
            @JsonProperty("h") String highPrice,
            @JsonProperty("l") String lowPrice,
            @JsonProperty("v") String volume,
            @JsonProperty("q") String quoteVolume,
            @JsonProperty("O") long openTime,
            @JsonProperty("C") long closeTime,
            @JsonProperty("F") long firstTradeId,
            @JsonProperty("L") long lastTradeId,
            @JsonProperty("n") long tradeCount) {
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.symbol = symbol;
        this.priceChange = priceChange;
        this.priceChangePercent = priceChangePercent;
        this.weightedAvgPrice = weightedAvgPrice;
        this.prevClosePrice = prevClosePrice;
        this.lastPrice = lastPrice;
        this.lastQty = lastQty;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.volume = volume;
        this.quoteVolume = quoteVolume;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.firstTradeId = firstTradeId;
        this.lastTradeId = lastTradeId;
        this.tradeCount = tradeCount;
    }

    public PairData(String jsonString) {
        // Use Jackson ObjectMapper to parse JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // Set values from JSON fields
            this.eventType = jsonNode.get("e").asText();
            this.eventTime = jsonNode.get("E").asLong();
            this.symbol = jsonNode.get("s").asText();
            this.priceChange = jsonNode.get("p").asText();
            this.priceChangePercent = jsonNode.get("P").asText();
            this.weightedAvgPrice = jsonNode.get("w").asText();
            this.prevClosePrice = jsonNode.get("x").asText();
            this.lastPrice = jsonNode.get("c").asText();
            this.lastQty = jsonNode.get("Q").asText();
            this.bidPrice = jsonNode.get("b").asText();
            this.bidQty = jsonNode.get("B").asText();
            this.askPrice = jsonNode.get("a").asText();
            this.askQty = jsonNode.get("A").asText();
            this.openPrice = jsonNode.get("o").asText();
            this.highPrice = jsonNode.get("h").asText();
            this.lowPrice = jsonNode.get("l").asText();
            this.volume = jsonNode.get("v").asText();
            this.quoteVolume = jsonNode.get("q").asText();
            this.openTime = jsonNode.get("O").asLong();
            this.closeTime = jsonNode.get("C").asLong();
            this.firstTradeId = jsonNode.get("F").asLong();
            this.lastTradeId = jsonNode.get("L").asLong();
            this.tradeCount = jsonNode.get("n").asLong();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @JsonProperty("e")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("E")
    public long getEventTime() {
        return eventTime;
    }

    @JsonProperty("s")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("p")
    public String getPriceChange() {
        return priceChange;
    }

    @JsonProperty("P")
    public String getPriceChangePercent() {
        return priceChangePercent;
    }

    @JsonProperty("w")
    public String getWeightedAvgPrice() {
        return weightedAvgPrice;
    }

    @JsonProperty("x")
    public String getPrevClosePrice() {
        return prevClosePrice;
    }

    @JsonProperty("c")
    public String getLastPrice() {
        return lastPrice;
    }

    @JsonProperty("Q")
    public String getLastQty() {
        return lastQty;
    }

    @JsonProperty("b")
    public String getBidPrice() {
        return bidPrice;
    }

    @JsonProperty("B")
    public String getBidQty() {
        return bidQty;
    }

    @JsonProperty("a")
    public String getAskPrice() {
        return askPrice;
    }

    @JsonProperty("A")
    public String getAskQty() {
        return askQty;
    }

    @JsonProperty("o")
    public String getOpenPrice() {
        return openPrice;
    }

    @JsonProperty("h")
    public String getHighPrice() {
        return highPrice;
    }

    @JsonProperty("l")
    public String getLowPrice() {
        return lowPrice;
    }

    @JsonProperty("v")
    public String getVolume() {
        return volume;
    }

    @JsonProperty("q")
    public String getQuoteVolume() {
        return quoteVolume;
    }

    @JsonProperty("O")
    public long getOpenTime() {
        return openTime;
    }

    @JsonProperty("C")
    public long getCloseTime() {
        return closeTime;
    }

    @JsonProperty("F")
    public long getFirstTradeId() {
        return firstTradeId;
    }

    @JsonProperty("L")
    public long getLastTradeId() {
        return lastTradeId;
    }

    @JsonProperty("n")
    public long getTradeCount() {
        return tradeCount;
    }

    // Add any additional getters if needed

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  PairData)){return false;}

        PairData pairData = (PairData) obj;

        if(this.getSymbol().equals(((PairData) obj).getSymbol())){
            return true;
        }
        return false;


    }

    @Override
    public String toString() {
        return "TickerData{" +
                "eventType='" + eventType + '\'' +
                ", eventTime=" + eventTime +
                ", symbol='" + symbol + '\'' +
                ", priceChange='" + priceChange + '\'' +
                ", priceChangePercent='" + priceChangePercent + '\'' +
                ", weightedAvgPrice='" + weightedAvgPrice + '\'' +
                ", prevClosePrice='" + prevClosePrice + '\'' +
                ", lastPrice='" + lastPrice + '\'' +
                ", lastQty='" + lastQty + '\'' +
                ", bidPrice='" + bidPrice + '\'' +
                ", bidQty='" + bidQty + '\'' +
                ", askPrice='" + askPrice + '\'' +
                ", askQty='" + askQty + '\'' +
                ", openPrice='" + openPrice + '\'' +
                ", highPrice='" + highPrice + '\'' +
                ", lowPrice='" + lowPrice + '\'' +
                ", volume='" + volume + '\'' +
                ", quoteVolume='" + quoteVolume + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", firstTradeId=" + firstTradeId +
                ", lastTradeId=" + lastTradeId +
                ", tradeCount=" + tradeCount +
                '}';
    }
}


