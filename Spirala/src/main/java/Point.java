public class Point {

    private int pos_x;
    private int pos_y;
    private boolean isTrue;

    public Point(int pos_x, int pos_y, boolean isTrue) {

        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.isTrue = isTrue;
    }

    @Override
    public String toString() {
        return "Point{" +
                "pos_x=" + pos_x +
                ", pos_y=" + pos_y +
                ", isPrime=" + isTrue +
                '}';
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public int isTrue() {
        if(isTrue) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
