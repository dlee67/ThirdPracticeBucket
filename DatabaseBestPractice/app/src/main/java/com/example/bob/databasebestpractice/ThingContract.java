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

    /*
        URI's structure is organized in this manner.
        content://authority/path/<id_value>
        Schema and the authority are obvious in what they are,
        but path is actually for the table name,
        and the id_value is something that's automatically assigned to the rows upon insertion?
        The above, I gotta experiment more.

        In the codebase below, notice how TABLE_NAME is exactly the same with PATH_NAME.
        https://developer.android.com/guide/topics/providers/content-provider-basics#ContentURIs
        My intuition was right; the resolver does look up the provider by referring to the
        Uri that was passed in.
    */
    //      BaseColumns exists for the sake of this API called CursorAdapter,
    //      which needs _ID and _COUNT.
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

        // I have no idea why the below two exists.
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NAME;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NAME;
    }
}