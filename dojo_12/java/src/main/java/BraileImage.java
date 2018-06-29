public class BraileImage {

    public final String imgUrl;

    public BraileImage(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof BraileImage)) {
            return false;
        }

        BraileImage braileImage = (BraileImage) obj;

        return this.imgUrl.equals(braileImage.imgUrl);
    }
}
