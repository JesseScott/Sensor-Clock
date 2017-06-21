package tt.co.jesses.sensorclock

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton


class MainActivity: Activity() {

    private val TAG = MainActivity::class.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val btnCloud : ImageButton = findViewById(R.id.ib_main_row_state_cloudy) as ImageButton
        btnCloud.setOnClickListener {
            Log.d(TAG, "CLOUD")
        }

        val btnRain : ImageButton = findViewById(R.id.ib_main_row_state_rainy) as ImageButton
        btnRain.setOnClickListener {
            Log.d(TAG, "RAIN")
        }

        val btnSnow : ImageButton = findViewById(R.id.ib_main_row_state_snowy) as ImageButton
        btnSnow.setOnClickListener {
            Log.d(TAG, "SNOW")
        }

        val btnSun : ImageButton = findViewById(R.id.ib_main_row_state_sunny) as ImageButton
        btnSun.setOnClickListener {
            Log.d(TAG, "SUN")
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
                startActivity(Intent(this.applicationContext, SettingsActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}