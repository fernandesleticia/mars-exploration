package com.example.marsexploration.interfaces;

import android.os.Parcelable;

public interface OnDismissListener extends Parcelable {
    void dismissed(Object...arg);
}
