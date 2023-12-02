package examples;
public final class PrivateConfig {
    private PrivateConfig() {
    }
    public static final String BASE_URL = "https://api1.binance.com";

    public static final String API_KEY = "rAOgUaQ9WtNRaiwk7kfISSAJksul3M5VZRdpc9PSKDROgwXheliKszrT2oAIa69y";
    public static final String SECRET_KEY = "ApNtmkWVI5OhYXYUkZM5K0th0nWAto2YI3A0bQ2xLzFkmpMIU7bSrRUp7PKhNRla"; // Unnecessary if PRIVATE_KEY_PATH is used
    public static final String PRIVATE_KEY_PATH = "C:\\Users\\salam\\Desktop\\private_key.txt"; // Key must be PKCS#8 standard

    public static final String TESTNET_API_KEY = "";
    public static final String TESTNET_SECRET_KEY = ""; // Unnecessary if TESTNET_PRIVATE_KEY_PATH is used
    public static final String TESTNET_PRIVATE_KEY_PATH = ""; //Key must be PKCS#8 standard
}
