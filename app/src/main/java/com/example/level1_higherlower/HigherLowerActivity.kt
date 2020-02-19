package com.example.level1_higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_higher_lower.*

import android.widget.Toast
class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()

    }



    private fun initViews() {
        btnHigher.setOnClickListener { onHigherClick() }
        btnLower.setOnClickListener { onLowerClick() }
        btnEquals.setOnClickListener { onEqualClick() }
        updateUI()


    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)


        if (currentThrow == 1){
            Dice.setImageResource(R.drawable.dice1)
        } else if (currentThrow == 2){
            Dice.setImageResource(R.drawable.dice2)
        } else if (currentThrow == 3){
            Dice.setImageResource(R.drawable.dice3)
        }else if (currentThrow == 4){
            Dice.setImageResource(R.drawable.dice4)
        }else if (currentThrow == 5){
            Dice.setImageResource(R.drawable.dice5)
        } else if (currentThrow == 6){
            Dice.setImageResource(R.drawable.dice6)
        }

//
//        when (currentThrow) {
//            1 -> Dice.setImageResource(R.drawable.dice1)
//            2 -> Dice.setImageResource(R.drawable.dice2)
//            3 -> Dice.setImageResource(R.drawable.dice3)
//            4 -> Dice.setImageResource(R.drawable.dice4)
//            5 -> Dice.setImageResource(R.drawable.dice5)
//            6 ->  Dice.setImageResource(R.drawable.dice6)
//        }

    }


    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {


        rollDice()

        if (currentThrow > lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()

    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {

        rollDice()

        if (currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {

        rollDice()

        if (currentThrow == lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }



}
