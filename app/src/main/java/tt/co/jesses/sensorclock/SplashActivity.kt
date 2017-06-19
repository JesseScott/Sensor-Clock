package tt.co.jesses.sensorclock

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log


class SplashActivity : Activity() {

    private val TAG = SplashActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val context: Context = applicationContext

        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val hasOnboarded = preferences.getBoolean(context.getString(R.string.user_has_seen_onboarding), false)

        //val timer: Thread

        val timer = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2500)

                    var intent: Intent
                    if (hasOnboarded) {
                        intent = Intent(context, MainActivity::class.java)
                    } else {
                        intent = Intent(context, OnboardingActivity::class.java)
                    }
                    startActivity(intent)
                    finish()
                } catch (e: InterruptedException) {
                    Log.d(TAG, "Error: " + e.localizedMessage)
                }

            }
        }
        timer.start()





    }



}
