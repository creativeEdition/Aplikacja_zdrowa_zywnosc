package adventures.eruru.aplikacja_zdrowa_zywnosc;

import java.util.ArrayList;
import java.util.HashMap;



public class Knn {

    private ArrayList<Boolean> classes;
    private ArrayList<FoodEntry> dataFood;
    private int k;

    // dataSet - lista produktow
    // k - liczba sasiadow, w algorytmie przyjeto 1

    public Knn(ArrayList<FoodEntry> dataFood, int k) {
        this.classes = new ArrayList<Boolean>();
        this.dataFood = dataFood;
        this.k = k;

        //wczytanie klas decyzyjnych
        for (FoodEntry entry : dataFood) {
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

    private FoodEntry[] findNeighbourType(FoodEntry element) {
        FoodEntry[] effect = new FoodEntry[this.k];
        double minValue = Double.MIN_VALUE; //najmniejsza, dodatnia, niezerowa wartości typu Double
        int index = 0;
        for (FoodEntry x : this.dataFood) {
            double pathway = distance(element, x);
            if (effect[effect.length - 1] == null) {
                int j = 0;
                while (j < effect.length) {
                    if (effect[j] == null) {
                        effect[j] = x;
                        break;
                    }
                    j++;
                }
                if (pathway > minValue) {
                    index = j;
                    minValue = pathway;
                }

            } else {
                if (pathway < minValue) {
                    effect[index] = x;
                    double f = 0.0;
                    int ind = 0;
                    for (int j = 0; j < effect.length; j++) {
                        double dt = distance(effect[j], element);
                        if (dt > f) {
                            f = dt;
                            ind = j;
                        }
                    }
                    minValue = f;
                    index = ind;
                }
            }
        }
        return effect;
    }

    // e element, ktory ma zostac sklasyfikowany
    // zwraca klase najblizszego sasiada

    public Boolean classify(FoodEntry entry) {
        HashMap<Boolean, Double> classdecision = new HashMap<>();
        FoodEntry[] tabEntry = this.findNeighbourType(entry);
        for (int i = 0; i < tabEntry.length; i++) {
            double distance = Knn.distance(tabEntry[i], entry);
            if (!classdecision.containsKey(tabEntry[i].getEatable())) {
                classdecision.put(tabEntry[i].getEatable(), distance);
            } else {
                classdecision.put(tabEntry[i].getEatable(),
                        classdecision.get(tabEntry[i].getEatable()) + distance);
            }
        }
        //szukanie odpowiedniej decyzji
        Boolean result = null;
        double max = 0;
        for (Boolean dec : classdecision.keySet()) {
            if (classdecision.get(dec) >= max) {
                max = classdecision.get(dec);
                result = dec;
            }
        }
        return result;
    }
}
