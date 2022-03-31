package com.dimassekti.myapplication.dialog_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import com.dimassekti.myapplication.R
import kotlinx.android.synthetic.main.activity_kasir_dua.*


class KasirDuaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kasir_dua)

        btn_hitung.setOnClickListener {

            if(et_barang.text.length > 0 && et_jumlah.text.length > 0 && et_harga.text.length > 0){

                //val customDialogFrag = LayoutInflater.from(this).inflate(R.layout.fragment_alert_dialog ,null, false)

                val barang = et_barang.text.toString()
                val jumlah = et_jumlah.text.toString()
                val harga = et_harga.text.toString()
                val totalHarga = harga.toInt() * jumlah.toInt()

                val data = bundleOf("TOTALHARGA" to totalHarga)

                tv_barang.text = "Barang : $barang"
                tv_harga.text = "Harga $harga"
                tv_jumlah.text = "Jumlah : $jumlah"
                tv_total_harga.text = "Total : ${totalHarga.toString()}"


                AlertDialogFragment(totalHarga.toString()).show(supportFragmentManager, null )

//                tv_kembalian.text = "Kembalian : ${kembalian.toString()}"

            }else{
                tv_error.isVisible = true
                tv_error.setText("Input masih kosong")
                Toast.makeText(this, "Mohon Masukan Input", Toast.LENGTH_LONG).show()
            }


        }

    }
}