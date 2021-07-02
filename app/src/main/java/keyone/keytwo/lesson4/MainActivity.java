package keyone.keytwo.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    // создать коды, которые будут копировать наши элементы, константы наши
    // в нажатие кнопки ввели ее код
    private final int MY_COOL_STYLE_THEM = 0;
    private int MATERIAL_LIGHT_STYLE = 1;
    private int MATERIAL_LIGHT_DARK_ACTION_STYLE = 2;
    private int MATERIAL_DARK_STYLE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTheme(R.style.MyCoolStyle);// задаем тему, шрифт
        setTheme(convertCodeToStyle(getAppTheme())); //вернуть цифры
        convertCodeToStyle// конв3йертировать ратно в стили
        setContentView(R.layout.activity_main);


//        // Ресурсы
//
//        //получить в коде ресурс язык
//        String myString = getResources().getString(R.string.hello_text);
//        //обратились к ресурсам-просим вернуть строку-указываем стринг(или id
//
//
//        // подключить шрифт
//        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/19659.ttf");
//
//
//        // далее задаем элементу id и находим его по нему
//        TextView textView = findViewById(R.id.textView);
//        // далее применем к нему фон
//        textView.setTypeface(tf);
//
//
//        // можно програмно задать текст
//        textView.setText(myString);
//
//        //подгрузить изображение
//        Drawable draw = getAssets().open("android.png");
//// просим ресурс менеджера вернуть нам любой файл и он будет считываться как потом байтов
//        // можем работать с любыми изображениями
//        //менять текс, обрезать, и тд


                                // ПРИВЯЗАТЬ КНОПКИ ДЛЯ КЛИКА

      //  initChanger(); // создали инициализатор

    }

// его задача к нашим элементам привязать нажатия

    //1 спосб. Будет длиный код, тк много кнопок
//    private void initChanger() {
//        RadioButton button = findViewById(R.id.radioButtonMyCoolStyle);
//// есть некая радиобаттон, по фд находим кнопки
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //указать текущую тему
//                recreate();// попросить приложение перезагрузить активити
//            }
//        });
//        // теперь ей добавили обработчик нажатия


    // укротим метод, для этого вынесем в отдельный метод инициализация кнопки initButton



    private final String KEY_PREF_ = "key";
    private final String APP_THEME_ = "theme";


    private void initChanger() {
        initButton(findViewById(R.id.radioButtonMyCoolStyle), MY_COOL_STYLE_THEM);
        initButton(findViewById(R.id.radioButtonMaterialLight), MATERIA_LIGHT_STYLE);
        initButton(findViewById(R.id.radioButtonMaterialDarkAction), MATERIAL_LIGHT_DARK_ACTION_STYLE);
        initButton(findViewById(R.id.radioButtonMaterialDark), MATERIAL_DARK_STYLE);

    }

    private void initButton(RadioButton button, int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);//указать кнопку текущую тему где передаем codeStyle
                recreate(); //перезагрузить
            }
        });
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREF_, MODE_PRIVATE);
        // получили доступ к слхраненным настройкам по ключу,
        SharedPreferences.Editor editor = sharedPreferences.edit();  //запустили сессию записи в шаредпреферент
        editor.putInt(APP_THEME_, codeStyle); // по ключу записываем наше значение код стайл
        editor.apply();// сохранили

//        //проверка
//        codeStyle = 9999;
//        Log.d("mylogs",sharedPreferences.getInt(APP_THEME_, codeStyle)+"");
//        //вывели
    }

    // теперь нужно вернуть тему. преобразовать наш код стайл в значение темы
    private int getAppTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_PREF_, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME_, MY_COOL_STYLE_THEM);

    }

    private int convertCodeToStyle(int codeStyle) {
        switch (codeStyle) {
            case MY_COOL_STYLE_THEM:
                return R.style.MyCoolStyle;
            case MATERIAL_LIGHT_STYLE:
                return R.style.AppTheme;
            case MATERIAL_LIGHT_DARK_ACTION_STYLE:
                return R.style.AppThemeLight;
            default:
                return R.style.AppThemeDark;

                // мы нашему коду написали шифр
        }
    }


}

