package com.example.sportnewstest.view

import android.content.Context
import android.widget.Toast
import androidx.core.content.edit
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class PrefHelper(private val context: Context) {

    val firebaseRemoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

    fun getSavedLink(): String? {
        val sharedPreferences =
            context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("link", null)
    }

    fun saveLink(link: String) {
        val sharedPreferences =
            context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit { putString("link", link) }
    }

    fun fetchLinkFromFirebase() {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .build()
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)

        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val link = firebaseRemoteConfig.getString("link")
                    saveLink(link)
                } else {
                    Toast.makeText(context, "Download is failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }
}