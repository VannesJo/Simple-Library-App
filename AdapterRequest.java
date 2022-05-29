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

import com.example.perpusonline.Database.RequestedBook;
import com.example.perpusonline.Database.User;

import java.util.Vector;

public class AdapterRequest extends RecyclerView.Adapter<AdapterRequest.OurViewHolder> {

    private Vector<String> book_title_req = new Vector<String>();
    private Vector<String> book_author_req = new Vector<String>();
    private Vector<String> book_synopsis_req = new Vector<String>();
    private Vector<Integer> book_id_req = new Vector<Integer>();
    private Vector<Integer> book_cover_req = new Vector<Integer>();
    private Vector<Integer> requester_ID = new Vector<Integer>();
    private Vector<String> receiver_ID = new Vector<String>();
    private Context context;

    public AdapterRequest(Context ct, Vector<String> bookTitle, Vector<String> bookAuthor, Vector<String> bookSynopsis, Vector<Integer> bookId, Vector<Integer> bookCover, Vector<Integer> requesterID, Vector<String> receiverID){
        context = ct;
        book_title_req = bookTitle;
        book_author_req = bookAuthor;
        book_synopsis_req = bookSynopsis;
        book_id_req = bookId;
        book_cover_req = bookCover;
        requester_ID = requesterID;
        receiver_ID = receiverID;
    }

    @NonNull
    @Override
    public OurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_request, parent, false);
        return new OurViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OurViewHolder holder, int position) {
        holder.reqTitle.setText(book_title_req.get(position));
        holder.reqAuthor.setText(book_author_req.get(position));
        holder.requesterEmail.setText(User.email.get(position));
        holder.receiverEmail.setText(receiver_ID.get(position));
        holder.reqCover.setImageResource(book_cover_req.get(position));

        holder.secondLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RequestDetailActivity.class);
                intent.putExtra("DataReqTitle",book_title_req.get(position));
                intent.putExtra("DataReqAuthor",book_author_req.get(position));
                intent.putExtra("DataReqSynopsis",book_synopsis_req.get(position));
                intent.putExtra("DataReqCover",book_cover_req.get(position));
                intent.putExtra("DataRequester",User.email.get(position));
                intent.putExtra("DataReceiver",receiver_ID.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        int temp = book_author_req.size();
        return temp;
    }

    public class OurViewHolder extends RecyclerView.ViewHolder {

        TextView reqTitle, reqAuthor, requesterEmail, receiverEmail;
        ImageView reqCover;
        LinearLayout secondLayout;

        public OurViewHolder(@NonNull View itemView) {
            super(itemView);
            reqTitle = itemView.findViewById(R.id.req_title);
            reqAuthor = itemView.findViewById(R.id.reqAuthor);
            requesterEmail = itemView.findViewById(R.id.requester);
            receiverEmail = itemView.findViewById(R.id.receiver);
            reqCover =  itemView.findViewById(R.id.req_cover);
            secondLayout = itemView.findViewById(R.id.secondLayout);
        }
    }
}
