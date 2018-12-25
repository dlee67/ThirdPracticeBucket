package com.example.bob.contentprovideronmyown;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.bob.contentprovideronmyown.CoursesContract.get;

public class CoursesProvider extends ContentProvider{

    private CoursesHelper dbHelper;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int FINAL_GRADES = 100;

    static{
        uriMatcher.addURI(
                get.AUTHORITY,
                get.FINAL_GRADES_TABLE,
                FINAL_GRADES);
    }

    @Override
    public boolean onCreate() {
        this.dbHelper = new CoursesHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        Cursor cursor;

        int match = uriMatcher.match(uri);
        switch (match){
            case FINAL_GRADES:
                cursor = db.query(
                        get.FINAL_GRADES_TABLE,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final int match = uriMatcher.match(uri);
        Log.i("dhl", "match got: " + match);
        switch (match){
            case FINAL_GRADES:
                // Was previously the line below:
                // insertValues(uri, values);
                // The above is critical failure because switch statements won't stop executing
                // unless there is a return, or a break statement.
                return insertValues(uri, values);
            default:
                insertValues(uri, values);
                throw new IllegalArgumentException
                ("Insertion is not supported for: " + uri);
        }

    }

    private Uri insertValues(Uri uri, ContentValues values)
    {
        String term = values.getAsString(get.COLUMN_TERM);
        String course = values.getAsString(get.COLUMN_COURSE);
        String finalGrade = values.getAsString(get.COLUMN_FINAL_GRADE);

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        long id = database.insert(get.FINAL_GRADES_TABLE, null, values);
        if(id == -1){
            Log.e("dhl", "Failed to insert row for " + uri);
            return null;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
