package software.ulpgc.imageviewer.architecture.view;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageResizer {
    private final BufferedImage original;

    public ImageResizer(BufferedImage original) {
        this.original = original;
    }

    public BufferedImage resize(double factor) {
        if (factor < 1) {
            Image scaledInstance = original.getScaledInstance((int) (original.getWidth() * factor),
                    (int) (original.getHeight() * factor), Image.SCALE_SMOOTH);
            BufferedImage outputImage = new BufferedImage((int) (original.getWidth() * factor),
                    (int) (original.getHeight() * factor), BufferedImage.TYPE_INT_RGB);
            outputImage.getGraphics().drawImage(scaledInstance, 0, 0, null);
            return outputImage;
        } else {
            return original;
        }
    }
}
