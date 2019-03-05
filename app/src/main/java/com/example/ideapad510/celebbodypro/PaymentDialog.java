package com.example.ideapad510.celebbodypro;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class PaymentDialog extends DialogFragment {


    public static PaymentDialog newInstance(int title) {
        PaymentDialog frag = new PaymentDialog();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setMessage("برای دسترسی به این محتوا فقط برای کاربران ویژه امکان پذیر می باشد")
                .setPositiveButton("ارتقا به کاربر ویژه", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton("بستن", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }


}
