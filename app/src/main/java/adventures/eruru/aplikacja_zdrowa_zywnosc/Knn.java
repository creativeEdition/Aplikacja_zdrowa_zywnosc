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

    // dataSet - lista produktow
    // k - liczba sasiadow, w algorytmie przyjeto 1

    public Knn(ArrayList<FoodEntry> dataSet, int k) {
        this.classes = new ArrayList<Boolean>();
        this.dataSet = dataSet;
        this.k = k;

        //wczytanie klas decyzyjnych
        for (FoodEntry entry : dataSet) {
            if (!classes.contains(entry.getEatable())) classes.add(entry.getEatable());
        }
    }

    // metryka miejska
    // element istniejacej wewnetrznej bazy
    // element wpisany przez uzytkownika aplikacji
    // metoda zwraca odleglosc do najblizszego sasiada

    public static double distance(FoodEntry a, FoodEntry b) {
        double distance = 0.0;
        int length = a.getIngredients().length;
        for (int i = 0; i < length; i++) {
            double t = a.getIngredients()[i] - b.getIngredients()[i];
            distance = distance + t;
        }
        return Math.abs(distance);
    }

    private FoodEntry[] getNearestNeighbourType(FoodEntry element) {
        FoodEntry[] retur = new FoodEntry[this.k];
        double fjernest = Double.MIN_VALUE;
        int index = 0;
        for (FoodEntry tse : this.dataSet) {
            double distance = distance(element, tse);
            if (retur[retur.length - 1] == null) {
                int j = 0;
                while (j < retur.length) {
                    if (retur[j] == null) {
                        retur[j] = tse;
                        break;
                    }
                    j++;
                }
                if (distance > fjernest) {
                    index = j;
                    fjernest = distance;
                }

            } else {
                if (distance < fjernest) {
                    retur[index] = tse;
                    double f = 0.0;
                    int ind = 0;
                    for (int j = 0; j < retur.length; j++) {
                        double dt = distance(retur[j], element);
                        if (dt > f) {
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


     // e element, ktory ma zostac sklasyfikowany
     // zwraca klase najblizszego sasiada

    public Boolean classify(FoodEntry e) {
        HashMap<Boolean, Double> classcount = new HashMap<>();
        FoodEntry[] de = this.getNearestNeighbourType(e);
        for (int i = 0; i < de.length; i++) {
            double distance = Knn.distance(de[i], e);
            if (!classcount.containsKey(de[i].getEatable())) {
                classcount.put(de[i].getEatable(), distance);
            } else {
                classcount.put(de[i].getEatable(),
                        classcount.get(de[i].getEatable()) + distance);
            }
        }
        //szukanie odpowiedniej decyzji
        Boolean o = null;
        double max = 0;
        for (Boolean ob : classcount.keySet()) {
            if (classcount.get(ob) >= max) {
                max = classcount.get(ob);
                o = ob;
            }
        }
        return o;
    }
}
