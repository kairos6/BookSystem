package com.example.project;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Item> items;

    public BookAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, description, categoryId, categoryName, author, publisher;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.bookImage);
            title = itemView.findViewById(R.id.bookTitle);
            //description = itemView.findViewById(R.id.description);
            publisher = itemView.findViewById(R.id.publisher);
            categoryId = itemView.findViewById(R.id.categoryId);
            categoryName = itemView.findViewById(R.id.categoryName);
            author = itemView.findViewById(R.id.author);

        }

        public void setItem(Item item) {

            Glide.with(itemView)
                    .load(item.getCoverLargeUrl())
                    .into(imageView);

            title.setText(item.getTitle());
            //description.setText(item.getDescription());
            categoryId.setText(item.getCategoryId() + "");
            publisher.setText(item.getPublisher());
            categoryName.setText(item.getCategoryName());
            author.setText(item.getAuthor());

        }
    }
}
