package tt.co.jesses.sensorclock

import android.os.Bundle
import android.preference.PreferenceActivity

/**
 * Created by jessescott on 2017-06-20.
 */


class SettingsActivity : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager.beginTransaction()
                .replace(android.R.id.content, SettingsFragment())
                .commit()

        //FirebaseAnalytics.getInstance(this.applicationContext).setCurrentScreen(this@SettingsActivity, "SettingsActivity", SettingsActivity::class.java.simpleName)

    }

}