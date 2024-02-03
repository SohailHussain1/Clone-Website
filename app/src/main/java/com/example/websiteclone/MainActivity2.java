package com.example.websiteclone;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {

    private ImageButton btnStart;
    private EditText linkEditText;
    private ALodingDialog aLodingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnStart = findViewById(R.id.btnStart);
        linkEditText = findViewById(R.id.sourceText); // assuming the ID of your EditText is editText

        aLodingDialog = new ALodingDialog(this);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aLodingDialog.show();

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        aLodingDialog.cancel();
                        // Get the text from the EditText
                        String link = linkEditText.getText().toString();

                        // Start the second activity here with the link
                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                        intent.putExtra("LINK_EXTRA", link);
                        startActivity(intent);

                        // Finish the current activity if needed
                        finish();
                    }
                };
                handler.postDelayed(runnable, 8000); // 3000 milliseconds delay
            }
        });
    }
}
