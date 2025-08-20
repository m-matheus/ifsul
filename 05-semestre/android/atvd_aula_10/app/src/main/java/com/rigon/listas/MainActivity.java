package com.rigon.listas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rigon.listas.adapters.CountryAdapter;
import com.rigon.listas.models.Country;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView countryListView;
    private CountryAdapter countryAdapter;
    private List<Country> countryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryAdapter = new CountryAdapter(getApplicationContext(), R.layout.coutry_list_layout);
        countryListView = findViewById(R.id.country_list);
        countryList = new ArrayList<>();

        countryListView.setAdapter(countryAdapter);

        countryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String countryName = countryAdapter.getItem(position).getName();

                Toast.makeText(getApplicationContext(), countryName, Toast.LENGTH_SHORT).show();
            }
        });

        countryList.add(new Country("Alemanha", "Berlim", R.drawable.flag_alemanha));
        countryList.add(new Country("Argentina", "Buenos aires", R.drawable.flag_argentina));
        countryList.add(new Country("Brasil", "Brasília", R.drawable.flag_brasil));
        countryList.add(new Country("Canada", "Ottawa", R.drawable.flag_canada));
        countryList.add(new Country("França", "París", R.drawable.flag_franca));
        countryList.add(new Country("Italia", "Roma", R.drawable.flag_italia));
        countryList.add(new Country("Japão", "Tokyo", R.drawable.flag_japao));

        countryAdapter.addAll(countryList);
    }
}