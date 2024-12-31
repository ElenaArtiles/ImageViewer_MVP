package software.ulpgc.imageviewer.app;

import software.ulpgc.imageviewer.architecture.control.Command;
import software.ulpgc.imageviewer.architecture.view.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SwingMainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private final Map<String, Command> commands;

    public SwingMainFrame() throws MalformedURLException {
        URL url = new URL("https://cdn-icons-png.flaticon.com/512/8377/8377243.png");
        ImageIcon icon = new ImageIcon(url);
        this.commands = new HashMap<>();
        this.setTitle("Image Viewer MVC");
        this.setIconImage(icon.getImage());
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(createImageDisplay());
        this.add(createWestToolbar(), BorderLayout.WEST);
        this.add(createEastToolbar(), BorderLayout.EAST);
    }

    private Component createWestToolbar() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(createButton("Prev"));
        return panel;
    }

    private Component createEastToolbar() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(createButton("Next"));
        return panel;
    }

    private Component createButton(String label) {
        JButton button = new JButton(label);
        if (Objects.equals(label, "Prev")) {
            button.setText("<");
        } else {
            button.setText(">");
        }
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.addActionListener(e -> commands.get(label).execute());
        button.addKeyListener(createArrowKeyListener());
        return button;
    }

    private KeyListener createArrowKeyListener() {
        return new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    commands.get("Prev").execute();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    commands.get("Next").execute();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        };
    }

    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
