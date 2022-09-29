import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Image {
    public Image() {}

    public void MakeFile(Point[] points, int size, String fileName) {

        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        File file = null;

        int a,r,g,b;
        int p;
        int x,y;

        //create image pixel by pixel
        for(int i = 0; i<size*size; i++){

            a = (int)(1*255); //alpha
            r = (int)(points[i].isTrue()*255); //red
            g = (int)(points[i].isTrue()*255); //green
            b = (int)(points[i].isTrue()*255); //blue


            p = (a<<24) | (r<<16) | (g<<8) | b; //pixel

            if(size%2 == 0) {
                x = points[i].getPos_x()+size/2-1;
                y = points[i].getPos_y()+size/2-1;
            }
            else {
                x = points[i].getPos_x() + size / 2;
                y = points[i].getPos_y() + size / 2;
            }
            img.setRGB(x, y, p);
        }
        //write image
        try{
            file = new File("C:\\Users\\Radeko\\IdeaProjects\\Spirala\\Images\\"
                    +fileName+".png");
            ImageIO.write(img, "png", file);
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
    }

    public void MakeFile2(Point[] points, int size, String fileName) {

        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        File file = null;

        int a,r,g,b;
        int p;
        int x,y;

        //create image pixel by pixel
        for(int i = 0; i<size*size; i++){

            a = (int)(points[i].isTrue()*255); //alpha
            r = (int)(Math.random()*255); //red
            g = (int)(Math.random()*255); //green
            b = (int)(Math.random()*255); //blue


            p = (a<<24) | (r<<16) | (g<<8) | b; //pixel

            if(size%2 == 0) {
                x = points[i].getPos_x()+size/2-1;
                y = points[i].getPos_y()+size/2-1;
            }
            else {
                x = points[i].getPos_x() + size / 2;
                y = points[i].getPos_y() + size / 2;
            }
            img.setRGB(x, y, p);
        }
        //write image
        try{
            file = new File("C:\\Users\\Radeko\\IdeaProjects\\Spirala\\Images\\"
                    +fileName+"-COLOR.png");
            ImageIO.write(img, "png", file);
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
}
