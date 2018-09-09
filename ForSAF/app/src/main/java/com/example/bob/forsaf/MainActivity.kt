package com.example.bob.forsaf

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.provider.DocumentFile
import android.util.Log
import com.beust.klaxon.Klaxon
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    val READ_REQUEST_CODE = 111

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("dhl", "Attempting to pull SAF.")

        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        intent.type = "*/*"
        startActivityForResult(intent, READ_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Log.i("dhl", "Inside the onActivityResult.")
            var jsonInString = fileToString(data.data)
            Log.i("dhl", "jsonInString is: " + jsonInString)
        }
    }

    fun fileToString(resultData: Uri): String{
        //Since, Kotlin doesn't have a primitive type.
        //https://discuss.kotlinlang.org/t/java-byte-and-kotlin-bytearray-question/1065/2
        //https://developer.android.com/guide/topics/providers/document-provider
        val inputStream = contentResolver.openInputStream(resultData)
        val reader = BufferedReader(InputStreamReader(
                inputStream!!))
        val stringBuilder = StringBuilder()
        var line: String? = reader.readLine()
        while (line != null) {
            stringBuilder.append(line)
            line = reader.readLine()
        }
        inputStream.close()
        reader.close()
        return stringBuilder.toString()
    }
}
