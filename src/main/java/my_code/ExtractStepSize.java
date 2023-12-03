package my_code;

import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Market;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

public class ExtractStepSize {






    public  static  int countDiggitAfterDot(String pair) {
        SpotClientImpl client = new SpotClientImpl();
        Market market = client.createMarket();
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        parameters.put("symbol",pair);
        String jsonString = market.exchangeInfo(parameters);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // Assuming you want to countDiggitAfterDot stepSize from the first element in the symbols array
            JsonNode symbolsArray = jsonNode.path("symbols");
            if (symbolsArray.isArray() && symbolsArray.size() > 0) {
                JsonNode firstSymbol = symbolsArray.get(0);
                JsonNode filtersArray = firstSymbol.path("filters");
                if (filtersArray.isArray() && filtersArray.size() > 0) {
                    JsonNode firstFilter = filtersArray.get(1);

                    return  countDiggitAfterDot_(firstFilter.get("stepSize").asText());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;

    }


    public static double prefix(double quntity, int y) {
        if (y < 0) {
            throw new IllegalArgumentException("The number of digits to truncate must be non-negative.");
        }

        // Multiply by a power of 10 to shift the decimal point, then truncate the decimal part
        double multiplier = Math.pow(10, y);
        double truncatedValue = Math.floor(quntity * multiplier) / multiplier;

        return truncatedValue;
    }

    private   static int countDiggitAfterDot_(String num){
        String newNum=num.substring(num.indexOf("."));
        for(int i=0;i<newNum.length();i++){
            if((newNum.charAt(i)+"").equals("1")){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String jsonString = "{\"timezone\":\"UTC\",\"serverTime\":1701536067775,\"rateLimits\":[{\"rateLimitType\":\"REQUEST_WEIGHT\",\"interval\":\"MINUTE\",\"intervalNum\":1,\"limit\":6000},{\"rateLimitType\":\"ORDERS\",\"interval\":\"SECOND\",\"intervalNum\":10,\"limit\":100},{\"rateLimitType\":\"ORDERS\",\"interval\":\"DAY\",\"intervalNum\":1,\"limit\":200000},{\"rateLimitType\":\"RAW_REQUESTS\",\"interval\":\"MINUTE\",\"intervalNum\":5,\"limit\":61000}],\"exchangeFilters\":[],\"symbols\":[{\"symbol\":\"BTCUSDT\",\"status\":\"TRADING\",\"baseAsset\":\"BTC\",\"baseAssetPrecision\":8,\"quoteAsset\":\"USDT\",\"quotePrecision\":8,\"quoteAssetPrecision\":8,\"baseCommissionPrecision\":8,\"quoteCommissionPrecision\":8,\"orderTypes\":[\"LIMIT\",\"LIMIT_MAKER\",\"MARKET\",\"STOP_LOSS_LIMIT\",\"TAKE_PROFIT_LIMIT\"],\"icebergAllowed\":true,\"ocoAllowed\":true,\"quoteOrderQtyMarketAllowed\":true,\"allowTrailingStop\":true,\"cancelReplaceAllowed\":true,\"isSpotTradingAllowed\":true,\"isMarginTradingAllowed\":true,\"filters\":[{\"filterType\":\"PRICE_FILTER\",\"minPrice\":\"0.01000000\",\"maxPrice\":\"1000000.00000000\",\"tickSize\":\"0.01000000\"},{\"filterType\":\"LOT_SIZE\",\"minQty\":\"0.00001000\",\"maxQty\":\"9000.00000000\",\"stepSize\":\"0.00001000\"},{\"filterType\":\"ICEBERG_PARTS\",\"limit\":10},{\"filterType\":\"MARKET_LOT_SIZE\",\"minQty\":\"0.00000000\",\"maxQty\":\"186.68768012\",\"stepSize\":\"0.00000000\"},{\"filterType\":\"TRAILING_DELTA\",\"minTrailingAboveDelta\":10,\"maxTrailingAboveDelta\":2000,\"minTrailingBelowDelta\":10,\"maxTrailingBelowDelta\":2000},{\"filterType\":\"PERCENT_PRICE_BY_SIDE\",\"bidMultiplierUp\":\"5\",\"bidMultiplierDown\":\"0.2\",\"askMultiplierUp\":\"5\",\"askMultiplierDown\":\"0.2\",\"avgPriceMins\":5},{\"filterType\":\"NOTIONAL\",\"minNotional\":\"5.00000000\",\"applyMinToMarket\":true,\"maxNotional\":\"9000000.00000000\",\"applyMaxToMarket\":false,\"avgPriceMins\":5},{\"filterType\":\"MAX_NUM_ORDERS\",\"maxNumOrders\":200},{\"filterType\":\"MAX_NUM_ALGO_ORDERS\",\"maxNumAlgoOrders\":5}],\"permissions\":[\"SPOT\",\"MARGIN\",\"TRD_GRP_004\",\"TRD_GRP_005\",\"TRD_GRP_006\",\"TRD_GRP_009\",\"TRD_GRP_010\",\"TRD_GRP_011\",\"TRD_GRP_012\",\"TRD_GRP_013\",\"TRD_GRP_014\",\"TRD_GRP_015\",\"TRD_GRP_016\",\"TRD_GRP_017\",\"TRD_GRP_018\",\"TRD_GRP_019\",\"TRD_GRP_020\",\"TRD_GRP_021\",\"TRD_GRP_022\",\"TRD_GRP_023\",\"TRD_GRP_024\",\"TRD_GRP_025\"],\"defaultSelfTradePreventionMode\":\"EXPIRE_MAKER\",\"allowedSelfTradePreventionModes\":[\"EXPIRE_TAKER\",\"EXPIRE_MAKER\",\"EXPIRE_BOTH\"]}]}";

       // System.out.println(countDiggitAfterDot("333.001000"));


    }
}
