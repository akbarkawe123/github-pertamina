package com.example.ee.project;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    MapFragment fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        SupportMapFragment mf = (SupportMapFragment) getSupportFragmentManager().
                findFragmentById(R.id.map);
        fm = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        fm = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        String data = "Jalan : RE.Martadinata";
        data +=",Nama SPBU : SPBU Pertamina 64 751 02 ";
        data +=",Jenis Bahan Bakar : Pertamax Full";
        data +=",Jenis Bahan Bakar : Pertalite Empety";
        data +=",Jenis Bahan Bakar : Solar Full";
        String data1 = "Jalan :IR.Juanda";
        data1 +=",Nama SPBU : SPBU Pertamina 64 751 03";
        data1 +=",Jenis Bahan Bakar : Pertamax Dalam Pengisian";
        data1 +=",Jenis Bahan Bakar : Pertalite Empety";
        data1 +=",Jenis Bahan Bakar : Solar Full";



        LatLng SPBUREMartadinata = new LatLng(-0.500966,117.133641);
        mMap.addMarker(new MarkerOptions().position(SPBUREMartadinata).icon(BitmapDescriptorFactory.
                defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("").
                snippet(data));
        mMap.setInfoWindowAdapter(YES);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SPBUREMartadinata, 13));

        LatLng SPBUJuanda = new LatLng(-0.482612,117.132112);
        mMap.addMarker(new MarkerOptions().position(SPBUJuanda).icon(BitmapDescriptorFactory.
                defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("").
                snippet(data1));
        mMap.setInfoWindowAdapter(YES);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SPBUJuanda, 13));
        }

        GoogleMap.InfoWindowAdapter YES = new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker arg0) {
                View view = getLayoutInflater().inflate(R.layout.info_window, null);
                final String[] hasil = arg0.getSnippet().split(",");
                TextView jalan = (TextView) view.findViewById(R.id.textjalan);
                TextView nama = (TextView) view.findViewById(R.id.textNama);
                TextView pertamax = (TextView) view.findViewById(R.id.textPertamax);
                TextView pertalite = (TextView) view.findViewById(R.id.textPertalite);
                TextView solar = (TextView) view.findViewById(R.id.textSolar);
                jalan.setText(hasil[0]);
                nama.setText(hasil[1]);
                pertamax.setText(hasil[2]);
                pertalite.setText(hasil[3]);
                solar.setText(hasil[4]);
                view = getLayoutInflater().inflate(R.layout.info_window, null);
                final String[] hasil1 = arg0.getSnippet().split(",");
                TextView jalan1 = (TextView) view.findViewById(R.id.textjalan);
                TextView nama1 = (TextView) view.findViewById(R.id.textNama);
                TextView pertamax1 = (TextView) view.findViewById(R.id.textPertamax);
                TextView pertalite1 = (TextView) view.findViewById(R.id.textPertalite);
                TextView solar1 = (TextView) view.findViewById(R.id.textSolar);
                jalan1.setText(hasil[0]);
                nama1.setText(hasil[1]);
                pertamax1.setText(hasil[2]);
                pertalite1.setText(hasil[3]);
                solar1.setText(hasil[4]);
                return view;
        }
        };
    }
