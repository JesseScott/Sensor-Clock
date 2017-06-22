package tt.co.jesses.sensorclock.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.util.Log
import tt.co.jesses.sensorclock.R


class FileChooserDialogFragment : DialogFragment() {

    private val TAG = FileChooserDialogFragment::class.simpleName
    private var type: String = "the"

    fun newInstance(type: String): FileChooserDialogFragment {
        val f = FileChooserDialogFragment()

        val args = Bundle()
        args.putString("type", type)
        f.arguments = args

        return f
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        if (null != arguments && arguments.containsKey("type")) {
            type = arguments.getString("type")
            val res = resources
            val title = String.format(res.getString(R.string.pick_file), type)

            val builder = AlertDialog.Builder(activity)
            builder.setTitle(title)
                    .setItems(R.array.filetype_array, { _, which ->
                        Log.d(TAG, "Chose $which which matches to ")
                    })
                    .setNegativeButton(android.R.string.cancel, { _, _ ->
                        // User cancelled the dialog
                        Log.d(TAG, "Cancelled... ")
                    })
            return builder.create()
        } else {
            return super.onCreateDialog(savedInstanceState)
        }
    }

}