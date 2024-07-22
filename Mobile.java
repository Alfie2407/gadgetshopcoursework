public class Mobile extends Gadget {
    private int credit;

    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
    }

    public void makeCall(String phoneNumber, int duration) {
        // Assume some implementation for making a call
        System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
    }

    @Override
    public String display() {
        return "Mobile Model: " + model + ", Price: " + price + ", Weight: " + weight + "g, Size: " + size + ", Credit: " + credit;
    }
}