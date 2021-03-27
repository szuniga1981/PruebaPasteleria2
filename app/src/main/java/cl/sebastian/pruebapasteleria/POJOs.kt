package cl.sebastian.pruebapasteleria

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName ="pojoPasteleria")
data class Cakes(@PrimaryKey val id:Int, val title:String, val previewDescription:String, val size:String,
                 val price:Int, val image:String)


@Dao
interface PasteleriaDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(lista:List<Cakes>)

    @Query("SELECT * FROM pojoPasteleria")
    fun getProducts(): LiveData<List<Cakes>>

    @Query("SELECT * FROM pojoPasteleria  WHERE id=:code")
    fun getProductsDetail (code: Int): LiveData<Cakes>
}
@Database(entities = [Cakes::class],version = 1)
@TypeConverters(Converters::class)
abstract  class PasteleriaDatabase:RoomDatabase(){
    abstract fun pasteleriaDao(): PasteleriaDao
}
class PasteleriaApplication: Application() {
    companion object {
        var pasteleriaDatabase: PasteleriaDatabase? = null

    }

    override fun onCreate() {
        super.onCreate()
        pasteleriaDatabase = Room.databaseBuilder(this, PasteleriaDatabase::class.java, "pasteleria_db").build()
    }
}