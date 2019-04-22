package sample;

import javafx.scene.shape.Ellipse;

public class Point {
    private String name;
    private Ellipse ellipse;
    private int value;

    public Point(String name, Ellipse ellipse, int value) {
        this.name = name;
        this.ellipse = ellipse;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
