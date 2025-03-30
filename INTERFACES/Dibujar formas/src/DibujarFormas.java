import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class DibujarFormas {
  public static void main(String[] argv) throws Exception {
    int width = 100;
    int height = 100;

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    Graphics2D g2d = bufferedImage.createGraphics();

    g2d.setColor(Color.white);
    g2d.fillRect(0, 0, width, height);
    g2d.setColor(Color.black);
    g2d.fillOval(0, 0, width, height);
    g2d.setColor(Color.BLUE);
    g2d.drawLine(0,height ,width,0);
    g2d.drawLine(0,0 ,width,height);
    g2d.setColor(Color.ORANGE);
    g2d.fillOval(width/2-25,height/2-25,50,50);
    
    g2d.dispose();
    RenderedImage rendImage = bufferedImage;

    File file = new File("newimage.png");
    ImageIO.write(rendImage, "png", file);

    file = new File("newimage.jpg");
    ImageIO.write(rendImage, "jpg", file);
  }
}