package com.demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.activityBtn -> {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra(IntentConstants.KEY_NAME, binding.nameEdt.text.toString())
                intent.putExtra(IntentConstants.KEY_AGE, binding.ageEdt.text.toString())
                startActivityForResult(intent, IntentConstants.REQUEST_CODE_ACTIVITY)
            }
        }
    }

    @Deprecated(
        "Deprecated in Java", ReplaceWith(
            "super.onActivityResult(requestCode, resultCode, data)",
            "androidx.appcompat.app.AppCompatActivity"
        )
    )
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IntentConstants.REQUEST_CODE_ACTIVITY) {

            if ( data != null) {
                binding.nameEdt.setText(intent?.extras?.getString(IntentConstants.KEY_NAME))
                binding.ageEdt.setText(intent?.extras?.getString(IntentConstants.KEY_AGE))
            }
        }
        Log.e("Request code", requestCode.toString())
        Log.e("Result code", resultCode.toString())
    }
}