package com.example.perpusonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.perpusonline.Database.Book;
import com.example.perpusonline.Database.RequestedBook;

public class ViewRequestActivity extends AppCompatActivity {

    RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_request);

        recyclerView2 = findViewById(R.id.recyclerView2);

        AdapterRequest adapterRequest = new AdapterRequest(this, RequestedBook.bookReq_title, RequestedBook.bookReq_author, RequestedBook.bookReq_synopsis, RequestedBook.bookReq_id, RequestedBook.bookReq_cover, RequestedBook.requesterID, RequestedBook.receiverID);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapterRequest);

    }
}