package com.dimassekti.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimassekti.myapplication.custom_layout.KasirSatuActivity
import com.dimassekti.myapplication.dialog_fragment.KasirDuaActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_kasir.setOnClickListener {
            val pindah = Intent(this, KasirSatuActivity::class.java)
            startActivity(pindah)
        }

        btn_kasir_fragment.setOnClickListener {
            val pindah = Intent(this, KasirDuaActivity::class.java)
            startActivity(pindah)
        }

    }

}