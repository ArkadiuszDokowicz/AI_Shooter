package sample;

import java.util.List;

public class Shield {
    //center 250X 180Y
    //ellipses radius :
    // rad.5 rank 10
    //rad.20 rank 9
    //rad.40 rank 8
    //rad.60 rank 7
    //rad.90 rank 5
    //rad.120 rank 3
    //rad.150 rank 2
    //rad.170 rank 1
   private Double layoutX=250.d;
   private Double layoutY=180.d;
   private int rad1=5;   //10
   private int rad2=20;  //9
   private int rad3=40;  //8
   private int rad4=60;  //7
   private int rad5=90;  //5
   private int rad6=120; //3
   private int rad7=150; //2
   private int rad8=170; //1




   public void rateShots(List<Point> shots){
       for(Point point:shots){
           this.rateShot(point);
       }
   }

   private void rateShot(Point point){
       double pointLayoutX=point.getEllipse().getLayoutX();
       double pointLayoutY=point.getEllipse().getLayoutY();

       if(between(pointLayoutX,layoutX-rad1,layoutX+rad1)){
           if(between(pointLayoutY,layoutY-rad1,layoutY+rad1)){
               point.setValue(10);
           }
       }
       else if(between(pointLayoutX,layoutX-rad2,layoutX+rad2)){
           if(between(pointLayoutY,layoutY-rad2,layoutY+rad2)){
               point.setValue(9);
           }

       }
       else if(between(pointLayoutX,layoutX-rad3,layoutX+rad3)){
           if(between(pointLayoutY,layoutY-rad3,layoutY+rad3)){
               point.setValue(8);
           }

       }
       else if(between(pointLayoutX,layoutX-rad4,layoutX+rad4)){
           if(between(pointLayoutY,layoutY-rad4,layoutY+rad4)){
               point.setValue(7);
           }

       }
       else if(between(pointLayoutX,layoutX-rad5,layoutX+rad5)){
           if(between(pointLayoutY,layoutY-rad5,layoutY+rad5)){
               point.setValue(5);
           }

       }
       else if(between(pointLayoutX,layoutX-rad6,layoutX+rad6)){
           if(between(pointLayoutY,layoutY-rad6,layoutY+rad6)){
               point.setValue(3);
           }

       }
       else if(between(pointLayoutX,layoutX-rad7,layoutX+rad7)){

               point.setValue(2);

       }
       else if(between(pointLayoutX,layoutX-rad8,layoutX+rad8)){
           if(between(pointLayoutY,layoutY-rad8,layoutY+rad8)){
               point.setValue(1);
           }

       }

   }
   private boolean between(double i, double minValueInclusive, double maxValueInclusive) {
        if (i >= minValueInclusive && i <= maxValueInclusive) {
            return true;
        }
        else
            return false;
    }

}
