package software.ulpgc.imageviewer.app;

import software.ulpgc.imageviewer.architecture.io.FileImageLoader;
import software.ulpgc.imageviewer.architecture.model.Image;
import software.ulpgc.imageviewer.architecture.presenter.ImagePresenter;
import software.ulpgc.imageviewer.architecture.view.ImageDisplay;

import java.io.File;
import java.net.MalformedURLException;

public class Main {
    public static String root;

    public static void main(String[] args) throws MalformedURLException {
        root = "test_images";
        Image image = new FileImageLoader(new File(root)).load();
        SwingMainFrame mainFrame = new SwingMainFrame();
        ImageDisplay imageDisplay = mainFrame.getImageDisplay();
        new ImagePresenter(image, imageDisplay);
        mainFrame.setVisible(true);
    }
}
