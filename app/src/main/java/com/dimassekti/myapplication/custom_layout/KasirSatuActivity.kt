package com.dimassekti.myapplication.custom_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.dimassekti.myapplication.R
import kotlinx.android.synthetic.main.activity_kasir_satu.*
import kotlinx.android.synthetic.main.activity_kasir_satu.view.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class KasirSatuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kasir_satu)

        btn_hitung.setOnClickListener {

            if(et_barang.text.length > 0 && et_jumlah.text.length > 0 && et_harga.text.length > 0){

                val customDialog = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)

                val bayar = customDialog.et_bayar.text.toString()
                val barang = et_barang.text.toString()
                val jumlah = et_jumlah.text.toString()
                val harga = et_harga.text.toString()
                val totalHarga = harga.toInt() * jumlah.toInt()

                customDialog.tv_total_belanja.text = "Total Belanja : ${totalHarga.toString()}"

                val ADBuilder = AlertDialog.Builder(this)
                    .setView(customDialog)
                    .create()


                customDialog.btn_bayar.setOnClickListener {
                    if(customDialog.et_bayar.text.length > 0){
                        val bayar = customDialog.et_bayar.text.toString()
                        val kembalian = bayar.toInt() - totalHarga

                        tv_barang.text = "Barang : $barang"
                        tv_harga.text = "Harga $harga"
                        tv_jumlah.text = "Jumlah : $jumlah"
                        tv_total_harga.text = "Total : ${totalHarga.toString()}"
                        tv_kembalian.text = "Kembalian : ${kembalian.toString()}"
                        ADBuilder.dismiss()
                    }else{
                        customDialog.tv_error_2.setText("Input masih kosong")
                        Toast.makeText(this, "Mohon Masukan Input", Toast.LENGTH_LONG).show()
                    }

                }
                ADBuilder.show()

            }else{
                tv_error.isVisible = true
                tv_error.setText("Input masih kosong")
                Toast.makeText(this, "Mohon Masukan Input", Toast.LENGTH_LONG).show()
            }

            
        }

    }
}