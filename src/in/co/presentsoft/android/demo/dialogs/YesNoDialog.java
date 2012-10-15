package in.co.presentsoft.android.demo.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: anay
 * Date: 15/10/12
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class YesNoDialog extends DialogFragment {

    private String dialogMessage;

    private OnDialogOptionSelected onYesSelected;
    private OnDialogOptionSelected onNoSelected;

    public YesNoDialog(String dialogMessage) {
        this.dialogMessage = dialogMessage;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(this.dialogMessage)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (onYesSelected != null)
                            onYesSelected.executeTask();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (onNoSelected != null)
                            onNoSelected.executeTask();
                    }
                });

        return builder.create();
    }

    public void setOnYesSelectedListener(OnDialogOptionSelected onYesSelected) {
        this.onYesSelected = onYesSelected;
    }

    public void setOnNoSelectedListener(OnDialogOptionSelected onNoSelected) {
        this.onNoSelected = onNoSelected;
    }
}
