## 12/24/18
Inserting elements to the table works, I think.
After inserting an element once, and displaying the results via query, only one element shows.
After inserting an element twice, two elements show up.
After inserting an element three times, three elements show up.
After inserting an element four times, or more, program crashes.
Hmmmm.......
https://stackoverflow.com/questions/21823621/failed-to-read-row-0-column-4-from-cursorwindow-which-has-1-row-and-4-columns
Referring the above currently.

No, fixed whatever problem that I had before; for the codebase in displayResult(),
I replaced with:

while(cursor.moveToNext()){
	for(int index = 0; index < cursor.getColumnCount(); index++) {
   	Log.i("dhl", cursor.getString(index));
   }
}

## 12/30/18
I never knew I can open up a Vim via Android Studio's terminal.

Anyways, gonna start learning bits and pieces about the CursorLoader.
