package software.ulpgc.imageviewer.architecture.view;

import software.ulpgc.imageviewer.architecture.model.Image;

import java.awt.*;

public interface ImageDisplay {
    void show(Image image);
    Image image();
    void paint(Graphics g);
}
