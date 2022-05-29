package com.example.perpusonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RequestDetailActivity extends AppCompatActivity {

    ImageView reqCover;
    TextView reqTitle, reqAuthor, reqSynopsis, reqRequester, reqReceiver;
    Button reqButton;

    String dataReqTitle, dataReqAuthor, dataReqSynopsis, dataRequester, dataReceiver;
    int dataReqImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);

        reqCover = findViewById(R.id.request_Cover);
        reqTitle = findViewById(R.id.request_Title);
        reqAuthor = findViewById(R.id.request_TAuthor);
        reqSynopsis = findViewById(R.id.request_TSynopsis);
        reqRequester = findViewById(R.id.request_Requester);
        reqReceiver = findViewById(R.id.request_Receiver);
        reqButton = findViewById(R.id.requestButton);

        receiveData();
        setsData();

        if(dataRequester.equals(dataReceiver)){
            reqButton.setEnabled(false);
        }

        else{
            reqButton.setOnClickListener(view -> {
                Intent i = new Intent(RequestDetailActivity.this, ViewRequestActivity.class);
                startActivity(i);
            });
        }

    }

    private void receiveData(){
        if(getIntent().hasExtra("DataReqTitle") && getIntent().hasExtra("DataReqAuthor") &&
        getIntent().hasExtra("DataReqSynopsis") && getIntent().hasExtra("DataReqCover")
                && getIntent().hasExtra("DataRequester") && getIntent().hasExtra("DataReceiver")){

            dataReqTitle= getIntent().getStringExtra("DataReqTitle");
            dataReqAuthor = getIntent().getStringExtra("DataReqAuthor");
            dataReqSynopsis= getIntent().getStringExtra("DataReqSynopsis");
            dataRequester= getIntent().getStringExtra("DataRequester");
            dataReceiver = getIntent().getStringExtra("DataReceiver");
            dataReqImage = getIntent().getIntExtra("DataReqCover", 1);

        }
        else{
            Toast.makeText(this, "No data yet.", Toast.LENGTH_SHORT).show();
        }
    }

    private  void setsData(){
        reqTitle.setText(dataReqTitle);
        reqAuthor.setText(dataReqAuthor);
        reqSynopsis.setText(dataReqSynopsis);
        reqRequester.setText(dataRequester);
        reqReceiver.setText(dataReceiver);
        reqCover.setImageResource(dataReqImage);
    }

}