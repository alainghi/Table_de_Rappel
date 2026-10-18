package fr.aghi.tablederappel.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.aghi.tablederappel.model.Item
import fr.aghi.tablederappel.model.TBNombreItem
import java.io.IOException

object JsonUtils {
    fun loadTBNom(context: Context): List<Item> {
        val jsonString = try {
            context.assets.open("json/TBNom.json").bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            return emptyList()
        }

        return try {
            val type = object : TypeToken<List<Map<String, Item>>>() {}.type
            val response = Gson().fromJson<List<Map<String, Item>>>(jsonString, type)
            response.firstOrNull()?.values?.toList() ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun loadTBNombre(context: Context): List<TBNombreItem> {
        val jsonString = try {
            context.assets.open("json/TBNombre.json").bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            return emptyList()
        }

        return try {
            val type = object : TypeToken<List<Map<String, TBNombreItem>>>() {}.type
            val response = Gson().fromJson<List<Map<String, TBNombreItem>>>(jsonString, type)
            response.firstOrNull()?.values?.toList() ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
} 