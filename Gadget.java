public abstract class Gadget {
    protected String model;
    protected double price;
    protected int weight;
    protected String size;

    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    public abstract String display();
}