package com.example.project.search;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private static onClickSend clickSend;


    private List<SearchItem> searchitems;

    public SearchAdapter(List<SearchItem> searchitems , onClickSend send) {
        this.searchitems = searchitems;
        this.clickSend = send;
    }

//    public BookAdapter(List<Item> items , onClickSend send) {
//        this.clickSend = send;
//        this.items = items;
//    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SearchItem searchitem = searchitems.get(position);
        holder.setItem(searchitem);
    }

    @Override
    public int getItemCount() {
        return searchitems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, description, categoryId, categoryName, author, publisher;
        private ImageView imageView;

        public ViewHolder(View searchitemView) {
            super(searchitemView);
            imageView = searchitemView.findViewById(R.id.bookImage);
            title = searchitemView.findViewById(R.id.bookTitle);
            //description = searchitemView.findViewById(R.id.description);
            publisher = searchitemView.findViewById(R.id.publisher);
            categoryId = searchitemView.findViewById(R.id.categoryId);
            categoryName = searchitemView.findViewById(R.id.categoryName);
            author = searchitemView.findViewById(R.id.author);

        }

        public void setItem(SearchItem searchitem) {

            Log.d("retrofit", "Data fetch success" + searchitem.getTitle());

            Glide.with(itemView)
                    .load(searchitem.getCoverLargeUrl())
                    .into(imageView);

            title.setText(searchitem.getTitle());
            //description.setText(item.getDescription());
//            categoryId.setText(searchitem.getCategoryId() + "");
            categoryId.setText(searchitem.getCategoryId()+"");
            publisher.setText(searchitem.getPublisher());
            categoryName.setText(searchitem.getCategoryName());
            author.setText(searchitem.getAuthor());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickSend.onClickBody(searchitem);
                }
            });
/*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickSend.onClickBody(item);
                }
            });*/

        }
    }

    public interface onClickSend{
        void onClickBody(SearchItem searchItem);
    }

}
