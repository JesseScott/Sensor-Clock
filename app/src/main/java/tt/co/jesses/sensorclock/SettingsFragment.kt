package tt.co.jesses.sensorclock

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.CheckBoxPreference
import android.preference.PreferenceFragment

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
        if (null != preference && preference is CheckBoxPreference) {
            //val preferenceHelper = PreferenceHelper(activity.applicationContext)
            //preferenceHelper.setPrefValueByKey(key, preference.isChecked)
        }
    }

}