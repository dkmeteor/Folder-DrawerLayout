# Not Completed yet.

# Demo
![Demo](https://raw.githubusercontent.com/dkmeteor/Folder-DrawerLayout/master/gif/Folder-DrawerLayout.gif)
# How to use

I copied the code of `android.support.v4.widget.DrawerLayout` and add new effects on it.
So you can use it just as if it is `android.support.v4.widget.DrawerLayout`. All method, Interface, Callback are same.

example xml:

    <com.dk.view.FolderDrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/drawer_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#c0c0c0" >

        <!-- The main content view -->

        <FrameLayout
            android:id="@+id/content_frame"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
        
        <!-- The navigation drawer -->
    
        <LinearLayout
            android:id="@+id/left_drawer"
            android:layout_width="240dp"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            android:orientation="vertical" >
    
            <LinearLayout
                android:id="@+id/left_drawer_sub"
                android:layout_width="240dp"
                android:layout_height="match_parent"
                android:background="#ffffff"
                android:orientation="vertical" >
    
    
                <!- Views you want use in Drawer ->
                   <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="something" />

                <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="something" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Dean Ding \n 93440331@qq.com" />
    
            </LinearLayout>
        </LinearLayout>
    </com.dk.view.FolderDrawerLayout>


#Tips
- `left_drawer` can only have one child view. if you want to add more than one subview, please see the example above.
- The `left_drawer_sub` 's backgroud color should not be transparent. 
- It is now only support `LeftDrawer`.

#TODO

- I considered the effect is not nature. But I have no idea how to make it more smooth.
- As soon as I decide how to change it, I will soon make it available for RightDrawer and .

# License
Copyright (c) 2015 [Dean Ding](http://dk-exp.com)

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)