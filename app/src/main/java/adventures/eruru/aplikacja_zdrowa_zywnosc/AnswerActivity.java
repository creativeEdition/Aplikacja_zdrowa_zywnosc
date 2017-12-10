package adventures.eruru.aplikacja_zdrowa_zywnosc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnswerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        configureBackButton();
    }

    private void configureBackButton(){

        Button enterButton = (Button) findViewById(R.id.backButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }


    /*
    DZIEWCZYNY JA TO WIDZĘ TAK, ŻE TUTAJ W TEJ KLASIE BĘDZIE  IF, KTÓRY SPRAWDZI JAKA JEST DECYZJA KNN,
     I JEŚLI ODPOWIEDŹ BĘDZIE TRUE TO odpowiedź znacie, jeśli będzie folse odpowiedź też znacie :D

    albo CASE , czyli sprawdzimy przypadek decycji (czy true czy folse)
    to trzeba przerobić link do kodu tutaj:
    http://forum.android.com.pl/topic/237899-jak-wy%C5%9Bwietli%C4%87-string-w-textview-w-spos%C3%B3b-ci%C4%85g%C5%82y/

    CHODZI MI O SAMĄ IDEĘ DZIAŁANIA, możemy się tym posiłkować :) I ODPOWIEDNIO DO DECYZJI, W TextViev to wyświetlimy!


    new Handler() {
            @Override
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case RECEIVE_MESSAGE:
                        String strIncom = (String) msg.obj;
                        sb.append(strIncom);

                        int endOfLineIndex = sb.toString().indexOf("2014", 4);
                        if (endOfLineIndex >= 0) {

                            String wholeText = sb.toString();
                            String sbprint = wholeText.substring(0, endOfLineIndex);

                            textView.setText(sbprint);

                            sb.delete(0, sb.length());
                            sb.append(wholeText.substring(endOfLineIndex));
                        }

                        break;
                }
            }
        };


     */

}
