package com.mutakin.myfragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException


class OptionDialogFragment : DialogFragment(R.layout.fragment_option_dialog) {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbSaf: RadioButton
    private lateinit var rbMou: RadioButton
    private lateinit var rbLvg: RadioButton
    private lateinit var rbMoyes: RadioButton

    private var optionDialogListener: OnOptionDialogListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment
        if (fragment is DetailCategoryFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChoose = view.findViewById(R.id.btn_pilih)
        btnClose = view.findViewById(R.id.btn_close)
        rgOptions = view.findViewById(R.id.rg_options)
        rbSaf = view.findViewById(R.id.rb_saf)
        rbLvg = view.findViewById(R.id.rb_lvg)
        rbMou = view.findViewById(R.id.rb_mou)
        rbMoyes = view.findViewById(R.id.rb_moyes)


        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId

            if (checkedRadioButtonId != -1) {
                var coach: String? = null
                when (checkedRadioButtonId) {
                    R.id.rb_saf -> coach = rbSaf.text.toString().trim()
                    R.id.rb_mou -> coach = rbMou.text.toString().trim()
                    R.id.rb_lvg -> coach = rbLvg.text.toString().trim()
                    R.id.rb_moyes -> coach = rbMoyes.text.toString().trim()
                }
                optionDialogListener?.optionChosen(coach)
                dialog?.dismiss()
            }
        }

        btnClose.setOnClickListener {
            Log.d("OptionDialog", "onViewCreated: dialog canceled")
            dialog?.cancel()
        }
    }

}

interface OnOptionDialogListener {
    fun optionChosen(coach: String?)
}
