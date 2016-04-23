package com.github.aleksandermielczarek.bindingsnackbarexample;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.github.aleksandermielczarek.bindingsnackbar.BindingSnackbar;
import com.github.aleksandermielczarek.bindingsnackbar.ObservableBindingSnackbar;

/**
 * Created by Aleksander on 23.04.2016.
 */
public class MainViewModel {

    public final ObservableBindingSnackbar snackbar = new ObservableBindingSnackbar();

    public View.OnClickListener getShowSnackbar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BindingSnackbar.builder("BindingSnackbar", Snackbar.LENGTH_SHORT)
                        .build()
                        .show(snackbar);
            }
        };
    }
}
