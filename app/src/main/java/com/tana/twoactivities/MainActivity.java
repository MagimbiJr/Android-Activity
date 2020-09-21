package com.tana.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.tana.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mReplayHeadTextView;
    private TextView mReplayTextView;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReplayHeadTextView = (TextView) findViewById(R.id.text_header_replay);
        mReplayTextView = (TextView) findViewById(R.id.text_message_replay);
        mMessageEditText = (EditText) findViewById(R.id.editText_main);

        Log.d(TAG, "onCreate: App is Created");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: App is Starting");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: App is pausing");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart: App is Restarting");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: App is resuming");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop: App is Stopping");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: App is Destroyed");
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String replay = data.getStringExtra(SecondActivity.EXTRA_REPLAY);
                mReplayHeadTextView.setVisibility(View.VISIBLE);
                mReplayTextView.setText(replay);
                mReplayTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}