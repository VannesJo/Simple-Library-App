package com.example.perpusonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.perpusonline.Database.Book;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);

        if (Book.book_author.isEmpty()){
            Book.book_id.add(1);
            Book.book_cover.add(R.drawable.sao);
            Book.book_title.add("Sword Art Online");
            Book.book_author.add("Reki Kawahara");
            Book.book_synopsis.add("The adventures of Kazuto Kirito Kirigaya and Asuna Yuuki, two players who are trapped in the virtual world of Sword Art Online");

            Book.book_id.add(2);
            Book.book_cover.add(R.drawable.kimetsu);
            Book.book_title.add("Demon Slayer");
            Book.book_author.add("Koyoharu Gotouge");
            Book.book_synopsis.add("The story takes place in Taishō-era Japan, where a secret society, known as the Demon Slayer Corps, has been waging a secret war against demons for centuries");

            Book.book_id.add(3);
            Book.book_cover.add(R.drawable.naruto);
            Book.book_title.add("Naruto");
            Book.book_author.add("Masashi Kishimoto");
            Book.book_synopsis.add("Naruto Uzumaki, a young ninja who seeks recognition from his peers and dreams of becoming the Hokage, the leader of his village");

            Book.book_id.add(4);
            Book.book_cover.add(R.drawable.aot);
            Book.book_title.add("Attack on Titan");
            Book.book_author.add("Hajime Isayama");
            Book.book_synopsis.add("Eren Yeager is determined to help save humanity when titans re-appear and being to feast on human flesh.");

            Book.book_id.add(5);
            Book.book_cover.add(R.drawable.hyouka);
            Book.book_title.add("Hyouka");
            Book.book_author.add("Honobu Yonezawa");
            Book.book_synopsis.add("Oreki Hotarou and his mundane world is flipped upside down as they begin to solve various mysteries");

        }

        AdapterBook adapterBook = new AdapterBook(this, Book.book_title, Book.book_author, Book.book_synopsis, Book.book_id, Book.book_cover);
        recyclerView.setAdapter(adapterBook);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2:
                Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(i);
                return true;

            case R.id.item1:
                Intent n = new Intent(HomeActivity.this, ViewRequestActivity.class);
                startActivity(n);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}