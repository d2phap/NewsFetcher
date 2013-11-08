/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 *
 * @author Duong Dieu Phap
 */
public class ImagePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
    //image object
    private Image img;

    public ImagePanel(BufferedImage bimg) throws IOException {
        //load image
        img = bimg;
    }

    //override paint method of panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw the image
        if (img != null) {
            Image drawImage = img.getScaledInstance(-1, this.getHeight() - 4, BufferedImage.SCALE_DEFAULT);
            int xPos = (getWidth() / 2) - (drawImage.getWidth(null) / 2);
            g.drawImage(drawImage, xPos, 2, null);

        }
    }
}
