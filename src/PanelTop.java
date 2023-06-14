import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelTop extends JPanel {
    private Model model;
    private View view;
    private PanelDraw panelDraw;
    private JSpinner spnWidth;
    private JButton btnSave;
    private BufferedImage image; // saved image

    public PanelTop(Model model, View view, PanelDraw panelDraw) {
        this.model = model;
        this.view = view;
        this.panelDraw = panelDraw;

        setLayout(new FlowLayout(FlowLayout.LEFT)); // Buttons to left side of the panel
        setBackground(new Color(185,200,245));


        setupButtonColor();
        setupLineWidth();
        setupButtonErase();
        setupButtonSave();
    }

    private void setupButtonSave() {
        btnSave = new JButton("Save");
        // "Local" version Save button
        /*btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image = new BufferedImage(panelDraw.getWidth(),panelDraw.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g = image.getGraphics();
                panelDraw.paintComponent(g);
                try {
                    ImageIO.write(image, "png", new File("java_drawing_local.png"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });*/
        add(btnSave);

    }

    private void setupButtonErase() {
        JButton btnErase = new JButton("Erase all");
        btnErase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDraw.getLines().clear(); // empty arraylist
                panelDraw.repaint(); // redraw
            }
        });
        add(btnErase);
    }

    private void setupLineWidth() {
        JLabel lblLineWidth = new JLabel("Line width:");
        add(lblLineWidth);
        SpinnerModel value = new SpinnerNumberModel(model.getWidth(), 1, 15, 1);
        spnWidth = new JSpinner(value);
        spnWidth.addChangeListener(e -> model.setWidth((Integer)spnWidth.getValue()));
        add(spnWidth);
    }

    private void setupButtonColor() {
        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose new color", model.getColor());
                if(newColor != null) {
                    model.setColor(newColor);
                }
                view.getLblColor().setBackground(model.getColor());
                view.getLblColor().setForeground(model.getColor());
            }
        });
        add(btnColor); // add to PanelTop (extends JPanel)
    }

    public JButton getBtnSave() {
        return btnSave;
    }
}
