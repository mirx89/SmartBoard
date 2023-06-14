import javax.swing.*;
import java.awt.*;

public class PanelStatus extends JPanel {
    private JLabel lblMouse;
    private JLabel lblColor;

    public PanelStatus(Model model) {

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(150, 155, 150));

        lblMouse = new JLabel("X: 0, Y:0");
        add(lblMouse);

        JLabel lblText = new JLabel("Color:");
        add(lblText);

        lblColor = new JLabel("Color");
        lblColor.setBackground(model.getColor());
        lblColor.setForeground(model.getColor());
        lblColor.setOpaque(true); // for background color change (makes label background invisible)
        add(lblColor);
    }

    public JLabel getLblMouse() {
        return lblMouse;
    }

    public JLabel getLblColor() {
        return lblColor;
    }
    
}
