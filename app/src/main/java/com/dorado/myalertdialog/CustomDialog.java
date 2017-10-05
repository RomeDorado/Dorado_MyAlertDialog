package com.dorado.myalertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Simon on 10/5/2017.
 */

public class CustomDialog extends DialogFragment {

    LayoutInflater inflater;
    View view;
    EditText et_Username;
    EditText et_Password;

    //generate override methods
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.login_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                et_Username = view.findViewById(R.id.etUsername);
                et_Password = view.findViewById(R.id.etUsername);
                String user = et_Username.getText().toString();
                String pass = et_Password.getText().toString();
                String msg = "Username is " + user + " Password is " + pass;

                Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setTitle("Login");

        Dialog dialog = builder.create();
        return dialog;
    }
}
