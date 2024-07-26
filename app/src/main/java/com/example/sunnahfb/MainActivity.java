package com.example.sunnahfb;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private AdapterDataSunnah adData;
    private List<DataModel> listData = new ArrayList<>();
    private SwipeRefreshLayout srlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rv_data);
        srlData = findViewById(R.id.srl_data);

        rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adData = new AdapterDataSunnah(this, listData);
        rvData.setAdapter(adData);

        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrieveData();
            }
        });

        retrieveData();
    }

    private void retrieveData() {
        srlData.setRefreshing(true);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("sunnahfb");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listData.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    DataModel dataModel = dataSnapshot.getValue(DataModel.class);
                    if (dataModel != null) {
                        Log.d("MainActivity", "Data: " + dataModel.getJudul() + ", " + dataModel.getDeskripsi() + ", " + dataModel.getKategori());
                        listData.add(dataModel);
                    }
                }
                adData.notifyDataSetChanged();
                srlData.setRefreshing(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Failed to retrieve data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                srlData.setRefreshing(false);
            }
        });
    }
}
