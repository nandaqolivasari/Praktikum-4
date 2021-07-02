package com.example.praktikum_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber, websiteUri, locationUri, textShare;
    Button buttonWebsite, buttonLocation, buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = findViewById(R.id.edtPhoneNumber);
        websiteUri = findViewById(R.id.edtWebsiteUri);
        locationUri = findViewById(R.id.edtLocationUri);
        textShare = findViewById(R.id.edtShareText);
        buttonWebsite = findViewById(R.id.btnWebsiteUri);
        buttonLocation = findViewById(R.id.btnLocationUri);
        buttonText = findViewById(R.id.btnShareText);

        buttonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(phoneNumber.length()==0 &&  websiteUri.getText().toString().equals("") && locationUri.getText().toString().equals("") && textShare.getText().toString().equals("")){
                Toast.makeText(getApplication(),"Kolom tidak boleh kosong",Toast.LENGTH_LONG).show();
            }
                else if (phoneNumber.length()==0){
                Toast.makeText(getApplication(),"Nomor telepon tidak boleh kososng", Toast.LENGTH_LONG).show();
            }
                else if (websiteUri.length()==0){
                Toast.makeText(getApplication(),"Web tidak boleh kosong",Toast.LENGTH_LONG).show();
            }
                else if (locationUri.length()==0){
                    Toast.makeText(getApplicationContext(),"Lokasi tidak boleh kosong", Toast.LENGTH_LONG).show();
            }
                else if (textShare.length()==0){
                    Toast.makeText(getApplicationContext(), "Text tidak boleh kosong", Toast.LENGTH_LONG).show();
            }

        }
        });
    }

    public void phoneNumber(View view) {
        Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber.getText().toString()));
        startActivity(dialPhone);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnWebsiteUri:
                Intent openWebsite = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(websiteUri.getText().toString()));
                startActivity(openWebsite);
                break;
            case R.id.btnLocationUri:
                Intent openLocation = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" +
                                locationUri.getText().toString()));
                startActivity(openLocation);
                break;
            case R.id.btnShareText:
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType("text/plan")
                        .setChooserTitle("Share this text with : ")
                        .setText(textShare.getText().toString())
                        .startChooser();
                break;


        }
    }

}