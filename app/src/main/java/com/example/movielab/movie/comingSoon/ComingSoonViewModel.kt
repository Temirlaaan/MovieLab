package com.example.movielab.movie.comingSoon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielab.movie.comingSoon.model.ComingSoon
import com.example.movielab.network.ApiServices
import com.example.movielab.network.Soon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComingSoonViewModel(
    private val apiServices: ApiServices
): ViewModel() {
    private val _basketDetailData = MutableLiveData<List<ComingSoon>>()
    val basketDetailData: LiveData<List<ComingSoon>>
        get() = _basketDetailData

    private val movieList = mutableListOf<ComingSoon>()

    fun loadSoonList(){
        apiServices.getUpcomingMovie().enqueue(object : Callback<Soon> {
            override fun onResponse(call: Call<Soon>, response: Response<Soon>) {
                val responseSuccess = response.body()
                responseSuccess?.let {ComingSoon ->
                    ComingSoon.results.forEach {
                        movieList.add(
                            ComingSoon(
                                title = it.title,
                                release_date = it.releaseDate,
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
            override fun onFailure(call: Call<Soon>, t: Throwable) {
            }
        }
        )
    }

    override fun onCleared() {
        super.onCleared()
    }
}