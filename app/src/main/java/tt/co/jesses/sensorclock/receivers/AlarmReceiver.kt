package tt.co.jesses.sensorclock.receivers

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v7.app.NotificationCompat

import android.util.Log
import tt.co.jesses.sensorclock.NotificationActivity
import tt.co.jesses.sensorclock.R

/**
 *
 * Created by jessescott on 2017-06-30.
 *
 */

class AlarmReceiver : BroadcastReceiver() {

    private val TAG = AlarmReceiver::class.java.simpleName

    override fun onReceive(context: Context, intent: Intent) {

        Log.d(TAG, "Received Intent: " + intent.dataString)

        val notificationIntent = Intent(context, NotificationActivity::class.java)

        val stackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addParentStack(NotificationActivity::class.java)
        stackBuilder.addNextIntent(notificationIntent)

        val pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context)
        val notification = builder
                .setContentTitle(context.getString(R.string.receiver_title))
                .setContentText(context.getString(R.string.receiver_text))
                .setTicker(context.getString(R.string.receiver_ticker))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setCategory(Notification.CATEGORY_ALARM)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                //.setStyle(inboxStyle)
                .build()

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notification)

    }

}