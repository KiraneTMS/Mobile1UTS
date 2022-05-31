package com.example.mobile1_arsya_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile1_arsya_uts.databinding.FoodMenuItemBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    FoodMenuItemBinding binding;
    MenuAdapterInterface adapterInterface;
    MenuItem item;
    int position;
    int counter;

    String data1[], data2[];
    int images[];
    Context context;
    int currentQty = 0;

    public FoodAdapter(Context ct, String food[], String foodPrice[], int foodImages[]){
        context = ct;
        data1 = food;
        data2 = foodPrice;
        images = foodImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(FoodMenuItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.name.setText(data1[position]);
        holder.binding.price.setText(data2[position]);
        holder.binding.image.setImageResource(images[position]);

        holder.binding.increaseQty.setOnClickListener(view -> {
            counter = Integer.valueOf(String.valueOf(binding.qtty.getText()));
            binding.qtty.setText(counter+1);
        });

        holder.binding.decreaseQty.setOnClickListener(view -> {
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }
    interface MenuAdapterInterface {
        void OnDataChanged(MenuItem item, int position);
    }

    public int getHargaToIdrFormat(int harga) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        formatter.format(harga);
        return harga;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        FoodMenuItemBinding binding;
        public MyViewHolder(@NonNull FoodMenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
