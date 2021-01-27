package com.example.utsarisalfauzi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductviewHolder> {
    private Context context;
    private List<Product> list = new ArrayList<>();
    private List<Product> filteredlist = new ArrayList<>();
    private Map<String, String> initialColor = new HashMap<>();
    private View.OnClickListener listener;

    public  ProductAdapter(Context context, List<Product> list, View.OnClickListener onClickListener ){
        this.context = context;
        this.list = list;
        this.filteredlist = list;
        initialColor.put("A", "#00aaaa");
        initialColor.put("B", "#f08080");
        initialColor.put("C", "#0000ff");
        initialColor.put("D", "#000080");
        initialColor.put("E", "#00aa00");
        initialColor.put("F", "#6f00ff");
        initialColor.put("G", "#808080");
        initialColor.put("H", "#dc143c");
        initialColor.put("I", "#ffc0cb");
        initialColor.put("J", "#cd5c5c");
        initialColor.put("K", "#00ff00");
        initialColor.put("L", "#ffd700");
        initialColor.put("M", "#ffff00");
        initialColor.put("N", "#808000");
        initialColor.put("O", "#aaaa00");
        initialColor.put("P", "#ffa500");
        initialColor.put("Q", "#9acd32");
        initialColor.put("R", "#bbd46a");
        initialColor.put("S", "#a4c639");
        initialColor.put("T", "#ff008d");
        initialColor.put("U", "#ff0006");
        initialColor.put("V", "#0009ff");
        initialColor.put("W", "#a29088");
        initialColor.put("X", "#a4c639");
        initialColor.put("Y", "#888b77");
        initialColor.put("Z", "#d5e29f");
    }
    @NonNull
    @Override
    public ProductviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false);
        view.setOnClickListener(listener);
        ProductviewHolder holder = new ProductviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductviewHolder holder, int position) {
        Product product = filteredlist.get(position);
        String initial = product.getNama().substring(0, 1);
        holder.textInitial.setText(initial);
        holder.textNama.setText(product.getNama());
        holder.textMerk.setText(product.getMerk());
        holder.viewInitial.getBackground().setColorFilter(Color.parseColor(initialColor.get(initial)),
                PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    public int getItemCount() {
        return filteredlist.size();
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                List<Product> listFilter = new ArrayList<>();
//                String search = constraint.toString();
//                for (Product product : list) {
//                    if(product.getNama().toLowerCase().contains(search.toLowerCase())){
//                        listFilter.add(product);
//                    }
//                }
//                filteredlist = listFilter;
//                FilterResults results = new FilterResults();
//                results.values = listFilter;
//                return results;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                filteredlist = (List<Product>) results.values;
//                notifyDataSetChanged();
//            }
//        };
//    }

    public static  class ProductviewHolder extends RecyclerView.ViewHolder{
        LinearLayout viewInitial = null;
        TextView textNama, textMerk, textInitial;
        View viewStatus = null;
        public ProductviewHolder(@NonNull View view) {
            super(view);
            viewInitial = view.findViewById(R.id.viewInitial);
            textNama = view.findViewById(R.id.textNama);
            textMerk = view.findViewById(R.id.textMerk);
            textInitial = view.findViewById(R.id.textInitial);
        }
    }

}
