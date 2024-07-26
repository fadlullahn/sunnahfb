package com.example.sunnahfb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.widget.TextView;

public class AdapterDataSunnah extends RecyclerView.Adapter<AdapterDataSunnah.ViewHolder> {

    private Context context;
    private List<DataModel> listData;

    public AdapterDataSunnah(Context context, List<DataModel> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_sunnah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel data = listData.get(position);
        holder.tvId.setText("ID: " + data.getKey());
        holder.tvJudul.setText(data.getJudul());
        holder.tvDeskripsi.setText(data.getDeskripsi());
        holder.tvKategori.setText(data.getKategori());
    }

    @Override
    public int getItemCount() {
        return listData != null ? listData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvJudul, tvDeskripsi, tvKategori;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            tvKategori = itemView.findViewById(R.id.tv_kategori);
        }
    }
}
