package com.example.lab8_idnp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    public static final String KEY_NAME = "MENU";
    TextView txtResult;

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        Intent intent = result.getData();
                        txtResult.setText("Registro completo");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtResult = findViewById(R.id.textResult);
        Button btnNuevo = (Button) findViewById(R.id.btnNuevo);
        Button btnInfo = (Button) findViewById(R.id.btnInfo);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText(" ");
                Intent intentA = new Intent(getApplicationContext(), PostulanteRegistroActivity.class);
                startActivity(intentA);
            }
        });

        btnInfo.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText(" ");
                Intent intentB = new Intent(getApplicationContext(), PostulanteInfoActivity.class);
                startActivity(intentB);
            }
        }));

    }
}