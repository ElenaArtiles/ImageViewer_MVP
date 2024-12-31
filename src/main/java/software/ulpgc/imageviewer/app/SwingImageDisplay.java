package software.ulpgc.imageviewer.app;

import software.ulpgc.imageviewer.architecture.model.Image;
import software.ulpgc.imageviewer.architecture.view.ImageDisplay;
import software.ulpgc.imageviewer.architecture.view.ImageResizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.min;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image image;
    private BufferedImage bitmap;


    @Override
    public void show(Image image) {
        this.image = image;
        this.bitmap = load(image.name());
        this.repaint();
    }

    @Override
    public Image image() {
        return image;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        ImageResizer resizer = new ImageResizer(bitmap);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        BufferedImage resized = resizer.resize(scaleFactor());
        int x = (this.getWidth() - resized.getWidth()) / 2;
        int y = (this.getHeight() - resized.getHeight()) / 2;
        g.drawImage(resized, x, y, null);
    }

    private BufferedImage load(String name) {
        try {
            return ImageIO.read(new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private double scaleFactor() {
        double widthFactor = (double) this.getWidth() / bitmap.getWidth();
        double heightFactor = (double) (this.getHeight() - 50) / bitmap.getHeight();
        return min(widthFactor, heightFactor);
    }
}
