package vn.edu.stu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityNhanVien extends AppCompatActivity {
    EditText edtMa,edtTen,edtHeSo,edtLuong;
    Button btnSave;
    int result = 115;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_nhan_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = edtMa.getText().toString();
                String ten = edtTen.getText().toString();
                int heSoLuong = Integer.parseInt(edtHeSo.getText().toString());
                double luong = Double.parseDouble(edtLuong.getText().toString());
                NhanVien nv = new NhanVien(ma,ten,heSoLuong,luong);
                Intent intent = getIntent();
                intent.putExtra("TRA", nv);
                setResult(result,intent);
                finish();
            }
        });
    }

    private void addControls() {
        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);
        edtHeSo = findViewById(R.id.edtHeSoLuong);
        edtLuong = findViewById(R.id.edtLuong);
        btnSave = findViewById(R.id.btnSave);
    }
}