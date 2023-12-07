package com.miaxis.demo.ui.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.miaxis.demo.R;
import com.miaxis.demo.data.remote.response.PensionData;
import com.miaxis.demo.databinding.SearchListItemBinding;

import java.util.List;

public class PensionListAdapter extends RecyclerView.Adapter<PensionListAdapter.MyViewHolder> {
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(PensionData item);
    }

    private SearchListItemBinding itemBinding;
    public List<PensionData> data;

    public PensionListAdapter(List<PensionData> pensioneerList, OnItemClickListener listener) {
        this.data = pensioneerList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemBinding = SearchListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(data.get(position), listener);
        PensionData user = data.get(position);

        itemBinding.itemUserId.setText(String.valueOf(user.getValue().get(0).getNo()));
        itemBinding.itemFullName.setText(user.getValue().get(0).getFirstName());
        itemBinding.btnView.setOnClickListener(v->  listener.onItemClick(user));
        holder.itemView. setOnClickListener(v -> {
            listener.onItemClick(user);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        SearchListItemBinding itemBinding;

        public MyViewHolder(@NonNull SearchListItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }

        public void bind(final PensionData item, final OnItemClickListener listener) {
            itemBinding.itemUserId.setText(item.getValue().get(0).getNo());
            itemBinding.itemFullName.setText(item.getValue().get(0).getFirstName());

            Drawable drawable;
//            if(item.isVerified()){
//                drawable = ContextCompat.getDrawable(itemView.getContext(), R.drawable.verified_dot_component);
//            }else{
            //drawable = ContextCompat.getDrawable(itemView.getContext(), R.drawable.un_verified_dot_component);
//            }
                drawable = ContextCompat.getDrawable(itemView.getContext(), R.drawable.un_verified_dot_component);
            itemBinding.vVerifiedDot.setBackground(drawable);
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}
