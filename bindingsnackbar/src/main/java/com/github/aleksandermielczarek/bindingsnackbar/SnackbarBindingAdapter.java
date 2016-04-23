package com.github.aleksandermielczarek.bindingsnackbar;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by Aleksander on 23.04.2016.
 */
public class SnackbarBindingAdapter {

    private SnackbarBindingAdapter() {

    }

    @BindingAdapter("snackbar")
    public static void setSnackbar(View view, BindingSnackbar bindingSnackbar) {
        if (bindingSnackbar != null) {
            bindingSnackbar.show(view);
        }
    }
}
