package com.example.utsarisalfauzi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView = null;
    private List<Product> list = null;
    private ProductAdapter adapter = null;

    private ProductDao dao = null;
    private View viewDialog = null;
    private EditText textNama, textMerk;
    private Button buttonSave, buttonCancel, buttonDelete;
    private AlertDialog dialog = null;
    private Product product = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        getSupportActionBar().hide();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        dao = AppDatabase.getDb(this).productDao();
        list = dao.getAll();
        adapter = new ProductAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
        setupDailog();

    }
    private void setupDailog(){
        viewDialog = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        textNama = viewDialog.findViewById(R.id.editTextNama);
        textMerk = viewDialog.findViewById(R.id.editTextMerk);
        buttonSave = viewDialog.findViewById(R.id.buttonSave);
        buttonDelete = viewDialog.findViewById(R.id.buttonDelete);
        buttonCancel = viewDialog.findViewById(R.id.buttonCancel);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Product Detail");
        builder.setView(viewDialog);
        dialog = builder.create();
        buttonCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.dismiss();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processSave();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processDelete();
            }
        });
    }

    private  void showDialog(){
        textNama.setText(product.getNama());
        textMerk.setText(product.getMerk());
        dialog.show();
    }

    private void processSave(){
        product.setNama(textNama.getText().toString());
        product.setMerk(textMerk.getText().toString());
        try {
            if(product.getId() > 0){
                dao.update(product);
            }else {
                long id = dao.insert(product);
                product.setId((int) id);
                list.add(0, product);
            }
            adapter.notifyDataSetChanged();
            dialog.dismiss();
            Toast.makeText(this, "Data Product Berhasil Ditambah", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(this, "Data Product Gagal Ditambah", Toast.LENGTH_SHORT).show();
        }
    }


    public void  processDelete(){
        try {
            list.remove(product);
            adapter.notifyDataSetChanged();
            dialog.dismiss();
            Toast.makeText(this,"Data Product Berhasil di Hapus", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(this,"Data Product Gagal di Hapus", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonAddClick(View view){
        product = new Product();
        product.setId(0);
        buttonDelete.setVisibility(View.INVISIBLE);
        showDialog();
    }

    @Override
    public void onClick(View v) {
        int position = recyclerView.getChildAdapterPosition(v);
        product = list.get(position);
        buttonDelete.setVisibility(View.VISIBLE);
        showDialog();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        MenuItem item = menu.findItem(R.id.menu_search);
//        SearchView searchView = (SearchView) item.getActionView();
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        searchView.setQueryHint("Cari Nama dosen");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                adapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }
}