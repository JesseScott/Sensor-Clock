package tt.co.jesses.sensorclock.helpers

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import tt.co.jesses.sensorclock.receivers.AlarmReceiver

/**
 *
 * Created by jessescott on 2017-06-30.
 *
 */

class AlarmHelper(private val mContext: Context) {

    private val TAG = AlarmHelper::class.java.simpleName


    private val mPreferenceHelper: PreferenceHelper = PreferenceHelper(mContext)
    private val mAlarmIntent: PendingIntent
    private val mAlarmManager: AlarmManager

    init {
        val intent = Intent(mContext, AlarmReceiver::class.java)
        mAlarmIntent = PendingIntent.getBroadcast(mContext, 0, intent, 0)
        mAlarmManager = mContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    fun setAlarm() {

        // Test to see if we've already set recurring daytime alarms AND/OR if we have enabled them
//        val daytimeEnabled = mPreferenceHelper.getPrefBooleanValueByKey(mContext.getString(R.string.prefs_enable_daytime_alarms))
//        val daytimeSet = mPreferenceHelper.getPrefBooleanValueByKey(mContext.getString(R.string.prefs_daytime_set))
//        if (!daytimeSet && daytimeEnabled) {
//            for (calendar in mCalendarHelper.calendarsDaytime) {
//                calendar?.timeInMillis?.let { mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, it, AlarmManager.INTERVAL_DAY, mAlarmIntent) }
//            }
//            // Set the Preferences
//            mPreferenceHelper.setPrefValueByKey(mContext.getString(R.string.prefs_daytime_set), true)
//        }






    }

}