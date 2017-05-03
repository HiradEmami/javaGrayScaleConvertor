
package grayscaleconvertor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.io.*;
import javax.swing.ImageIcon;




public class grayScale {
    private BufferedImage image;
    private int width;
    private int height;
    
    public grayScale(){
        try {
            
            
         JFileChooser chooser =new   JFileChooser();
         chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         chooser.showOpenDialog(null);

         
         File inputImage = chooser.getSelectedFile();
         this.image= ImageIO.read(inputImage);
         this.width= this.image.getWidth();
         this.height= this.image.getHeight();
         
         System.out.println(height+"+"+width);
         
         for(int i=0; i<height;i++){
             for(int k=0;k<width;k++){
             Color currentPixelColor = new Color(image.getRGB(k,i));
             int red= (int)(currentPixelColor.getRed()*0.299);    
             int green= (int)(currentPixelColor.getGreen()*0.587);
             int blue= (int)(currentPixelColor.getBlue()*0.114);
             
             Color newPixelColor =new Color(red+blue+green, red+blue+green, red+green+blue);
             image.setRGB(k,i, newPixelColor.getRGB());
             }
         }
         
         JPanel mainPanel =new JPanel();
         //mainPanel.setSize(width, height);
         
         javax.swing.JLabel imageLabel = new javax.swing.JLabel(new ImageIcon(image));
         
         
         mainPanel.add(imageLabel);
         
         JFrame mainFrame= new JFrame();
         mainFrame.setTitle("Result GrayScale");
         mainFrame.add(mainPanel);
         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.pack();
         mainFrame.setLocationRelativeTo(null);
         mainFrame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,  "Failed to apply Gray Scale due to:\n"+e);
        }
         
         
    
    }
    
}
