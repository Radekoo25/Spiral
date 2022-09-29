import java.lang.reflect.Method;
import java.util.stream.IntStream;

public class Spiral {

    private int x_pos;
    private int y_pos;
    private int width;

    private Point[] points;

    public Spiral(int width) {

        this.x_pos = 0;
        this.y_pos = 0;
        this.width = width;
        this.points = new Point[width*width];
    }

    public void Reset() {
        this.x_pos = 0;
        this.y_pos = 0;
    }

    private void Step(int direction) {
        switch (direction) {
            case 0:
                this.x_pos++;
                break;
            case 1:
                this.y_pos++;
                break;
            case 2:
                this.x_pos--;
                break;
            case 3:
                this.y_pos--;
        }
    }

    private boolean IsPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }

    private boolean IsDivisibleBy(int number, int divider) {
        if(divider == 0 )
            divider = 1;
        return number%divider == 0;
    }

    public void DrawPrime() {
        int current = 0;
        int actualDirection = 0;
        int toRotate = 1;
        int toRotate_count = 0;

        while (current < this.width*this.width) {
            this.points[current] = new Point(this.x_pos,this.y_pos,IsPrime(current));
            // System.out.println("--"+current+"--"+"  x="+this.x_pos+" | y="+this.y_pos+" | prime="+IsPrime(current));

            Step(actualDirection%4);

            current++;
            toRotate_count++;

            if(toRotate_count == toRotate) {
                actualDirection++;
                toRotate_count = 0;
                if(actualDirection%2 == 0) {
                    toRotate++;
                }
            }
        }
    }

    public void DrawModulo(int divider) {
        int current = 0;
        int actualDirection = 0;
        int toRotate = 1;
        int toRotate_count = 0;

        while (current < this.width*this.width) {
            this.points[current] = new Point(this.x_pos,this.y_pos,IsDivisibleBy(current,divider));
            // System.out.println("--"+current+"--"+"  x="+this.x_pos+" | y="+this.y_pos+" | prime="+IsPrime(current));

            Step(actualDirection%4);

            current++;
            toRotate_count++;

            if(toRotate_count == toRotate) {
                actualDirection++;
                toRotate_count = 0;
                if(actualDirection%2 == 0) {
                    toRotate++;
                }
            }
        }
    }

    public void DrawPrimePlusN(int n) {
        int current = n;
        int actualDirection = 0;
        int toRotate = 1;
        int toRotate_count = 0;

        while (current < (this.width*this.width + n) ) {
            this.points[current-n] = new Point(this.x_pos,this.y_pos,IsPrime(current));
            // System.out.println("--"+current+"--"+"  x="+this.x_pos+" | y="+this.y_pos+" | prime="+IsPrime(current));

            Step(actualDirection%4);

            current++;
            toRotate_count++;

            if(toRotate_count == toRotate) {
                actualDirection++;
                toRotate_count = 0;
                if(actualDirection%2 == 0) {
                    toRotate++;
                }
            }
        }
    }

    public void Print() {
        for(int i=0;i<this.width*this.width;i++) {
            System.out.println(i+"  "+this.points[i].toString());
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public int getWidth() {
        return width;
    }
}


