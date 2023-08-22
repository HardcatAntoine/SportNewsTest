package com.example.sportnewstest.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportnewstest.R
import com.google.firebase.remoteconfig.BuildConfig
import java.util.Locale


class SplashFragment : Fragment() {

    lateinit var prefHelper: PrefHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    //проверка есть ли сохраненная ссылка
    fun checkAndFetchLink(): Boolean {
        val savedLink = prefHelper.getSavedLink()
        return if (savedLink.isNullOrEmpty()) {
            prefHelper.fetchLinkFromFirebase()
            true
        } else {
            false
        }
    }


    //проверка на эмулятор
    private fun checkIsEmu(): Boolean {
        if (BuildConfig.DEBUG) return false

        val phoneModel = Build.MODEL
        val buildProduct = Build.PRODUCT
        val buildHardware = Build.HARDWARE
        var result = (Build.FINGERPRINT.startsWith("generic")
                || phoneModel.contains("google_sdk")
                || phoneModel.lowercase(Locale.getDefault()).contains("droid4x")
                || phoneModel.contains("Emulator")
                || phoneModel.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || buildHardware == "goldfish"
                || Build.BRAND.contains("google")
                || buildHardware == "vbox86"
                || buildProduct == "sdk"
                || buildProduct == "google_sdk"
                || buildProduct == "sdk_x86"
                || buildProduct == "vbox86p"
                || Build.BOARD.lowercase(Locale.getDefault()).contains("nox")
                || Build.BOOTLOADER.lowercase(Locale.getDefault()).contains("nox")
                || buildHardware.lowercase(Locale.getDefault()).contains("nox")
                || buildProduct.lowercase(Locale.getDefault()).contains("nox"))
        if (result) return true
        result = result or (Build.BRAND.startsWith("generic") &&
                Build.DEVICE.startsWith("generic"))
        if (result) return true
        result = result or ("google_sdk" == buildProduct)
        return result
    }

    //условия проверки при запуске
    fun start() {
        if (checkIsEmu() == true || checkAndFetchLink() == true) {
            findNavController().navigate(R.id.action_splashFragment_to_newsFragment)
        }else{
            findNavController().navigate(R.id.action_splashFragment_to_webViewFragment)
        }
    }
}

