package tt.co.jesses.sensorclock.fragments

import android.app.Dialog
import android.app.DialogFragment
import android.app.TimePickerDialog
import android.os.Bundle
import java.util.*

/**
 *
 * Created by jessescott on 2017-07-11.
 *
 */


class TimePickerDialogFragment : DialogFragment() {

    private val TAG = TimePickerDialogFragment::class.simpleName
    private lateinit var onTimeSetListener: TimePickerDialog.OnTimeSetListener


    fun newInstance(listener: TimePickerDialog.OnTimeSetListener): TimePickerDialogFragment {
        val f = TimePickerDialogFragment()
        this.onTimeSetListener = listener
        return f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //onTimeSetListener =
    }

    init {
        onTimeSetListener =
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)


        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog: TimePickerDialog
        val mTimeSetListener = TimePickerDialog.OnTimeSetListener({ _, _, _ -> onTimeSetListener })

        timePickerDialog = TimePickerDialog(activity, mTimeSetListener, hour, minute, true)
        timePickerDialog.setTitle("Select Time")
        return timePickerDialog
    }
}