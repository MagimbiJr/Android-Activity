package com.tana.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLAY = "com.tana.twoactivities.extra.REPLY";
    private EditText mReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReplay = (EditText) findViewById(R.id.editText_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void returnReplay(View view) {
        String replay = mReplay.getText().toString();

        Intent replayIntent = new Intent();
        replayIntent.putExtra(EXTRA_REPLAY, replay);
        setResult(RESULT_OK, replayIntent);
        finish();
    }
}