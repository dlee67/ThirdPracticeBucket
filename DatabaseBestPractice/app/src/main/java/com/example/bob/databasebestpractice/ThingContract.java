package com.example.bob.databasebestpractice;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/*
    Contract classes are purposed to hold the constants,
    which makes the interaction between the application and the
    data persistent capabilities.
*/
// The class is declared final because it only holds constants.
public final class ThingContract {

    public ThingContract(){}

    public static final class ThingEntry implements BaseColumns{
        public static final String CONTENT_AUTHORITY = "com.example.bob.databasebestpractice";
        public final static String PATH_NAME = "Things";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(
                BASE_CONTENT_URI, PATH_NAME
                );

        public final static String TABLE_NAME = "Things";
                      
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_THING_NAME = "name";

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NAME;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NAME;
    }
}