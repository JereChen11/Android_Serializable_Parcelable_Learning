package com.jere.android_serializable_parcelable_learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author jere
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String PUT_SERIALIZABLE_USER_KEY = "serializable_user";
    public static final String PUT_PARCELABLE_ARTICLE_KEY = "pacelable_article";
    public static final String GSON_TEST_USERS_MAP_STRING_KEY = "usersMapString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button putSerializableBtn = findViewById(R.id.put_serializable);
        Button putParcelableBtn = findViewById(R.id.put_parcelable);
        Button gsonTestBtn = findViewById(R.id.gson_test_btn);
        putSerializableBtn.setOnClickListener(this);
        putParcelableBtn.setOnClickListener(this);
        gsonTestBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.put_serializable:
                User user = new User();
                user.setName("JereChen");
                user.setAge("22");
                user.setHobby("playing basketball");

                Bundle bundle = new Bundle();
                bundle.putSerializable(PUT_SERIALIZABLE_USER_KEY, user);

                Intent serializableIntent = new Intent(MainActivity.this, SecondActivity.class);
                serializableIntent.putExtras(bundle);

                startActivity(serializableIntent);
                break;
            case R.id.put_parcelable:
                Article article = new Article();
                article.setTitle("Android 学习笔记");
                article.setAuthor("JereChen");
                article.setUrl("https://blog.csdn.net/jerechen");

                Bundle parcelableBundle = new Bundle();
                parcelableBundle.putParcelable(PUT_PARCELABLE_ARTICLE_KEY, article);

                Intent parcelableIntent = new Intent(MainActivity.this, ThirdActivity.class);
                parcelableIntent.putExtras(parcelableBundle);

                startActivity(parcelableIntent);
                break;
            case R.id.gson_test_btn:
                User kobe = new User();
                kobe.setName("Kobe Bryant");
                kobe.setAge("40");
                kobe.setHobby("playing basketball!");

                User james = new User();
                james.setName("LeBron James");
                james.setAge("37");
                james.setHobby("playing basketball!");

                HashMap<Integer, User> usersMap = new HashMap<>();
                usersMap.put(1, kobe);
                usersMap.put(2, james);

                //序列化 HashMap to String
                Gson gson = new Gson();
                String userString = gson.toJson(usersMap);

                Intent intent = new Intent(MainActivity.this, GsonTestActivity.class);
                intent.putExtra(GSON_TEST_USERS_MAP_STRING_KEY, userString);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
