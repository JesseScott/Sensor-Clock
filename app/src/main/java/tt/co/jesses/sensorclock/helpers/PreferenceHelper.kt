package tt.co.jesses.sensorclock.helpers

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log


class PreferenceHelper(context: Context) {

    private val TAG = PreferenceHelper::class.java.simpleName
    private var mContext: Context = context
    private var preferences: SharedPreferences

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(mContext)
    }

    fun setPrefValueByKey(key: String, value: Boolean) {
        Log.d(TAG, "Setting $key to $value")
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getPrefValueByKey(key: String): Boolean {
        val value = preferences.getBoolean(key, false)
        Log.d(TAG, "Getting preference $key with value $value")
        return value
    }

}