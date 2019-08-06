package com.nemesis.course.completed.activitiesdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import java.io.Serializable

class FaseActivity: AppCompatActivity() {

    enum class SuperSaiyajin: Serializable{
        Fase1,
        Fase2,
        Fase3,
        Fase4;

        fun nextFase(): SuperSaiyajin?{
            return when(this){
                Fase1 -> Fase2
                Fase2 -> Fase3
                Fase3 -> Fase4
                Fase4 -> null
            }
        }
    }

    private var fase:SuperSaiyajin = SuperSaiyajin.Fase1

    private lateinit var gokuSS:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fase)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        gokuSS = findViewById(R.id.goku_ss)

        fase = intent.getSerializableExtra("ss") as SuperSaiyajin
        showFase(fase)

        gokuSS.setOnClickListener {

            val nextFase = fase.nextFase()
            if(nextFase != null) {
                transformTo(nextFase)
            }
        }
    }

    private fun showFase(fase:SuperSaiyajin){
        when(fase){
            SuperSaiyajin.Fase1 -> {
                setTitle(R.string.fase_01)
                gokuSS.setImageResource(R.drawable.goku_ss1)
            }
            SuperSaiyajin.Fase2 -> {
                setTitle(R.string.fase_02)
                gokuSS.setImageResource(R.drawable.goku_ss2)
            }
            SuperSaiyajin.Fase3 -> {
                setTitle(R.string.fase_03)
                gokuSS.setImageResource(R.drawable.goku_ss3)
            }
            SuperSaiyajin.Fase4 -> {
                setTitle(R.string.fase_04)
                gokuSS.setImageResource(R.drawable.goku_ss4)
            }
        }
    }


}