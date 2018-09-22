package com.laaptu.mvvm.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.TextAppearanceSpan
import android.view.Menu
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var amountTitleTextSpannable: TextAppearanceSpan
    private lateinit var amountTextSpannable: TextAppearanceSpan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        amountTitleTextSpannable = TextAppearanceSpan(this, R.style.AmountTitleTextViewStyle)
        amountTextSpannable = TextAppearanceSpan(this, R.style.AmountOnlyTextViewStyle)
        updateAmountText(txtTotalAmount, "0", getString(R.string.total_amount))
        updateAmountText(txtGivenAmount, "0", getString(R.string.given_amount))
        updateAmountText(txtTipAmount, "0", getString(R.string.tip_amount))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun updateAmountText(textView: TextView, amount: String, title: String) {
        val displayText = amount.plus("\n\n").plus(title)
        val spannableStringBuilder = SpannableStringBuilder(displayText)
        spannableStringBuilder.setSpan(amountTextSpannable, 0, amount.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(amountTitleTextSpannable, amount.length + 2, displayText.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannableStringBuilder
    }
}
