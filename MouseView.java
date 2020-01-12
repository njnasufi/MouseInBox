import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*; 
import java.io.IOException;
import javax.swing.*;
public class MouseView extends JPanel {
   private JFrame frame;
   private BufferedImage image;
   private BufferedImage imageLeft;
   private BufferedImage imageRight;
   private BufferedImage imageUp;
   private BufferedImage imageDown;
   private int xPos;
   private int yPos;
   String c;
   public MouseView(BufferedImage image) {
      frame = new JFrame();
      frame.setTitle("Mouse in a box");
      frame.setVisible(true);
      frame.setSize(515,535);
      frame.setResizable(false);
      frame.getContentPane().add(this);
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      this.image = image;
   }
   public void addClosingListener(WindowListener wl) {
      frame.addWindowListener(wl);
   }
   public int getClosingAnswer() {
      int answer = JOptionPane.showConfirmDialog(frame, 
                  "Are you sure you want to stop playing?", "Close Window?", 
                  JOptionPane.YES_NO_OPTION,
                  JOptionPane.QUESTION_MESSAGE);
      return answer;
   }
   public void setImageLeft(BufferedImage image) {
      imageLeft = image;
   }
   public void setImageRight(BufferedImage image) {
      imageRight = image;
   }
   public void setImageUp(BufferedImage image) {
      imageUp = image;
   }
   public void setImageDown(BufferedImage image) {
      imageDown = image;
   }
   public BufferedImage getImage() {
      return image;
   }
   public void setXPos(int x) {
      xPos = x;
   }
   public int getXPos() {
      return xPos;
   }
   public void setYPos(int y) {
      yPos = y;
   }
   public int getYPos() {
      return yPos;
   }
   public void getCommand() {
      c = JOptionPane.showInputDialog(null, "Give a command for the mouse ( F - forward, L - left, R - right )");
      this.repaint();
      try {
         switch(c) {
            case "L": {
               if(image == imageLeft) {
                  image = imageDown;
                  getCommand();
                  break;
               }
               else if(image == imageRight) {
                  image = imageUp;
                  getCommand();
                  break;
               }
               else if(image == imageDown) {
                  image = imageRight;
                  getCommand();
                  break;
               } 
               else if(image == imageUp) {
                  image = imageLeft;
                  getCommand();
                  break;
               }
            }
            case "R": {
               if(image == imageLeft) {
                  image = imageUp;
                  getCommand();
                  break;
               }
               else if(image == imageRight) {
                  image = imageDown;
                  getCommand();
                  break;
               }
               else if(image == imageDown) {
                  image = imageLeft;
                  getCommand();
                  break;
               } 
               else if (image == imageUp) {
                  image = imageRight;
                  getCommand();
                  break;
               }
            }
            case "F": { 
                  if(image == imageRight) {
                     if(xPos < 395) {
                        xPos += 54;
                     }
                     else {
                        JOptionPane.showMessageDialog(null, "Ooopsssssss, ku po don");
                     }
                     getCommand();
                     break;
                  }
                  else if (image == imageLeft) {
                     if(xPos > 70) {
                        xPos -= 54;
                     }
                     else {
                        JOptionPane.showMessageDialog(null, "Ooopsssssss, ku po don");
                     }
                     getCommand();
                     break;
                  }
                  else if(image == imageUp) {
                     if(yPos > 70) {
                        yPos -= 54;
                     }
                     else {
                        JOptionPane.showMessageDialog(null, "Ooopsssssss, ku po don");
                     }
                     getCommand();
                     break;
                  }
                  else if(image == imageDown) {
                     if(yPos < 395) {
                        yPos += 54;
                     }
                     else {
                        JOptionPane.showMessageDialog(null, "Ooopsssssss, ku po don");
                     }
                     getCommand();
                     break;
                  }
               }
               default: {
                  JOptionPane.showMessageDialog(null, "You must enter a correct command, try again.");
                  getCommand();
               }
            }
         }
         catch(NullPointerException e) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
         }
   }
   public void repaintMethod() {
      this.repaint();
   }
   public void paintComponent(Graphics g) {
      g.setColor(Color.decode("#00ffff"));
      g.fillRect(0,0,500,500);
      g.setColor(Color.decode("#000"));
      g.drawRect(20, 20, 460, 460);
      g.drawImage(image, xPos, yPos, this);
  
   }
}