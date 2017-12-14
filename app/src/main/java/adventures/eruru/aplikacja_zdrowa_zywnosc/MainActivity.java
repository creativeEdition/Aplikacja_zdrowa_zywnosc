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

    private static final String TAG = "MainActivity";
    ArrayList<FoodEntry> baza;

    private EditText field_name;
    private EditText field_protein;
    private EditText field_fat;
    private EditText field_sugar;

    String text_protein;
    String text_fat;
    String text_sugar;

    static Boolean decision;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baza = new ArrayList<>();

        //wysokokaloryczne
        // baza.add(new FoodEntry(new Double[]{}, false));
        baza.add(new FoodEntry(new Double[]{25.8, 17.9, 0.7}, false));
        baza.add(new FoodEntry(new Double[]{18.0, 29.0, 1.6}, false));
        baza.add(new FoodEntry(new Double[]{12.0, 25.0, 2.0}, false));
        baza.add(new FoodEntry(new Double[]{12.7, 47.3, 3.8}, false));
        baza.add(new FoodEntry(new Double[]{23.8, 60.2, 2.5}, false));
        baza.add(new FoodEntry(new Double[]{8.6, 75.1, 9.0}, false));
        baza.add(new FoodEntry(new Double[]{11.0, 44.0, 41.0}, false));
        baza.add(new FoodEntry(new Double[]{20.5, 53.5, 0.0}, false));
        baza.add(new FoodEntry(new Double[]{2.0, 30.0, 0.0}, false));
        baza.add(new FoodEntry(new Double[]{0.6, 82.5, 0.0}, false));
        baza.add(new FoodEntry(new Double[]{0.0, 99.0, 0.0}, false));
        baza.add(new FoodEntry(new Double[]{12.0, 0.0, 74.6}, false));
        baza.add(new FoodEntry(new Double[]{6.6, 0.0, 60.0}, false));
        baza.add(new FoodEntry(new Double[]{6.7, 0.0, 78.9}, false));
        baza.add(new FoodEntry(new Double[]{23.6, 20.2, 45.7}, false));
        baza.add(new FoodEntry(new Double[]{24.4, 43.8, 18.6}, false));
        baza.add(new FoodEntry(new Double[]{6.0, 40.0, 51.0}, false));
        baza.add(new FoodEntry(new Double[]{5.6, 63.2, 5.9}, false));
        baza.add(new FoodEntry(new Double[]{9.8, 0.0, 72.8}, false));
        baza.add(new FoodEntry(new Double[]{0.0, 0.0, 5.0}, false));

        //niskokaloryczne
        //baza.add(new FoodEntry(new Double[]{}, true));
        baza.add(new FoodEntry(new Double[]{16.8, 8.0, 0.5}, true));
        baza.add(new FoodEntry(new Double[]{11.4, 10.2, 0.9}, true));
        baza.add(new FoodEntry(new Double[]{10.0, 17.0, 1.6}, true));
        baza.add(new FoodEntry(new Double[]{1.9, 2.2, 1.1}, true));
        baza.add(new FoodEntry(new Double[]{0.6, 6.2, 0.1}, true));
        baza.add(new FoodEntry(new Double[]{0.3, 12.0, 40.0}, true));
        baza.add(new FoodEntry(new Double[]{29.6, 7.3, 0.2}, true));
        baza.add(new FoodEntry(new Double[]{16.5, 0.3, 0.0}, true));
        baza.add(new FoodEntry(new Double[]{21.2, 1.2, 0.0}, true));
        baza.add(new FoodEntry(new Double[]{8.8, 5.8, 0.0}, true));
        baza.add(new FoodEntry(new Double[]{12.7, 8.7, 0.0}, true));
        baza.add(new FoodEntry(new Double[]{2.6, 0.0, 3.5}, true));
        baza.add(new FoodEntry(new Double[]{1.3, 0.0, 2.7}, true));
        baza.add(new FoodEntry(new Double[]{0.7, 0.0, 1.9}, true));
        baza.add(new FoodEntry(new Double[]{1.1, 0.0, 3.4}, true));
        baza.add(new FoodEntry(new Double[]{0.8, 0.0, 4.8}, true));
        baza.add(new FoodEntry(new Double[]{0.7, 0.0, 5.4}, true));
        baza.add(new FoodEntry(new Double[]{1.2, 0.0, 6.1}, true));
        baza.add(new FoodEntry(new Double[]{0.9, 0.0, 5.6}, true));
        baza.add(new FoodEntry(new Double[]{1.1, 0.0, 19.2}, true));


        field_name = (EditText) findViewById(R.id.editText1);
        field_protein = (EditText) findViewById(R.id.editText2);
        field_fat = (EditText) findViewById(R.id.editText3);
        field_sugar = (EditText) findViewById(R.id.editText4);

        field_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String text_name = field_name.getText().toString();
                ;
                Log.d(TAG, "nazwa: " + text_name);
            }
        });

        field_protein.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                text_protein = field_protein.getText().toString();
                ;
                Log.d(TAG, "bialka: " + text_protein);
            }
        });

        field_fat.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                text_fat = field_fat.getText().toString();
                ;
                Log.d(TAG, "tluszcze: " + text_fat);
            }
        });

        field_sugar.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                text_sugar = field_sugar.getText().toString();
                ;
                Log.d(TAG, "weglowodany: " + text_sugar);
            }
        });

        //wywolanie metody konfigurująca buttona
        configureEnterButton();

    }

    // TA METODA UMOZLIWIA OTWARCIE DRUGIEGO OKIENKA, pobiera dane z editText
    public void configureEnterButton() {

        Button enterButton = (Button) findViewById(R.id.enterButton);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //poniższa linijka jest potrzebna aby ostatni editText, zgubił dotknięcie, bo tylko wtedy wynik bedzie zapisany w zmiennej gdy nie bedzie juz edycji pola
                v.requestFocusFromTouch();
                startActivity(new Intent(MainActivity.this, AnswerActivity.class));
                double a = Double.parseDouble(text_protein);
                double b = Double.parseDouble(text_fat);
                double c = Double.parseDouble(text_sugar);

                Knn checkFood = new Knn(baza, 1);
                decision = checkFood.classify(new FoodEntry(new Double[]{a, b, c}, null));

                Log.d(TAG, "Classified as:  " + decision);
            }
        });
    }
}
