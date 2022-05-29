package com.example.perpusonline;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.MyViewHolder> {

    private Vector<String> book_title = new Vector<String>();
    private Vector<String> book_author = new Vector<String>();
    private Vector<String> book_synopsis = new Vector<String>();
    private Vector<Integer> book_id = new Vector<Integer>();
    private Vector<Integer> book_cover = new Vector<Integer>();
    private Context context;

    public AdapterBook(Context ct, Vector<String> bookTitle, Vector<String> bookAuthor, Vector<String> bookSynopsis, Vector<Integer> bookId, Vector<Integer> bookCover){
        context = ct;
        book_title = bookTitle;
        book_author = bookAuthor;
        book_synopsis = bookSynopsis;
        book_id = bookId;
        book_cover = bookCover;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.list_book, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleBook.setText(book_title.get(position));
        holder.authorBook.setText(book_author.get(position));
        holder.synopsisBook.setText(book_synopsis.get(position));
        holder.coverBook.setImageResource(book_cover.get(position));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookDetailActivity.class);
                intent.putExtra("DataTitle",book_title.get(position));
                intent.putExtra("DataAuthor",book_author.get(position));
                intent.putExtra("DataSynopsis",book_synopsis.get(position));
                intent.putExtra("DataCover",book_cover.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        int temp = book_author.size();
        return temp;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleBook, authorBook, synopsisBook;
        ImageView coverBook;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleBook = itemView.findViewById(R.id.bookTitle);
            authorBook = itemView.findViewById(R.id.bookAuthor);
            synopsisBook = itemView.findViewById(R.id.bookSynopsis);
            coverBook = itemView.findViewById(R.id.book_cover);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
