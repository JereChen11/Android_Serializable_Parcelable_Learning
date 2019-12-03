package com.jere.android_serializable_parcelable_learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author jere
 */
public class GsonTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_test_activity);

        Intent intent = getIntent();
        String usersMapString = intent.getStringExtra(MainActivity.GSON_TEST_USERS_MAP_STRING_KEY);

        //反序列化 usersMapString to HashMap<Integer, User>
        HashMap<Integer, User> usersMap = new HashMap<>();
        Gson gson = new Gson();
        Type usersMapType = new TypeToken<HashMap<Integer, User>>(){}.getType();
        usersMap = gson.fromJson(usersMapString, usersMapType);

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Integer, User> entry: usersMap.entrySet()) {
            sb.append("id: ").append(entry.getKey()).append("\n");
            User user = entry.getValue();
            sb.append("name: ").append(user.getName()).append("\n");
            sb.append("age: ").append(user.getAge()).append("\n");
            sb.append("hobby: ").append(user.getHobby()).append("\n").append("\n");
        }

        TextView usersMapTv = findViewById(R.id.test_tv);
        usersMapTv.setText(sb.toString());
    }
}
