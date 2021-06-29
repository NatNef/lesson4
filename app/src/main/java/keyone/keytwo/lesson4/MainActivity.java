package keyone.keytwo.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ресурсы

        //получить в коде ресурс язык
        String myString = getResources().getString(R.string.hello_text);
        //обратились к ресурсам-просим вернуть строку-указываем стринг(или id


        // подключить шрифт
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/19659.ttf");
        // далее задаем элементу id и находим его по нему
        TextView textView = findViewById(R.id.textView);
        // далее применем к нему фон
        textView.setTypeface(tf);


        // можно програмно задать текст
        textView.setText(myString);

        //подгрузить изображение
        Drawable draw = getAssets().open("android.png");
// просим ресурс менеджера вернуть нам любой файл и он будет считываться как потом байтов
        // можем работать с любыми изображениями
        //менять текс, обрезать, и тд


        // Стили

        


    }

}