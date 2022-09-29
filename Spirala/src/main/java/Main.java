import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    private static boolean IsPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
//        int WIDTH = 1000;
        int MIN = 500;
        int MAX = 800;

        System.out.println("Set resolution of square: ");
        int WIDTH = in.nextInt();

        System.out.println("Select a mode:" +
                "\n1 - PrimeSpiral" +
                "\n2 - DivisibleBy" +
                "\n3 - PrimeSpiralAnimation");
        int mode = in.nextInt();

        Spiral spiral = new Spiral(WIDTH);
        Image image = new Image();
        String file_name = WIDTH+"--";

        switch (mode) {
            case 1:
                file_name = file_name+"PrimeSpiral--";
                spiral.DrawPrime();
                image.MakeFile(spiral.getPoints(),WIDTH,file_name);
                break;

            case 2:
                System.out.println("Enter the number, " +
                        "whose multiples will be marked on the spiral: ");
                int divider = in.nextInt();
                file_name = file_name+"DivisibleBy"+divider+"--";
                spiral.DrawModulo(divider);
                image.MakeFile(spiral.getPoints(),WIDTH,file_name);
                break;

            case 3:
                file_name = file_name+"PrimeSpiralVideo";
                System.out.println("Enter number of frames: ");
                int frames = in.nextInt();
                for (int i=0; i<frames; i++) {
                    spiral.DrawPrimePlusN(i);
                    image.MakeFile(spiral.getPoints(),WIDTH,file_name+i+"--");
                    spiral.Reset();
                }
                break;
        }

//        for (int i=MIN; i<=MAX; i++) {
//            //if(IsPrime(i)){
//                spiral_modulo = new Spiral(WIDTH);
//                spiral_modulo.DrawModulo(i);
//                image.MakeFile2(spiral_modulo.getPoints(),spiral_modulo.getWidth(),divisible_by+i+"--");
//                spiral_modulo = null;
//            //}
//        }
    }
}
