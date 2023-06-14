import java.awt.*;

public class Model {
    private Color color = new Color(255,255,255); // default line color
    private int width = 3; // default line width
    public Model() {

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
