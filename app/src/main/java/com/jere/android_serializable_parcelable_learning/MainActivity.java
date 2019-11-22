package com.jere.android_serializable_parcelable_learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author jere
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String PUT_SERIALIZABLE_USER_KEY = "serializable_user";
    public static final String PUT_PARCELABLE_ARTICLE_KEY = "pacelable_article";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button putSerializableBtn = findViewById(R.id.put_serializable);
        Button putParcelableBtn = findViewById(R.id.put_parcelable);
        putSerializableBtn.setOnClickListener(this);
        putParcelableBtn.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
