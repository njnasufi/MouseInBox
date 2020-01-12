import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*; 
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class MouseModel {
   private BufferedImage image;
   private BufferedImage imageLeft;
   private BufferedImage imageRight;
   private BufferedImage imageUp;
   private BufferedImage imageDown;
   private int xPos;
   private int yPos;
   public MouseModel() {
      try {
         imageLeft = ImageIO.read(new File("C:\\Users\\User\\OneDrive\\Desktop\\NJOMZA-UP\\mouseleft.png"));
         imageRight = ImageIO.read(new File("C:\\Users\\User\\OneDrive\\Desktop\\NJOMZA-UP\\mouseright.png"));
         imageUp = ImageIO.read(new File("C:\\Users\\User\\OneDrive\\Desktop\\NJOMZA-UP\\mouseup.png"));
         imageDown = ImageIO.read(new File("C:\\Users\\User\\OneDrive\\Desktop\\NJOMZA-UP\\mousedown.png"));
      }
      catch (IOException ex) {
         JOptionPane.showMessageDialog(null, "Error loading images");  
      }
      image = imageRight;
   }
   public BufferedImage getImage() {
      return image;
   }
   public BufferedImage getImageLeft() {
      return imageLeft;
   }
   public BufferedImage getImageRight() {
      return imageRight;
   }
   public BufferedImage getImageUp() {
      return imageUp;
   }
   public BufferedImage getImageDown() {
      return imageDown;
   }
   public void setCurrentImage(BufferedImage image) {
      this.image = image;
   }
   public void setXPos(int x) {
      xPos = x;
   }
   public void setYPos(int y) {
      yPos = y;
   }
   public int getXPos() {
      return xPos;
   }
   public int getYPos() {
      return yPos;
   }
}