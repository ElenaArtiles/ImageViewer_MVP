package software.ulpgc.imageviewer.architecture.presenter;

import software.ulpgc.imageviewer.architecture.view.ImageDisplay;
import software.ulpgc.imageviewer.architecture.model.Image;

import static java.lang.Math.abs;

public class ImagePresenter {
    private Image image;
    private final ImageDisplay display;

    public ImagePresenter(Image image, ImageDisplay display) {
        this.image = image;
        this.display = display;
        this.display.on((ImageDisplay.Dragged) this::dragged);
        this.display.on((ImageDisplay.Released) this::released);
        this.display.clear();
        this.display.paint(image.name(), 0);
    }

    private void dragged(int offset) {
        display.clear();
        ImageSelector selector = new ImageSelector(image, display.width());
        display.paint(selector.stay(offset).name(), offset - (offset > display.width() ? display.width() : 0));
        display.paint(selector.pass(offset).name(), offset - sign(offset) * display.width() - (offset > display.width() ? display.width() : 0));
    }

    private void released(int offset) {
        ImageSelector selector = new ImageSelector(image, display.width());
        image = shouldPassImage(offset) ? selector.pass(offset) : image;
        display.clear();
        display.paint(image.name(), 0);
    }

    private boolean shouldPassImage(int offset) {
        return abs(offset) > display.width() / 2;
    }

    private int sign(int offset) {
        return offset < 0 ? -1 : 1;
    }
}
