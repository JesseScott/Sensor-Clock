package tt.co.jesses.sensorclock.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceFragment
import tt.co.jesses.sensorclock.R

/**
 * Created by jessescott on 2017-06-20.
 */


class SettingsFragment : PreferenceFragment(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.preferences)
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences
                .registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences
                .unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        val preference = findPreference(key)
    }

}