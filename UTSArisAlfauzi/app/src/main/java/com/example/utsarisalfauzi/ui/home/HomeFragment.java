package com.example.utsarisalfauzi.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.utsarisalfauzi.HitungActivity;
import com.example.utsarisalfauzi.MapActivity;
import com.example.utsarisalfauzi.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        @SuppressLint("WrongViewCast") ImageView btnPindahActiHitung = (ImageView) view.findViewById(R.id.btn_hitungKalku);
        btnPindahActiHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), HitungActivity.class);
                startActivity(in);
            }
        });
        @SuppressLint("WrongViewCast") ImageView btnMap = (ImageView) view.findViewById(R.id.lihatMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), MapActivity.class);
                startActivity(in);
            }
        });
        return  view;
        }


}