package software.ulpgc.imageviewer.architecture.view;

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
