public class Label {

    private final String name;
    private final BraileImage braileImg;

    public Label(String name) {
        this.name = name;
        this.braileImg = new NoBraileImage();
    }

    public Label(String name, BraileImage braileImgUrl) {
        this.name = name;
        this.braileImg = braileImgUrl;
    }

    public String print() {
        return this.name;
    }

    public BraileImage asBraile() {
        return this.braileImg;
    }
}
