package adventures.eruru.aplikacja_zdrowa_zywnosc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG= "MainActivity";
    ArrayList<FoodEntry> baza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baza = new ArrayList<>();
        baza.add(new FoodEntry(new Double[]{0.7,0.2,0.1}, false));
        baza.add(new FoodEntry(new Double[]{0.8,0.4,0.2}, true));
        baza.add(new FoodEntry(new Double[]{0.6,0.3,0.3}, false));

        Knn nn = new Knn(baza,1); //3 neighbours
        Log.d(TAG, "Classified as:  "+nn.classify(new FoodEntry(new Double[]{0.9,0.5,0.3},null)));


       /* for(int i=0; i<baza.size(); i++){

            Log.d(TAG, "onCreate: kalorie" +baza.get(i).getEatable().toString());
        }

        for (int i = 0; i < baza.size(); i++){
            Double[] result = baza.get(i).getIngredients();
            for (Double n : result) {
                Log.d(TAG, "onCreate name:" + n);
            }
        }
        */
    }

    // nasz kod

    public void onNextClick (View view){

        //działanie buttona

    }






}
