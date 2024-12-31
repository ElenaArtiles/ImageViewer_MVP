package software.ulpgc.imageviewer.app;

import software.ulpgc.imageviewer.architecture.control.NextImageCommand;
import software.ulpgc.imageviewer.architecture.control.PreviousImageCommand;
import software.ulpgc.imageviewer.architecture.io.FileImageLoader;
import software.ulpgc.imageviewer.architecture.model.Image;

import java.io.File;
import java.net.MalformedURLException;

public class Main {
    public static String root;

    public static void main(String[] args) throws MalformedURLException {
        root = "test_images";
        Image image = new FileImageLoader(new File(root)).load();
        SwingMainFrame mainFrame = new SwingMainFrame();
        mainFrame.getImageDisplay().show(image);
        mainFrame.add("Prev", new PreviousImageCommand(mainFrame.getImageDisplay()));
        mainFrame.add("Next", new NextImageCommand(mainFrame.getImageDisplay()));
        mainFrame.setVisible(true);
    }
}
