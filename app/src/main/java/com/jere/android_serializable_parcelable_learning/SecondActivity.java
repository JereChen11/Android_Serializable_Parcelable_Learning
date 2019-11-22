package com.jere.android_serializable_parcelable_learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author jere
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView nameTv = findViewById(R.id.name_tv);
        TextView ageTv = findViewById(R.id.age_tv);
        TextView hobbyTv = findViewById(R.id.hobby_tv);

        Intent serializableIntent = getIntent();
        Bundle serializableBundle = serializableIntent.getExtras();
        User user = null;
        if (serializableBundle != null) {
            user = (User) serializableBundle.getSerializable(MainActivity.PUT_SERIALIZABLE_USER_KEY);
        }
        if (user != null) {
            nameTv.setText(user.getName());
            ageTv.setText(user.getAge());
            hobbyTv.setText(user.getHobby());
        }
    }
}
