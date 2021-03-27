package cl.sebastian.pruebapasteleria

import retrofit2.Response
import retrofit2.http.GET

interface PasteleriaAPI {

    @GET("cakes")
    suspend fun  getProducts(): Response<List<Cakes>>
}