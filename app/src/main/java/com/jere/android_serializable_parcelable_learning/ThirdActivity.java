package com.jere.android_serializable_parcelable_learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author jere
 */
public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView titleTv = findViewById(R.id.title_tv);
        TextView authorTv = findViewById(R.id.author_tv);
        TextView urlTv = findViewById(R.id.url_tv);

        Intent parcelableIntent = getIntent();
        Bundle parcelBundle = parcelableIntent.getExtras();
        Article article = null;
        if (parcelBundle != null) {
            article = parcelBundle.getParcelable(MainActivity.PUT_PARCELABLE_ARTICLE_KEY);
        }
        if (article != null) {
            titleTv.setText(article.getTitle());
            authorTv.setText(article.getAuthor());
            urlTv.setText(article.getUrl());
        }
    }
}
