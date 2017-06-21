package tt.co.jesses.sensorclock

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import tt.co.jesses.sensorclock.helpers.PreferenceHelper

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
            val preferenceHelper = PreferenceHelper(context)
            preferenceHelper.setPrefValueByKey(context.getString(R.string.user_has_seen_onboarding), true)
        }
    }

}