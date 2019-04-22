package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Controller   {



    @FXML
    private AnchorPane container;

    @FXML
    private TextArea info;

    private List<Point> shots = new ArrayList();

    private Shooter shooter;

    public void shootingButton(ActionEvent event){

        shooter.prepareToShooting();
        shooter.firstShootingRound();
        shooter.checkTheResults();
        shooter.readResults();
    }
    public void shootingButton2(ActionEvent event) {
        for( Point shot:shots) {
            EllipseService.hidePoint(shot.getEllipse());
        }
    }



    public void initialize() {
        for (int i = 1; i <= 10; i++) {
            Ellipse ellipse = new Ellipse();
            ellipse.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                      DecimalFormat df2 = new DecimalFormat("#.##");
                    Ellipse ellipse = (Ellipse) mouseEvent.getSource();
                    Point point=shooter.getPointById(ellipse.getId());
                    info.setText("x:"+df2.format(point.getEllipse().getLayoutX())+" y:"+df2.format(point.getEllipse().getLayoutY())+" mark:"+point.getValue());

                }
            });
            shots.add(new Point("shoot"+i,ellipse,0));
            ellipse.setId("shoot"+i);
            container.getChildren().add(ellipse);
        }
         shooter=new Shooter(shots);
    }
}
