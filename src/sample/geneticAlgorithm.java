package sample;

import java.util.*;

public class geneticAlgorithm {
    private int tolerance;//the amount of survivors from the last generation
    private double mutation; //mutation coefficient
    private List<Point> previousGeneration; //previous generation
    private List<Point> nextGeneration; //next generation
    private List<Point> parents =new ArrayList<>(20);
    public geneticAlgorithm(int tolerance, int mutation) {
        this.tolerance = tolerance;
        this.mutation = mutation;

    }



    public int getTolerance() {
        return tolerance;
    }

    public void setTolerance(int tolerance) {
        this.tolerance = tolerance;
    }

    public double getMutation() {
        return mutation;
    }

    public void setMutation(int mutation) {
        this.mutation = mutation;
    }

    public List<Point> getPreviousGeneration() {
        return previousGeneration;
    }

    public void setPreviousGeneration(List<Point> previousGeneration) {
        this.previousGeneration = previousGeneration;
    }

    public List<Point> getNextGeneration() {
        return nextGeneration;
    }

    public void setNextGeneration(List<Point> nextGeneration) {
        this.nextGeneration = nextGeneration;
    }

    public void Selection(List<Point> shoots) {
        Collections.sort(shoots);
    }

    protected void setParents(List<Point>shoots){


            for(int i=0;i<this.tolerance;i++) {
                Point p = shoots.get(i);
                this.parents.add(p);
            }
    }


    private List<Double> getRandomGenotype(){
        Random random = new Random();
        int min=0;
        int max=tolerance-1;
        int randomParentIndex1  =random.nextInt(max - min + 1) + min;
        int randomParentIndex2  =random.nextInt(max - min + 1) + min;
        System.out.println(tolerance);
        double parentGenotypeX,parentGenotypeY;
        parentGenotypeX=this.parents.get(randomParentIndex1).getEllipse().getLayoutX();
        parentGenotypeY=this.parents.get(randomParentIndex2).getEllipse().getLayoutY();
     List<Double> toReturn= new ArrayList<>();
     toReturn.add(parentGenotypeX);
     toReturn.add(parentGenotypeY);
        return toReturn;
    }

    protected void crossover(List<Point>shoots){

        for(int i=this.tolerance;i<shoots.size();i++){
            Point p=shoots.get(i);
            List<Double> genotypes=this.getRandomGenotype();
            p.getEllipse().setLayoutX(genotypes.get(0));
            p.getEllipse().setLayoutY(genotypes.get(1));
        }
    }

    protected void mutation(List<Point>shoots){
        Random random = new Random();
        int min=0;
        int max=1;
        double x = 0,y=0,mutX=0,mutY=0;
        for(Point p: shoots){
            if((random.nextInt(max - min + 1) + min)==1) {
                x = p.getEllipse().getLayoutX();
                y = p.getEllipse().getLayoutY();
                if ((random.nextInt(max - min + 1) + min) == 1) {
                    mutX = x * ((this.mutation + 100) / 100);
                    mutY = y * ((this.mutation + 100) / 100);
                } else {
                    mutX = x * ((100 - this.mutation) / 100);
                    mutY = y * ((100 - this.mutation) / 100);

                }
            p.getEllipse().setLayoutX(mutX);
            p.getEllipse().setLayoutY(mutY);
            }
        }

    }
}
