package com.example.marsexploration.fragments;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.marsexploration.R;
import com.example.marsexploration.dialogs.DimensionDialog;
import com.example.marsexploration.interfaces.OnDismissListener;

public class MarsFragment extends BaseFragment implements View.OnClickListener {

    Button buttonDimensaoPlanalto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mars_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonDimensaoPlanalto = view.findViewById(R.id.button_add_planalto);
        buttonDimensaoPlanalto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonDimensaoPlanalto) {
            DimensionDialog dialogFragment = new DimensionDialog();
            Bundle arg = new Bundle();
            arg.putParcelable("dismissListener", new OnDismissListener(){

                @Override
                public int describeContents() {
                    return Parcelable.CONTENTS_FILE_DESCRIPTOR;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {

                }

                @Override
                public void dismissed(Object... arg) {

                }
            });
            dialogFragment.setArguments(arg);
            dialogFragment.show(getActivity().getSupportFragmentManager().beginTransaction(), "dialog_dimension");
        }
    }
}
