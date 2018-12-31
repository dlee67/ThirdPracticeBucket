package com.example.bob.contentprovideronmyown;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/*
    Implementation copy pasted from:
    https://github.com/codepath/android_guides/wiki/Populating-a-ListView-with-a-CursorAdapter

    Also,
    https://stackoverflow.com/questions/5812030/java-lang-illegalargumentexception-column-id-does-not-exist
    Cursor adapter always requires _id column.
*/
public class CoursesCursorAdapter extends CursorAdapter {

    public CoursesCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.view_holder, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView termView = (TextView) view.findViewById(R.id.term);
        TextView courseView = (TextView) view.findViewById(R.id.course_title);
        TextView finalGradeView = (TextView) view.findViewById(R.id.final_grade);

        String term = cursor.getString(cursor.getColumnIndexOrThrow("Term"));
        String courseTitle = cursor.getString(cursor.getColumnIndexOrThrow("Course_Title"));
        String finalGrade = cursor.getString(cursor.getColumnIndexOrThrow("Final_Grade"));

        termView.setText(term);
        courseView.setText(courseTitle);
        finalGradeView.setText(finalGrade);
    }
}
