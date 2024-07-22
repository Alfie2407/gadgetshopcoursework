public class MP3 extends Gadget {
    private int memory;

    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }

    public void downloadMusic(int size) {
        // Assume some implementation for downloading music
        System.out.println("Downloading music of size " + size + "MB.");
    }

    @Override
    public String display() {
        return "MP3 Model: " + model + ", Price: " + price + ", Weight: " + weight + "g, Size: " + size + ", Memory: " + memory + "MB";
    }
}