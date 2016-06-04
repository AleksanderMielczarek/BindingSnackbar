package com.github.aleksandermielczarek.bindingsnackbar;

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aleksander on 20.04.2016.
 */
public class BindingSnackbar {

    private final CharSequence text;
    private final int resId;
    private final int duration;
    private final List<SnackbarSettingsSetter> snackbarSettingsSetters;

    private Snackbar snackbar;

    private BindingSnackbar(Builder builder) {
        text = builder.text;
        resId = builder.resId;
        duration = builder.duration;
        snackbarSettingsSetters = builder.snackbarSettingsSetters;
    }

    public static Builder builder(@NonNull CharSequence text, @Snackbar.Duration int duration) {
        return new Builder(text, duration);
    }

    public static Builder builder(@StringRes int resId, @Snackbar.Duration int duration) {
        return new Builder(resId, duration);
    }

    private void asSnackbar(View view) {
        if (snackbar == null) {
            snackbar = text == null ? Snackbar.make(view, resId, duration) : Snackbar.make(view, text, duration);
            for (SnackbarSettingsSetter settingsSetter : snackbarSettingsSetters) {
                settingsSetter.setSettings(snackbar);
            }
        }
    }

    public void dismiss() {
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    public void show(@NonNull View view) {
        asSnackbar(view);
        snackbar.show();
    }

    public void show(@NonNull ObservableBindingSnackbar observableBindingSnackbar) {
        observableBindingSnackbar.set(this);
    }

    public static final class Builder {

        private CharSequence text;
        private int resId;
        private int duration;
        private List<SnackbarSettingsSetter> snackbarSettingsSetters;

        private Builder(int duration) {
            this.duration = duration;
        }

        private Builder(CharSequence text, int duration) {
            this(duration);
            this.text = text;
        }

        private Builder(int resId, int duration) {
            this(duration);
            this.resId = resId;
        }

        public Builder addSnackbarSettingsSetter(SnackbarSettingsSetter snackbarSettingsSetter) {
            if (snackbarSettingsSetters == null) {
                snackbarSettingsSetters = new ArrayList<>();
            }
            snackbarSettingsSetters.add(snackbarSettingsSetter);
            return this;
        }

        public BindingSnackbar build() {
            if (snackbarSettingsSetters == null) {
                snackbarSettingsSetters = Collections.emptyList();
            }
            return new BindingSnackbar(this);
        }

        public Builder setAction(@StringRes final int resId, final View.OnClickListener listener) {
            return addSnackbarSettingsSetter(new SnackbarSettingsSetter() {
                @Override
                public void setSettings(Snackbar snackbar) {
                    snackbar.setAction(resId, listener);
                }
            });
        }

        public Builder setAction(final CharSequence text, final View.OnClickListener listener) {
            return addSnackbarSettingsSetter(new SnackbarSettingsSetter() {
                @Override
                public void setSettings(Snackbar snackbar) {
                    snackbar.setAction(text, listener);
                }
            });
        }

        public Builder setActionTextColor(final ColorStateList colors) {
            return addSnackbarSettingsSetter(new SnackbarSettingsSetter() {
                @Override
                public void setSettings(Snackbar snackbar) {
                    snackbar.setActionTextColor(colors);
                }
            });
        }

        public Builder setActionTextColor(@ColorInt final int color) {
            return addSnackbarSettingsSetter(new SnackbarSettingsSetter() {
                @Override
                public void setSettings(Snackbar snackbar) {
                    snackbar.setActionTextColor(color);
                }
            });
        }

        public Builder setCallback(final Snackbar.Callback callback) {
            return addSnackbarSettingsSetter(new SnackbarSettingsSetter() {
                @Override
                public void setSettings(Snackbar snackbar) {
                    snackbar.setCallback(callback);
                }
            });
        }

    }
}
