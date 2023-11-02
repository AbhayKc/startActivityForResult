package com.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val name = intent?.extras?.getString(IntentConstants.KEY_NAME)
        binding.nameEdt.setText(name)
        binding.ageEdt.setText(intent?.extras?.getString(IntentConstants.KEY_AGE))

        binding.activityBtn.setOnClickListener {
            val intent = Intent()
            intent.putExtra(IntentConstants.KEY_NAME,binding.nameEdt.text.toString())
            intent.putExtra(IntentConstants.KEY_AGE,binding.ageEdt.text.toString())
            setResult(IntentConstants.REQUEST_CODE_ACTIVITY,intent)
            finish()

        }
    }

}