package ayds.dodo.movieinfo.home.model.repository.external.omdb

import ayds.dodo.movieinfo.home.model.entities.OmdbMovie
import ayds.dodo.movieinfo.home.model.repository.external.ExternalService
import retrofit2.Response
import java.lang.Exception

internal class OmdbService(
    private val omdbAPI: OmdbAPI,
    private val omdbMovieResolver: OmdbResponseToOmdbMovieResolver
) : ExternalService {

    override fun getMovie(title: String): OmdbMovie {
        //try {
            val callResponse = getOmdbMovieFromService(title)
            return omdbMovieResolver.getMovieFromExternalData(callResponse.body())
      //  }catch(e:Exception){
        //    throw IllegalArgumentException("Value must be positive")

        //}
    }

    private fun getOmdbMovieFromService(title: String): Response<String> {
        return omdbAPI.getTerm(title).execute()
    }

}