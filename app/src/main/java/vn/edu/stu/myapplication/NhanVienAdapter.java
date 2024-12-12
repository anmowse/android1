package vn.edu.stu.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {
    Activity context;
    int res;
    List<NhanVien> objects;

    public NhanVienAdapter( Activity context, int res, List<NhanVien> objects) {
        super(context, res,objects);
        this.context = context;
        this.res = res;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.res,null);
        TextView txtMa = item.findViewById(R.id.txtMa);
        TextView txtTen = item.findViewById(R.id.txtTen);
        TextView txtHeSo = item.findViewById(R.id.txtHeSo);
        TextView txtLuong = item.findViewById(R.id.txtLuong);

        NhanVien nv = this.objects.get(position);

        txtMa.setText(nv.getMa());
        txtTen.setText(nv.getTen());
        txtHeSo.setText(nv.getHeSoLuong()+" ");
        txtLuong.setText(nv.getLuongCoBan()+" ");
        return item;
    }
}
