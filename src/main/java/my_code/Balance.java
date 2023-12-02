package my_code;

public class Balance {
    private final String asset;
    private final String free;
    private final String locked;

    public Balance(String asset, String free, String locked) {
        this.asset = asset;
        this.free = free;
        this.locked = locked;
    }

    public String getAsset() {
        return asset;
    }

    public String getFree() {
        return free;
    }

    public String getLocked() {
        return locked;
    }
    @Override
    public boolean equals(Object o) {
        Balance other = (Balance) o;
        if(this.getAsset().equals(other.getAsset())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "asset='" + asset + '\'' +
                ", free='" + free + '\'' +
                ", locked='" + locked + '\'' +
                '}';
    }
}