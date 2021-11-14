package com.example.project.database;

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

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<LendData> lendDatas;

    private onClickSend clickSend;

    public DataAdapter(List<LendData> lendDatas , onClickSend send) {
        this.clickSend = send;
        this.lendDatas = lendDatas;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LendData lendData = lendDatas.get(position);
        holder.setItem(lendData , position);
    }

    @Override
    public int getItemCount() {
        return lendDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, description, categoryId, categoryName, author, publisher;
        private ImageView imageView, deleteBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.listbookImage);
            title = itemView.findViewById(R.id.listbookTitle);
            publisher = itemView.findViewById(R.id.listpublisher);
            categoryId = itemView.findViewById(R.id.listcategoryId);
            categoryName = itemView.findViewById(R.id.listcategoryName);
            author = itemView.findViewById(R.id.listauthor);
            deleteBtn = itemView.findViewById(R.id.listdeletebtn);


        }

        public void setItem(LendData lendData , int posision) {

            Glide.with(itemView)
                    .load(lendData.getImageurl())
                    .into(imageView);

            title.setText(lendData.getTitle());
            //description.setText(item.getDescription());
            categoryId.setText(lendData.getCategoryId());
            Log.d("category", "category == " + lendData.getCategoryId() + "");
            publisher.setText(lendData.getPublisher());
            categoryName.setText(lendData.getCategoryName());
            author.setText(lendData.getAuthor());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickSend.onClickBody(lendData);
                }
            });


            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickSend.onClickDelete(lendData , posision);
                }
            });


        }

    }

    public interface onClickSend{
        void onClickBody(LendData lendData);
        void onClickDelete(LendData lendData , int pos);

    }


}
