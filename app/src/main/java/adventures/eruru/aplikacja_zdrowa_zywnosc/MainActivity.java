package adventures.eruru.aplikacja_zdrowa_zywnosc;

import android.content.Intent;
import android.net.sip.SipSession;
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

    private EditText pole_nazwy;
    private EditText pole_bialka;
    private EditText pole_tluszcze;
    private EditText pole_weglowodany;

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


        pole_nazwy = (EditText)findViewById(R.id.editText1);
        pole_bialka = (EditText)findViewById(R.id.editText2);
        pole_tluszcze = (EditText)findViewById(R.id.editText3);
        pole_weglowodany = (EditText)findViewById(R.id.editText4);


        pole_nazwy.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String tekst_nazwy =pole_nazwy.getText().toString();;
                Log.d(TAG, "nazwa: " + tekst_nazwy);
            }
        });

        pole_bialka.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String tekst_bialka =pole_bialka.getText().toString();;
                Log.d(TAG, "bialka: " + tekst_bialka);
            }
        });

        pole_tluszcze.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String tekst_tluszcze =pole_tluszcze.getText().toString();;
                Log.d(TAG, "tluszcze: " + tekst_tluszcze);
            }
        });

        pole_weglowodany.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String tekst_weglowodany =pole_weglowodany.getText().toString();;
                Log.d(TAG, "weglowodany: " + tekst_weglowodany);
            }
        });

        //metoda konfigurująca buttona
          configureEnterButton();

    }

    // STĄD CZERPAŁAM DWA KODY:
    // https://stackoverflow.com/questions/4531396/get-value-of-a-edit-text-field
    // https://www.youtube.com/watch?v=6RtF_mbHcEc
    // https://stackoverflow.com/questions/13644510/make-edittext-lose-focus-on-clicking-a-button
    // https://androiddlaprogramistow.wordpress.com/2013/11/06/pole-tekstowe-czyli-edittext/




    // TA METODA UMOZLIWIA OTWARCIE DRUGIEGO OKIENKA, pobiera dane z editText

    private void configureEnterButton(){



        Button enterButton = (Button) findViewById(R.id.enterButton);



        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //poniższa linijka jest potrzebna aby ostatni editText, zgubił dotknięcie, bo tylko wtedy wynik bedzie zapisany w zmiennej gdy nie bedzie juz edycji pola
                v.requestFocusFromTouch();
                startActivity(new Intent(MainActivity.this, AnswerActivity.class));

            }
        });



    }

}
