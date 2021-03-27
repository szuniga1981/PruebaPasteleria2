package cl.sebastian.pruebapasteleria

import androidx.room.TypeConverter

class Converters {

        @TypeConverter
        fun list2String(list: List<String>): String {
            return list.joinToString()
        }
    @TypeConverter
    fun string2List(value: String): List<String> {
        return value.split(",").map {
            it.trim()
        }
    }

    @TypeConverter
    fun list2Double(list: List<Double>): String {
        return list.joinToString()
    }

    @TypeConverter
    fun doubles2List(value: String): List<Double> {
        val result = mutableListOf<Double>()
        value.split(",").forEach {
            if (it.isNotEmpty()) {
                result.add(it.trim().toDouble())
            }
        }
        return result
    }
}
