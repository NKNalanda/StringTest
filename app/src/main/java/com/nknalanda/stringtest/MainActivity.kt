package com.nknalanda.stringtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nknalanda.stringtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityMainBinding? = null
    private var stringStack: StringStack? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnSubmit?.setOnClickListener(this)
        stringStack = StringStack()
    }

    override fun onClick(view: View) {
        when (view.id) {
            binding?.btnSubmit?.id -> {
                addToStack()
                binding?.etEnterString?.setText("")
            }
        }
    }

    //To add string into stack
    private fun addToStack() {
        if (!binding?.etEnterString?.text.isNullOrEmpty()) {
            stringStack?.addToRecentString(binding?.etEnterString?.text.toString().trim())
            showRecentStrings()
            showOlderStrings()
        } else {
            binding?.tilEnterString?.error = "String can't be empty."
        }
    }

    //To display recent strings
    private fun showRecentStrings() {
        for ((pos, item) in stringStack?.recentStrings!!.withIndex()) {
            when (pos) {
                0 -> binding?.tvFirstRecentString?.text = item
                1 -> binding?.tvSecondRecentString?.text = item
                else -> {

                }
            }
        }
    }

    //To display older strings
    private fun showOlderStrings() {
        for ((pos, item) in stringStack?.olderStrings!!.withIndex()) {
            when (pos) {
                0 -> binding?.tvFirstOlderString?.text = item
                1 -> binding?.tvSecondOlderString?.text = item
                2 -> binding?.tvThirdOlderString?.text = item
                else -> {

                }
            }
        }
    }
}