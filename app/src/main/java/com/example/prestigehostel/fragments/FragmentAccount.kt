package com.example.prestigehostel.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.example.prestigehostel.R


/**
 *  created by maxwell takyi on 24 april 2022
 */
class FragmentAccount : Fragment() {


    private lateinit var  webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_account, container, false)
        webView=view.findViewById(R.id.webView)

        // call functions here
        setUpWebView()

        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setUpWebView(){
        val iframe:String="<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3970.3708758137655!2d-0.16943448507216094!3d5.659380634174229!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xfdf9cbd99a1912f%3A0x1cd27d1fdd05b357!2sPrestige%20Hostel%20UPSA!5e0!3m2!1sen!2sgh!4v1650924802694!5m2!1sen!2sgh\" width=\"400\" height=\"200\" style=\"border:0;\" fullscreen=\"\" loading=\"lazy\" referrer's=\"no-referrer-when-downgrade\"></iframe>"
        webView.settings.javaScriptEnabled = true
        webView.loadData(iframe,"text/html", "utf-8")
    }

}