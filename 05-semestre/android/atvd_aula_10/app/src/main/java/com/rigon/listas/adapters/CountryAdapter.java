package com.rigon.listas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rigon.listas.R;
import com.rigon.listas.models.Country;

public class CountryAdapter extends ArrayAdapter<Country> {
    public CountryAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            Country country = getItem(position);
            LayoutInflater inflater = LayoutInflater.from(getContext().getApplicationContext());

            convertView = inflater.inflate(R.layout.coutry_list_layout, parent, false);
            ImageView countryFlag = convertView.findViewById(R.id.flag_image);
            TextView countryName = convertView.findViewById(R.id.country_name);
            TextView capitalName = convertView.findViewById(R.id.capital_name);

            countryFlag.setImageResource(country.getFlag());
            countryName.setText(country.getName());
            capitalName.setText(country.getCapital());
        }

        return convertView;
    }
}