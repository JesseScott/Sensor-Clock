package tt.co.jesses.sensorclock

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import tt.co.jesses.sensorclock.fragments.FileChooserDialogFragment
import tt.co.jesses.sensorclock.fragments.TimePickerDialogFragment
import tt.co.jesses.sensorclock.helpers.PreferenceHelper


class MainActivity: Activity() {

    private val TAG = MainActivity::class.simpleName
    private val PICK_FILE = 1

    private lateinit var context: Context
    private lateinit var CHOSEN_TYPE : WEATHER

    // region - overrides

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        context = applicationContext

        val alarmTime: TextView = findViewById(R.id.tv_main_edit_alarm) as TextView
        val preferenceHelper = PreferenceHelper(context)
        var presetTime: String = preferenceHelper.getPrefStringValueByKey(context.getString(R.string.user_alarm_time))
        if (TextUtils.isEmpty(presetTime)) {
            presetTime = context.getString(R.string.user_alarm_time_default)
        }
        alarmTime.text = presetTime

        val btnEdit: ImageButton = findViewById(R.id.ib_main_edit_alarm) as ImageButton
        btnEdit.setOnClickListener {
            Log.d(TAG, "Edit Time")
            launchTimePickerDialog();
        }

        val btnCloud : ImageButton = findViewById(R.id.ib_main_row_state_cloudy) as ImageButton
        btnCloud.setOnClickListener {
            Log.d(TAG, "CLOUD")
            CHOSEN_TYPE = WEATHER.CLOUD
            createFileChooserDialog("cloudy")
        }

        val btnRain : ImageButton = findViewById(R.id.ib_main_row_state_rainy) as ImageButton
        btnRain.setOnClickListener {
            Log.d(TAG, "RAIN")
            CHOSEN_TYPE = WEATHER.RAIN
            createFileChooserDialog("rainy")
        }

        val btnSnow : ImageButton = findViewById(R.id.ib_main_row_state_snowy) as ImageButton
        btnSnow.setOnClickListener {
            Log.d(TAG, "SNOW")
            CHOSEN_TYPE = WEATHER.SNOW
            createFileChooserDialog("snowy")
        }

        val btnSun : ImageButton = findViewById(R.id.ib_main_row_state_sunny) as ImageButton
        btnSun.setOnClickListener {
            Log.d(TAG, "SUN")
            CHOSEN_TYPE = WEATHER.SUN
            createFileChooserDialog("sunny")
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (PICK_FILE == requestCode) {
            if (null != data) {
                val uri = data.data
                Log.d(TAG, "Picked $uri")
                setPathForFile(uri)
            } else {
                Log.d(TAG, "Nothing was picked...")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                Log.d(TAG, "Settings selected")
                startActivity(Intent(context, SettingsActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    // endregion

    // region - public methods

    fun onLocalFileChosen() {
        Log.d(TAG, "onLocalFileChosen")

        val mediaIntent = Intent(Intent.ACTION_GET_CONTENT)
        mediaIntent.type = "audio/*"
        startActivityForResult(mediaIntent, PICK_FILE)
    }

    fun onRemoteFileChosen() {
        Log.d(TAG, "onRemoteFileChosen")
    }

    // endregion

    // region - internal methods

    internal fun createFileChooserDialog(type: String) {
        val dialog = FileChooserDialogFragment().newInstance(type)
        dialog.show(this.fragmentManager, "chooser")
    }

    internal fun launchTimePickerDialog() {


//        val time = Calendar.getInstance()
//        val hour = time.get(Calendar.HOUR_OF_DAY)
//        val minute = time.get(Calendar.MINUTE)
//        val mTimePicker: TimePickerDialog
//        val mTimeSetListener = TimePickerDialog.OnTimeSetListener({ _, hourOfDay, minute -> onTimeSetListener(hourOfDay, minute) })
//
//        mTimePicker = TimePickerDialog(context, mTimeSetListener, hour, minute, true)
//        mTimePicker.setTitle("Select Time")
//        mTimePicker.show()


        val listener = TimePickerDialog.OnTimeSetListener({ _, hourOfDay, minute -> onTimeSetListener(hourOfDay, minute) })
        val dialog = TimePickerDialogFragment().newInstance(listener)
        dialog.show(this.fragmentManager, "chooser")
    }

    internal fun onTimeSetListener(hour: Int, minute: Int) {
        Log.d(TAG, "Time Set: $hour : $minute")
    }

    internal fun setPathForFile(data: Uri) {
        Log.d(TAG, "Setting path for Weather Type $CHOSEN_TYPE to $data")

        var type: String = ""
        when(CHOSEN_TYPE) {
            WEATHER.CLOUD -> type = context.getString(R.string.song_path_cloudy)
            WEATHER.RAIN -> type = context.getString(R.string.song_path_rainy)
            WEATHER.SNOW -> type = context.getString(R.string.song_path_snowy)
            WEATHER.SUN -> type = context.getString(R.string.song_path_sunny)
        }

        val preferenceHelper = PreferenceHelper(context)
        preferenceHelper.setPrefStringValueByKey(type, data.toString())

    }

    // endregion

    // region - enum

    enum class WEATHER {
        CLOUD, RAIN, SNOW, SUN
    }

    // endregion

}