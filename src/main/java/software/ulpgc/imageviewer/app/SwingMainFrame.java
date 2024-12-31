package software.ulpgc.imageviewer.app;

import software.ulpgc.imageviewer.architecture.view.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SwingMainFrame extends JFrame {
    private ImageDisplay imageDisplay;

    public SwingMainFrame() throws MalformedURLException {
        URL url = new URL("https://cdn-icons-png.flaticon.com/512/8377/8377243.png");
        ImageIcon icon = new ImageIcon(url);
        this.setTitle("Image Viewer MVP");
        this.setIconImage(icon.getImage());
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createImageDisplay());
    }

    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
