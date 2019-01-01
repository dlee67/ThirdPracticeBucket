package com.example.bob.contentprovideronmyown;

import android.net.Uri;
import android.provider.BaseColumns;

public class CoursesContract {

    // The below prevents an instantiation.
    private CoursesContract(){
        throw new UnsupportedOperationException();
    }

    public static final class get implements BaseColumns{
        public static final String AUTHORITY = "com.example.bob.contentprovideronmyown";
        public static final String FINAL_GRADES_TABLE = "Final_Grades";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
        public static final Uri FINAL_GRADES_URI = Uri.withAppendedPath(BASE_CONTENT_URI, FINAL_GRADES_TABLE);
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_TERM = "Term";
        public static final String COLUMN_COURSE = "Course_Title";
        public static final String COLUMN_FINAL_GRADE = "Final_Grade";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " +
                FINAL_GRADES_TABLE +
                " (" +
                _ID + ", " +
                COLUMN_TERM + ", " +
                COLUMN_COURSE + ", " +
                COLUMN_FINAL_GRADE +
                ");";
    }
}
