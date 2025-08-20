package br.ifsul;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

        public PokemonAdapter(@NonNull Context context, int resource) {
        super(context, resource, R.id.pokemon_name);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext().getApplicationContext());

            convertView = inflater.inflate(R.layout.pokedex, parent, false);

            Pokemon pokemon = getItem(position);

            ImageView image = convertView.findViewById(R.id.pokemon_image);
            TextView nome = convertView.findViewById(R.id.pokemon_name);

            image.setImageResource(pokemon.getImage());
            nome.setText(pokemon.getNome());
        }

        return convertView;
    }

}
