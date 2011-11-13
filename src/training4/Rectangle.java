package training4;

public class Rectangle {

    private int x;
    private int y;
    private int height;
    private int width;

    /**
     * Creates a rectangle with the buttom-left corner described by x and y with
     * the given length in 2D.
     * 
     * @param x
     *            Coordinate of buttom-left corner
     * @param y
     *            Coordinate of buttom-left corner
     * @param height
     *            Height of the rectangle
     * @param width
     *            Width of the rectangle
     */
    public Rectangle(int x, int y, int height, int width) {
        if (height <= 0 || width <= 0)
            throw new RuntimeException("Height or width is zero or negativ!");
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * @return Buttom-left corner x-Coordinate
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return Buttom-left corner y-Coordinate
     */
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return Height of the rectangle
     */
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return Width of the rectangle
     */
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "x=" + x + ",y=" + y + " , width=" + width + " , height="
                + height;
    }

    /**
     * Creates the smalles rectangle containing this and r2.
     * 
     * @param r2
     *            The other rectangle
     * @return A new Rectangle big enough to contain both
     */
    public Rectangle union(Rectangle r2) {

        return new Rectangle(Math.min(x, r2.getX()), Math.min(y, r2.getY()),
                Math.max(width, r2.getWidth()),
                Math.max(height, r2.getHeight()));
    }

    public boolean intersect(Rectangle r2) {
        // init new variables so we don't lose the old values
        int w1 = this.width;
        int h1 = this.height;
        int w2 = r2.getWidth();
        int h2 = r2.getHeight();

        int x1 = this.x;
        int y1 = this.y;
        int x2 = r2.getX();
        int y2 = r2.getY();

        // size the rectangles so two borders are the x and the y axis
        w2 += x2;
        h2 += y2;
        w1 += x1;
        h1 += y1;
        // check if the buttom-left corner is inside the big rectangle
        return ((((w2 < x2) || (w2 > x1))) && (((h2 < y2) || (h2 > y1)))
                && (((w1 < x1) || (w1 > x2))) && (((h1 < y1) || (h1 > y2))));
    }
}