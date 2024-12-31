package software.ulpgc.imageviewer.architecture.view;

import software.ulpgc.imageviewer.architecture.model.Image;

import java.awt.*;

public interface ImageDisplay {
    int width();
    void clear();
    void paint(String image, int offset);

    void on(Dragged dragged);
    void on(Released released);

    interface Dragged {
        Dragged Null = offset -> {};
        void to(int offset);
    }

    interface Released {
        Released Null = offset -> {};
        void at(int offset);
    }
}
