package com.abora.popularmoviesapp.network.interfaces;




import com.abora.popularmoviesapp.model.Movie;
import com.abora.popularmoviesapp.model.MoviesResponse;
import com.abora.popularmoviesapp.util.AppTools;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    @GET
    Observable<MoviesResponse> getMovies(@Url String url, @Query(AppTools.Network.API_KEY) String token);

    @GET("{id}")
    Observable<Movie> getMovieDetails(@Path("id") String id, @Query(AppTools.Network.API_KEY) String token);


    @GET("{id}/similar")
    Observable<MoviesResponse> getRelated(@Path("id") String id, @Query(AppTools.Network.API_KEY) String token);


}
