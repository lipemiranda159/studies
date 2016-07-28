package com.example.felipem.course4;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button openGallery,btnCamera;
    Uri photoUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openGallery = (Button)findViewById(R.id.openGallery);
        btnCamera = (Button)findViewById(R.id.btnCamera);
        openGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,12);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public  void onClick(View view){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File imageFile = new File(Environment.getExternalStorageDirectory(), "Camera");
                imageFile.mkdirs();
                Random random = new Random();
                int n = random.nextInt(100000);
                File image = new File(imageFile, "photo"+n+".jpg");
                photoUri = Uri.fromFile(image);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, 1234);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == 1234){
            if (resultCode == RESULT_OK) {
                String sourcePath = photoUri.getPath();
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Caminho camera");
                alert.setMessage(sourcePath);
                alert.setPositiveButton("OK",null);
                alert.show();

                Log.e("Path", sourcePath);
            }

        }
    }
}
