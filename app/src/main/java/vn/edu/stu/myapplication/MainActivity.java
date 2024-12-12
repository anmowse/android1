package vn.edu.stu.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    ListView lvNhanVien;
    List<NhanVien> dsNhanVien;
    NhanVienAdapter adapter;
    int requestCode = 113, resultCode = 115;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        dsNhanVien = new ArrayList<>();
        adapter = new NhanVienAdapter(
                MainActivity.this,
                R.layout.custom_nhanvien,
                dsNhanVien
        );
        lvNhanVien.setAdapter(adapter);
        addEvents();
    }

    private void addEvents() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityNhanVien.class);
                startActivityForResult(intent,requestCode);
            }
        });
        lvNhanVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                AlertDialog.Builder diglog = new AlertDialog.Builder(MainActivity.this);
                diglog.setTitle("Xóa");
                diglog.setMessage("Bạn có chắc muốn xóa không ?");
                diglog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(pos >= 0 && pos <= dsNhanVien.size()){
                            dsNhanVien.remove(pos);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
                diglog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog a = diglog.create();
                a.setCanceledOnTouchOutside(false);
                a.show();
                return true;
            }
        });
        lvNhanVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder();

                return true;
            }
        });
    }

    private void addControls() {
        btnAdd = findViewById(R.id.btnAdd);
        lvNhanVien = findViewById(R.id.lvNhanVien);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == this.requestCode){
            if(resultCode == this.resultCode){
                if(data.hasExtra("TRA")){
                    NhanVien nv = (NhanVien) data.getSerializableExtra("TRA");
                    dsNhanVien.add(nv);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}