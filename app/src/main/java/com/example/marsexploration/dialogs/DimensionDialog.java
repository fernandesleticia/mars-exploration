package com.example.marsexploration.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.marsexploration.R;
import com.example.marsexploration.interfaces.OnDismissListener;

import org.w3c.dom.Text;

public class DimensionDialog extends DialogFragment implements View.OnClickListener
{

    Button buttonOK;
    TextView dimX;
    TextView dimY;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_dimension, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonOK = view.findViewById(R.id.btn_edit_dimension);
        dimX = view.findViewById(R.id.edit_x_dimension);
        dimY = view.findViewById(R.id.edit_y_dimension);

        buttonOK.setOnClickListener(this);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        int dimXDismiss = Integer.valueOf(dimX.getText().toString());
        int dimYDismiss = Integer.valueOf(dimY.getText().toString());
        ((OnDismissListener) getArguments().getParcelable("dismissListener")).dismissed(dimXDismiss, dimYDismiss);
    }

    @Override
    public void onClick(View v) {

    }
}
