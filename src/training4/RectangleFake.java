package training4;

@SuppressWarnings("serial")
public class RectangleFake extends java.awt.Rectangle {

    public RectangleFake(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public boolean intersect(RectangleFake r2) {

        return super.intersects(r2);
    }

}
