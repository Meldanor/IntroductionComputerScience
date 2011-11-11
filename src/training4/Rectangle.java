package training4;

public class Rectangle {

    private int x;
    private int y;
    private int height;
    private int width;

    public Rectangle(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

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

    public Rectangle union(Rectangle r2) {

        return new Rectangle(Math.min(x, r2.getX()), Math.min(y, r2.getY()),
                Math.max(width, r2.getWidth()),
                Math.max(height, r2.getHeight()));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Rectangle))
            return false;
        Rectangle r2 = (Rectangle) obj;

        return r2.getX() == this.x && r2.getY() == this.y
                && r2.getWidth() == width && r2.getHeight() == height;
    }

    public boolean intersect(Rectangle r2) {
        if (equals(r2))
            return true;
        int x1 = r2.getX();
        int y1 = r2.getY();
        int height1 = r2.getHeight();
        int width1 = r2.getWidth();
        return isInside(x1 + width1, y1 + height1, x, y, width, height)
            || isInside(x1, y1 + height1, x, y, width, height)
            || isInside(x1 + width1, y1, x, y, width, height)
            || isInside(x1, y1, x, y, width, height)

            || isInside(x + width, y + height, x1, y1, width1, height1)
            || isInside(x, y + height, x1, y1, width1, height1)
            || isInside(x + width, y, x1, y1, width1, height1)
            || isInside(x, y, x1, y1, width1, height1);
    }

    public boolean isInside(int x, int y, int x1, int z1, int width, int height) {
        return (x < x1 + width) && (x > x1 - width) && (y < z1 + height)
                && (y > z1 - height);
    }

}
