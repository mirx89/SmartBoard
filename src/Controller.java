import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {
    private View view;
    public Controller(View view) {
        this.view = view;

        view.registerButtonSave(new SaveButton());
    }

    private class SaveButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BufferedImage image = new BufferedImage(view.getPanelDraw().getWidth(), view.getPanelDraw().getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            Graphics g = image.getGraphics();
            view.getPanelDraw().paintComponent(g);
            try {
                ImageIO.write(image, "png", new File("java_drawing_second.png"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
