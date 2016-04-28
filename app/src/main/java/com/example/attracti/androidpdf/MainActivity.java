package com.example.attracti.androidpdf;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.bPressMe);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                File pdfFile = new File(Environment
                                .getExternalStorageDirectory(), "test.pdf");
                try {
                    if (pdfFile.exists()) {
                        Uri path = Uri.fromFile(pdfFile);
                        Intent objIntent = new Intent(Intent.ACTION_VIEW);
                        objIntent.setDataAndType(path, "application/pdf");
                        objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(objIntent);
                    } else {
                        Toast.makeText(MainActivity.this, "File NotFound",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this,
                            "No Viewer Application Found", Toast.LENGTH_SHORT)
                            .show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
