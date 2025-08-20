package br.ifsul;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

  @GET("api/v1/pokemon/{lat}/{lon}")
  Call<Pokemon> capturar(@Path("lat") Double latitude, @Path("lon") Double longitude);
}