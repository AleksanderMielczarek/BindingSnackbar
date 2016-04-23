# BindingSnackbar

Library simplifying usage of Snackbar with [Android Data Binding](http://developer.android.com/tools/data-binding/guide.html).

## Usage

## Example

```java
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
```

```xml
<Button
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:snackbar="@{viewModel.snackbar}" />
```

Yoy can use builder to specify snackbar settings. 

```java
BindingSnackbar snackbar = BindingSnackbar.builder("BindingSnackbar", Snackbar.LENGTH_SHORT)
        .setAction("BindingSnackbarAction", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do some snackbar action
            }
        })
        .addSnackbarSettingsSetter(new SnackbarSettingsSetter() {
            @Override
            public void setSettings(Snackbar snackbar) {
                //do sth with snackbar
            }
        })
        .build();       
```

It can be also used standalone without databinding.

```java
View view = findViewById(R.id.myView);
BindingSnackbar.builder("BindingSnackbar", Snackbar.LENGTH_SHORT)
        .build()
        .show(view);    
```

## License

    Copyright 2016 Aleksander Mielczarek

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.