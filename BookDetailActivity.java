package com.example.perpusonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.perpusonline.Database.Book;
import com.example.perpusonline.Database.RequestedBook;

public class BookDetailActivity extends AppCompatActivity {

    ImageView bookImage;
    TextView bookTitle, bookAuthor, bookSynopsis;
    Button req_btn;

    String dataTitle, dataAuthor, dataSynopsis;
    int dataImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        bookImage = findViewById(R.id.detailCover);
        bookTitle = findViewById(R.id.detailTitle);
        bookAuthor = findViewById(R.id.detailAuthor);
        bookSynopsis = findViewById(R.id.detailSynopsis);
        req_btn = findViewById(R.id.requestButton);

        takeData();
        dataSet();

        req_btn.setOnClickListener(view -> {
            RequestedBook.bookReq_id.add(Book.book_title.indexOf(dataTitle));
            RequestedBook.bookReq_cover.add(dataImage);
            RequestedBook.bookReq_title.add(dataTitle);
            RequestedBook.bookReq_author.add(dataAuthor);
            RequestedBook.bookReq_synopsis.add(dataSynopsis);
            RequestedBook.requesterID.add(LoginActivity.currUser);
            RequestedBook.receiverID.add("No receiver yet");
            Intent i = new Intent(BookDetailActivity.this, HomeActivity.class);
            startActivity(i);
        });
    }

    private void takeData(){
        if (getIntent().hasExtra("DataCover") && getIntent().hasExtra("DataTitle") &&
                getIntent().hasExtra("DataAuthor") && getIntent().hasExtra("DataSynopsis")){

            dataTitle = getIntent().getStringExtra("DataTitle");
            dataAuthor = getIntent().getStringExtra("DataAuthor");
            dataSynopsis= getIntent().getStringExtra("DataSynopsis");
            dataImage = getIntent().getIntExtra("DataCover", 1);
        }
        else{
            Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void dataSet(){
        bookTitle.setText(dataTitle);
        bookAuthor.setText(dataAuthor);
        bookSynopsis.setText(dataSynopsis);
        bookImage.setImageResource(dataImage);
    }

}