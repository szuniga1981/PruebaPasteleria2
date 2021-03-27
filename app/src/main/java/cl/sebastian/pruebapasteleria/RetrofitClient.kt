package cl.sebastian.pruebapasteleria

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/cakesApi/"


        fun retrofitCliente(): PasteleriaAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(PasteleriaAPI::class.java)
        }
    }

}