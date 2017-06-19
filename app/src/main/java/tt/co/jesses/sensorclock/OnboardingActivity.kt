package tt.co.jesses.sensorclock

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Button

/**
 * Created by jessescott on 2017-06-19.
 */




class OnboardingActivity: Activity() {

    private val TAG = OnboardingActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_onboarding)

        val context: Context = applicationContext

        var onboardingButton = findViewById(R.id.btn_onboarding_button) as Button
        onboardingButton.setOnClickListener {
            Log.d(TAG, "CLICK")
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            val key = context.getString(R.string.user_has_seen_onboarding)
            val editor = preferences.edit()
            editor.putBoolean(key, true)
            editor.apply()
        }
    }

}