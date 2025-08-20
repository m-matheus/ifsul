package br.ifsul;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;

    private ImageButton btVerificar;
    private TextView textLocalizacao, textPrecisao, textNomePokemon;

    private Retrofit retrofit;
    private PokemonService service;
    private String baseUrl = "http://16.171.172.172";

    private ImageView pokemonCatched;
    private ListView pokemonList;
    private PokemonAdapter pokemonAdapter;
    private List<Pokemon> pokemonArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btVerificar = findViewById(R.id.button);
        textLocalizacao = findViewById(R.id.textLocalizacao);
        textPrecisao = findViewById(R.id.textPrecisao);
        textNomePokemon = findViewById(R.id.textNomePokemon);
        pokemonCatched = findViewById(R.id.pokemon_catched);

        pokemonAdapter = new PokemonAdapter(getApplicationContext(), R.layout.pokedex);
        pokemonList = findViewById(R.id.pokedex_list);

        pokemonList.setAdapter(pokemonAdapter);

        /*
        GPS
         */
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        /*
        API - Retrofit
         */
        this.retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build();
        this.service = retrofit.create(PokemonService.class);

        final String msg = "Verificando...";

        btVerificar.setOnClickListener(v -> {

            textPrecisao.setText(msg);
            textLocalizacao.setText(msg);
            textNomePokemon.setText(msg);

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                textLocalizacao.setText("Sem permissão de acesso ao GPS.");
            }
            else {
                fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
                        .addOnSuccessListener(this, location -> {
                            if (location != null) {
                                double latitude = location.getLatitude();
                                double longitude = location.getLongitude();

                                textPrecisao.setText("Precisão: " + location.getAccuracy());

                                textLocalizacao.setText("Lat: " + latitude + " Long: " + longitude + " ");

                                Call<Pokemon> call = service.capturar(latitude, longitude);

                                call.enqueue(new Callback<Pokemon>() {
                                    @Override
                                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {

                                        switch (response.code())
                                        {
                                            case 200:
                                                Pokemon pokemon = response.body();
                                                String nome = pokemon.getNome();
                                                int imageId;

                                                textNomePokemon.setText("Pokemon " + nome);

                                                switch (nome.toLowerCase()) {
                                                    case "arcanine":
                                                        imageId = R.drawable.arcanine;
                                                        break;
                                                    case "arceus":
                                                        imageId = R.drawable.arceus;
                                                        break;
                                                    case "charizard":
                                                        imageId = R.drawable.charizard;
                                                        break;
                                                    case "eevee":
                                                        imageId = R.drawable.eevee;
                                                        break;
                                                    case "gengar":
                                                        imageId = R.drawable.gengar;
                                                        break;
                                                    case "mewtwo":
                                                        imageId = R.drawable.mewtwo;
                                                        break;
                                                    case "onix":
                                                        imageId = R.drawable.onix;
                                                        break;
                                                    case "pikachu":
                                                        imageId = R.drawable.pikachu;
                                                        break;
                                                    case "snorlax":
                                                        imageId = R.drawable.snorlax;
                                                        break;
                                                    case "squirtle":
                                                        imageId = R.drawable.squirtle;
                                                        break;
                                                    default:
                                                        imageId = R.drawable.pokeball;
                                                        break;
                                                }
                                                pokemon.setImage(imageId);
                                                pokemonCatched.setImageResource(imageId);

                                                if (!pokemonArray.contains(pokemon)) {
                                                    pokemonAdapter.add(pokemon);
                                                    pokemonArray.add(pokemon);
                                                }
                                                break;
                                            case 204: // no content
                                                textNomePokemon.setText("Pokemon não encontrado...");
                                                break;
                                            default:
                                                textNomePokemon.setText("Houve algum problema..." + response.code());
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Pokemon> call, Throwable t) {
                                        textNomePokemon.setText("Falha ao tentar capturar " + t.getMessage());
                                    }
                                });

                            } else {
                                textPrecisao.setText("Localização não disponível.");
                            }
                        });
            }
        });
    }
}