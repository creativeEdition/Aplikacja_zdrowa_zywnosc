package adventures.eruru.aplikacja_zdrowa_zywnosc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import static adventures.eruru.aplikacja_zdrowa_zywnosc.MainActivity.decision;

public class AnswerActivity extends AppCompatActivity {

    private EditText field_answer;

    private String answer_true = " Produkt niskokaloryczny! Możesz spożywać w większych ilościach! Pamiętaj dzienne zapotrzebowanie kaloryczne dla kobiet to 2 000 kcal, dla mężczyzn 2 500 kcal.";
    private String answer_false = " Produkt wysokokaloryczny! Jedz w mniejszych ilościach! Pamiętaj dzienne zapotrzebowanie kaloryczne dla kobiet to 2 000 kcal, dla mężczyzn 2 500 kcal.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        field_answer = (EditText) findViewById(R.id.answer_id);

        if (decision == true) {
            field_answer.setText(answer_true);
        } else
            field_answer.setText(answer_false);

        configureBackButton();
    }

    private void configureBackButton() {
        Button enterButton = (Button) findViewById(R.id.backButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
