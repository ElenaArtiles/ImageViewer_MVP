package software.ulpgc.imageviewer.architecture.model;

public interface Image {
    String name();
    Image next();
    Image prev();
}
