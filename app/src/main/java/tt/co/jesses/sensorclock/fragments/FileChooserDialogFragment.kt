package tt.co.jesses.sensorclock.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.util.Log
import tt.co.jesses.sensorclock.R


class FileChooserDialogFragment : DialogFragment() {

    private val TAG = FileChooserDialogFragment::class.simpleName

    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        val builder = AlertDialog.Builder(activity.applicationContext)
        builder.setTitle(R.string.pick_file)
                .setItems(R.array.filetype_array, { _, which ->
                    Log.d(TAG, "Chose $which which matches to ")
                })
                .setNegativeButton(android.R.string.cancel, { _, _ ->
                    // User cancelled the dialog
                    Log.d(TAG, "Cancelled... ")
                })
        return builder.create()
    }

}