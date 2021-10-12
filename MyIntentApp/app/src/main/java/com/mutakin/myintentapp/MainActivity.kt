package com.mutakin.myintentapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.mutakin.myintentapp.models.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    @SuppressLint("SetTextI18n")
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
                val selectedValue =
                    result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }


    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){uri: Uri? -> getContentCallback(uri)}

    private fun getContentCallback(uri: Uri?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tv_result)
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)
        val btnMoveWithObjectActivity: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObjectActivity.setOnClickListener(this)
        val btnDialNumber: Button = findViewById(R.id.btn_dial)
        btnDialNumber.setOnClickListener(this)
        val btnForResultActivity: Button = findViewById(R.id.btn_for_result)
        btnForResultActivity.setOnClickListener(this)
        val btnPickImage: Button = findViewById(R.id.btn_pick_image)
        btnPickImage.setOnClickListener(this)
        val btnToImagePicker: Button = findViewById(R.id.btn_to_image_picker_activity)
        btnToImagePicker.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                startActivity(
                    Intent(
                        this,
                        MoveActivity::class.java
                    )
                )
            }
            R.id.btn_move_activity_data -> {
                startActivity(Intent(
                    this,
                    MoveWithDataActivity::class.java
                ).apply {
                    putExtra(MoveWithDataActivity.EXTRA_NAME, "Mutakin")
                    putExtra(MoveWithDataActivity.EXTRA_AGE, 21)
                })
            }
            R.id.btn_move_activity_object -> {
                startActivity(Intent(
                    this,
                    MoveWithDataActivity::class.java
                ).apply {
                    val person = Person(
                        name = "Mutakin",
                        age = 21,
                        email = "mutakin.email@gmail.com",
                        city = "Tasikmalaya"
                    )
                    putExtra(MoveWithDataActivity.EXTRA_DATA, person)
                })
            }
            R.id.btn_dial -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:085794739280"))

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "There is no application to handle your action",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            R.id.btn_for_result -> {
                val moveForResultIntent = Intent(this, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
            R.id.btn_pick_image -> {
                getContent.launch("image/*")
            }

            R.id.btn_to_image_picker_activity -> {
            }



        }
    }
}