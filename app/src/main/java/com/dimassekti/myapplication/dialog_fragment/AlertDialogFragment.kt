package com.dimassekti.myapplication.dialog_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.dimassekti.myapplication.R
import kotlinx.android.synthetic.main.activity_kasir_dua.*
import kotlinx.android.synthetic.main.fragment_alert_dialog.*
import kotlinx.android.synthetic.main.fragment_alert_dialog.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlertDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlertDialogFragment(totalHarga : String) : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert_dialog, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val totalBelanja = arguments?.getString("TOTALHARGA")

        tv_total_belanja.text = totalBelanja.toString()

        val abc = LayoutInflater.from(requireContext()).inflate(R.layout.activity_kasir_dua ,null, false)

        btn_bayar.setOnClickListener {

            if(et_bayar.text.length > 0){
                val bayar = et_bayar.text.toString()
//                val kembalian = totalBelanja!!.toInt() - bayar!!.toInt()

                dismiss()
            }else{
                tv_error_2.setText("Input masih kosong")
                Toast.makeText(requireContext(), "Mohon Masukan Input", Toast.LENGTH_LONG).show()
            }


        }
    }


}