/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.githubrepolist.ui.activities

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import api.RepositoryRetriever
import com.raywenderlich.githubrepolist.R
import com.raywenderlich.githubrepolist.data.RepoResult
import com.raywenderlich.githubrepolist.ui.adapters.RepoListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import com.raywenderlich.githubrepolist.data.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
  Got it from: https://www.raywenderlich.com/2-android-networking-tutorial-getting-started

  I haven't gotten into a portion where they start talking about Retrofit; non-the less,
  I should come back to the above link to study everything the writer wrote
  step by step, carefully.

  I have a conviction that the above tutorial covers a lot those are unique to Kotlin.
*/
class MainActivity : Activity() {

  private val repoRetriever = RepositoryRetriever() // 1

  // 2
  private val callback = object : Callback<RepoResult> {
    override fun onFailure(call: Call<RepoResult>?, t: Throwable?) {
      Log.e("MainActivity", "Problem calling Github API", t)
    }

    override fun onResponse(call: Call<RepoResult>?, response: Response<RepoResult>?) {
      response?.isSuccessful.let {
        val resultList = RepoResult(response?.body()?.items ?: emptyList())
        repoList.adapter = RepoListAdapter(resultList)
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    repoList.layoutManager = LinearLayoutManager(this)

    val url = "https://api.github.com/search/repositories?q=mario+language:kotlin&sort=stars&order=desc"
    // The doAsync is a DSL, provided by Anko library of Kotlin.
    // Culturally, it seems like Anko library is one way for Jetbrain to patch up
    // a lot of the things programmers hated about Java.
    if (isNetworkConnected()) {
      repoRetriever.getRepositories(callback)
    } else {
      AlertDialog.Builder(this).setTitle("No Internet Connection")
              .setMessage("Please check your internet connection and try again")
              .setPositiveButton(android.R.string.ok) { _, _ -> }
              .setIcon(android.R.drawable.ic_dialog_alert).show()
    }

    refreshButton.setOnClickListener {
      repoRetriever.getRepositories(callback)
    }
  }

  private fun isNetworkConnected(): Boolean {
    //https://developer.android.com/reference/android/net/ConnectivityManager
    //Not sure what the below line does.
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager //1
    //The tutorial says this represents the connection of the program to the network.
    //Not sure how.
    val networkInfo = connectivityManager.activeNetworkInfo //2
    //Returns a boolean, after checking if there is a connection or not.
    return networkInfo != null && networkInfo.isConnected //3
  }
}
