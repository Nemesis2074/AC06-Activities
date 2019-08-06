package com.nemesis.course.completed.activitiesdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgGoku: ImageView = findViewById(R.id.goku)
        imgGoku.setOnClickListener {
            transformTo(FaseActivity.SuperSaiyajin.Fase1)
        }
    }
}

fun AppCompatActivity.transformTo(fase:FaseActivity.SuperSaiyajin){
    val intent = Intent(this, FaseActivity::class.java)
    intent.putExtra("ss", fase)
    startActivity(intent)
}
