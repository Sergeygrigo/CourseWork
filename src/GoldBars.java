public class GoldBars {

    private int identifier;

    private int weight;
    private int price;
    private int size;

    public int getIdentifier() {
        return identifier;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public GoldBars(int identifier, int weight, int price, int size){

        this.identifier = identifier;

        this.weight = weight;
        this.price = price;
        this.size = size;
    }

    public String str() {
        return "id = " + identifier + "[size = " + size + ", weight = " + weight + "]";
    }
}



