package keyone.keytwo.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //получить в коде ресурс язык
        String myString = getResources().getString(R.string.hello_text);
        //обратились к ресурсам-просим вернуть строку-указываем стринг(или id
    }

}