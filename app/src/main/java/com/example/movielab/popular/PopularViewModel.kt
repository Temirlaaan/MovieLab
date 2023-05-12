package com.example.movielab.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielab.network.ApiServices
import com.example.movielab.network.PopularMovieListResponse
import com.example.movielab.popular.model.Popular
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel(
    private val apiServices: ApiServices
): ViewModel() {
    private val _basketDetailData = MutableLiveData<List<Popular>>()
    val basketDetailData: LiveData<List<Popular>>
        get() = _basketDetailData

    private val movieList = mutableListOf<Popular>()

    fun loadMovieList(){
        apiServices.getPopularMovie().enqueue(object : Callback<PopularMovieListResponse> {
            override fun onResponse(call: Call<PopularMovieListResponse>, response: Response<PopularMovieListResponse>) {
                val responseSuccess = response.body()
                responseSuccess?.let {Popular ->
                    Popular.results.forEach {
                        movieList.add(
                            Popular(
                                id = it.id,
                                title = it.title,
                                releaseDate = it.releaseDate,
                                rating = it.voteAverage,
                                posterURL = it.posterPath,
                                overview = it.overview,
                                lang = it.originalLanguage
                            )
                        )
                    }
                }
                _basketDetailData.value = movieList
            }
            override fun onFailure(call: Call<PopularMovieListResponse>, t: Throwable) {
            }
        }
        )
    }

    override fun onCleared() {
        super.onCleared()
    }
}