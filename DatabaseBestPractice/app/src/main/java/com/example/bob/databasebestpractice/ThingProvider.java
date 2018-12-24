package com.example.bob.databasebestpractice;

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

import com.example.bob.databasebestpractice.ThingContract.ThingEntry;

/*
    Thinking about the ContentProvider again, it's actually kinda neat.
    The reason is because ContentProvider is essentially just a Uri matcher,
    and Uri matcher, in my opinion, is much more graceful way to supply the application
    with the needed resources.

    The Uri matcher entirely gets rid of the coupling of codebase to codebase.
*/
public class ThingProvider extends ContentProvider{

    private ThingHelper dbHelper;

    //UriMatch really just exists for the sake of convenience (and a standard).
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int THINGS = 100;

    private static final int THING_ID = 101;

    static
    {
        //Where expected Uri the needs to be specified before hand, before any of the CRUD
        //operation happens.
        sUriMatcher.addURI(ThingEntry.CONTENT_AUTHORITY, ThingEntry.PATH_NAME, THINGS);
        sUriMatcher.addURI(ThingEntry.CONTENT_AUTHORITY, ThingEntry.PATH_NAME + "/#", THING_ID);
    }

    @Override
    public boolean onCreate() {
        this.dbHelper = new ThingHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(
            @NonNull Uri uri,
            @Nullable String[] projection,
            @Nullable String selection,
            @Nullable String[] selectionArgs,
            @Nullable String sortOrder)
    {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch (match) {
            case THINGS:
                cursor = database.query(
                        ThingEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case THING_ID:
                selection = ThingEntry._ID + "=?";
                selectionArgs = new String[]
                        { String.valueOf(ContentUris.parseId(uri))};

                cursor = database.query(
                        ThingEntry.TABLE_NAME,
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
        // The line below, like, attaches some sort of a listener?
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case THINGS:
                return ThingEntry.CONTENT_LIST_TYPE;
            case THING_ID:
                return ThingEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case THINGS:
                return insertThing(uri, values);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }

    private Uri insertThing(Uri uri, ContentValues values)
    {
        String name = values.getAsString(ThingEntry.COLUMN_THING_NAME);
        if(name == null){
            throw new IllegalArgumentException("This thing does not have a name.");
        }

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        long id = database.insert(ThingEntry.TABLE_NAME, null, values);
        if(id == -1){
            Log.e("dhl", "Failed to insert row for " + uri);
            return null;
        }

        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        int rowsDeleted;

        final int match = sUriMatcher.match(uri);
        switch (match){
            case THINGS:
                rowsDeleted = database.delete(ThingEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case THING_ID:
                selection = ThingEntry._ID + "=?";
                selectionArgs = new String[]{ String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted = database.delete(ThingEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not supported for: " + uri);
        }

        if(rowsDeleted != 0){
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsDeleted;
    }

    @Override
    public int update(
            @NonNull Uri uri,
            @Nullable ContentValues values,
            @Nullable String selection,
            @Nullable String[] selectionArgs)
    {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case THINGS:
                return updateThing(uri, values, selection, selectionArgs);
            case THING_ID:
                selection = ThingEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri))};
                return updateThing(uri, values, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update not supported for " + uri);
        }
    }

    private int updateThing(
            Uri uri,
            ContentValues values,
            String selection,
            String[] selectionArgs)
    {
        if(values.containsKey(ThingEntry.COLUMN_THING_NAME)){
            String name = values.getAsString(ThingEntry.COLUMN_THING_NAME);
            if(name == null){
                throw new IllegalArgumentException("Thing requires name.");
            }
        }

        if(values.size() == 0){
            return 0;
        }

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        int rowsUpdated = database.update(ThingEntry.TABLE_NAME, values, selection, selectionArgs);

        if(rowsUpdated != 0){
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsUpdated;
    }
}
