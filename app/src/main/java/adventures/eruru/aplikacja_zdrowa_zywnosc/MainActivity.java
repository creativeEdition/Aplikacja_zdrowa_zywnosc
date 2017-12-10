package adventures.eruru.aplikacja_zdrowa_zywnosc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        //metoda konfigurująca buttona
          configureEnterButton();


          //NIE DZIAŁAJĄCA ZMODYFIKOWANA METODA
       // configureEnterButton(savedInstanceState);
    }

    // STĄD CZERPAŁAM DWA KODY:
    // https://stackoverflow.com/questions/4531396/get-value-of-a-edit-text-field
    // https://www.youtube.com/watch?v=6RtF_mbHcEc




    // TA METODA UMOZLIWIA OTWARCIE DRUGIEGO OKIENKA, NIE POBIERA JESZCZE DANYCH Z editText


    private void configureEnterButton(){

        Button enterButton = (Button) findViewById(R.id.enterButton);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AnswerActivity.class));

            }
        });



    }


    /* NIE DZIAŁAJĄCA JESZCZE METODA POBIERAJĄCA DANE Z editText, dużo dużo do poprawki!!

    private void configureEnterButton(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterButton = (Button) findViewById(R.id.enterButton);

        final EditText  edit_text_nazwa   = (EditText)findViewById(R.id.editText1);
        final EditText edit_text_bialka   = (EditText)findViewById(R.id.editText2);
        final EditText edit_text_tluszcze   = (EditText)findViewById(R.id.editText3);
        final EditText edit_text_weglowodany   = (EditText)findViewById(R.id.editText4);


        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v("EditText value=", edit_text_nazwa.getText().toString());
                Log.v("EditText value=", edit_text_bialka.getText().toString());
                Log.v("EditText value=", edit_text_tluszcze.getText().toString());
                Log.v("EditText value=", edit_text_weglowodany.getText().toString());

                startActivity(new Intent(MainActivity.this, AnswerActivity.class));

            }
        });



    }

   */










}
