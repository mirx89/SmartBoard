import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private PanelDraw panelDraw;
    private PanelTop panelTop;
    private PanelStatus panelStatus;

    public View(JFrame frame, Model model) {
        panelDraw = new PanelDraw(this, model);
        panelTop = new PanelTop(model, this, panelDraw);
        panelStatus = new PanelStatus(model);

        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelDraw, BorderLayout.CENTER);
        frame.add(panelStatus,BorderLayout.SOUTH);
    }
    public void registerButtonSave(ActionListener al) {
        panelTop.getBtnSave().addActionListener(al);
    }

    public PanelDraw getPanelDraw() {
        return panelDraw;
    }
    public JLabel getLblMouse() {
        return panelStatus.getLblMouse();
    }

    public JLabel getLblColor() {
        return panelStatus.getLblColor();
    }
}
