package adventures.eruru.aplikacja_zdrowa_zywnosc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Eruru on 04.12.2017.
 */

public class Knn {

    private int k;
    private ArrayList<Boolean> classes;
    private ArrayList<FoodEntry> dataSet;
    /**
     * @param dataSet The set
     * @param k The number of neighbours to use
     */
    public Knn(ArrayList<FoodEntry> dataSet, int k){
        this.classes = new ArrayList<Boolean>();
        this.dataSet = dataSet;
        this.k = k;

        //Load different classes
        for(FoodEntry entry : dataSet){
            if(!classes.contains(entry.getEatable())) classes.add(entry.getEatable());
        }
    }

    /**
     * Computes Manhattan distance
     * @param a From
     * @param b To
     * @return Distance
     */
    public static double distance(FoodEntry a, FoodEntry b){
        double distance = 0.0;
        int length = a.getIngredients().length;
        for(int i = 0; i < length; i++){
            double t = a.getIngredients()[i]-b.getIngredients()[i];
            distance = distance+t*t;
        }
        return Math.sqrt(distance);
    }

    /*
    private static double convertDistance(double d){
        return 1.0/d;
    }
    */
    private FoodEntry[] getNearestNeighbourType(FoodEntry x){
        FoodEntry[] retur = new FoodEntry[this.k];
        double fjernest = Double.MIN_VALUE;
        int index = 0;
        for(FoodEntry tse : this.dataSet){
            double distance = distance(x,tse);
            if(retur[retur.length-1] == null){
                int j = 0;
                while(j < retur.length){
                    if(retur[j] == null){
                        retur[j] = tse; break;
                    }
                    j++;
                }
                if(distance > fjernest){
                    index = j;
                    fjernest = distance;
                }

            }
            else{
                if(distance < fjernest){retur[index] = tse;
                    double f = 0.0;
                    int ind = 0;
                    for(int j = 0; j < retur.length; j++){
                        double dt = distance(retur[j],x);
                        if(dt > f){
                            f = dt;
                            ind = j;
                        }
                    }
                    fjernest = f;
                    index = ind;
                }
            }
        }
        return retur;
    }

    /**
     *
     * @param e Entry to be classifies
     * @return The class of the most probable class
     */
    public Boolean classify(FoodEntry e){
        HashMap<Boolean,Double> classcount = new HashMap<>();
        FoodEntry[] de = this.getNearestNeighbourType(e);
        for(int i = 0; i < de.length; i++){
            double distance = Knn.distance(de[i], e);
            if(!classcount.containsKey(de[i].getEatable())){
                classcount.put(de[i].getEatable(), distance);
            }
            else{
                classcount.put(de[i].getEatable(),
                        classcount.get(de[i].getEatable())+distance);
            }
        }
//Find right choice
        Boolean o = null;
        double max = 0;
        for(Boolean ob : classcount.keySet()){
            if(classcount.get(ob) > max){
                max = classcount.get(ob);
                o = ob;}
        }
        return o;
    }

    /*public static void main(String[] args){

        ArrayList<FoodEntry> baza = new ArrayList<>();
        baza.add(new FoodEntry(new Double[]{0.7,0.2,0.1}, false));
        baza.add(new FoodEntry(new Double[]{0.8,0.4,0.2}, true));
        baza.add(new FoodEntry(new Double[]{0.6,0.3,0.3}, false));

        Knn nn = new Knn(baza,1); //3 neighbours
        System.out.println("Classified as: "+nn.classify(new FoodEntry(new Double[]{0.9,0.5,0.3},null)));
    }*/
}
