package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import java.util.*
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createButton()


    }
    private val buttonarray = arrayListOf<Button>()
    private fun createButton() {
        val b1: Button = findViewById<Button>(R.id.b1)
        val b2: Button = findViewById<Button>(R.id.b2)
        val b3: Button = findViewById<Button>(R.id.b3)
        val b4: Button = findViewById<Button>(R.id.b4)
        val b5: Button = findViewById<Button>(R.id.b5)
        val b6: Button = findViewById<Button>(R.id.b6)
        val b7:Button = findViewById<Button>(R.id.b7)
        val b8:Button = findViewById<Button>(R.id.b8)
        val b9:Button = findViewById<Button>(R.id.b9)
        buttonarray.addAll(listOf(b1,b2,b3,b4,b5,b6,b7,b8,b9))
    }



//
//
    private var score1 = 0
    private var score2 = 0

     var moves = ArrayList<Int>()
     var playerchance = 0
    @SuppressLint("ResourceAsColor")
    fun onclick(view: View) {
        var clicked = view as Button

        var value = -1
        if(clicked == findViewById<Button>(R.id.b1)){
            value = 1
        }
        else if(clicked == findViewById<Button>(R.id.b2)){
            value = 2
        }
        else if(clicked == findViewById<Button>(R.id.b3)){
            value = 3
        }
        else if(clicked == findViewById<Button>(R.id.b4)){
            value = 4
        }
        else if(clicked == findViewById<Button>(R.id.b5)){
            value = 5
        }
        else if(clicked == findViewById<Button>(R.id.b6)){
            value = 6
        }
        else if(clicked == findViewById<Button>(R.id.b7)){
            value = 7
        }
        else if(clicked == findViewById<Button>(R.id.b8)){
            value = 8
        }
        else if(clicked == findViewById<Button>(R.id.b9)){
            value = 9
        }
        if(moves.contains(value)){
            Toast.makeText(this,"Invalid Move", Toast.LENGTH_SHORT).show()
            return
        }
        else{
            afterclick(value,clicked)
        }

    }
    var p1 = arrayListOf<Int>()
    var p2 = arrayListOf<Int>()
    @SuppressLint("ResourceAsColor")
    private fun afterclick(value: Int, clicked: Button) {
        moves.add(value)
        playerchance +=1
        if (playerchance%2!=0){
            clicked.text = "X"
//            clicked.setBackgroundColor(R.color.red)
//          clicked.setTextColor(R.color.red)
            clicked.textSize = 50F
            p1.add(value)
            if(checkWinP1()){
                score1+=1
            val xscore: TextView = findViewById<TextView>(R.id.X_score)
                playerchance = 0
                xscore.text = score1.toString()
                Toast.makeText(this,"Player X WIN..!!!",Toast.LENGTH_SHORT).show()

                Timer().schedule(500){
                    clearBoard()
                }

                return
            }
        }
        else{
            clicked.text = "O"
//
//            clicked.setTextColor(R.color.green)
//            clicked.setBackgroundColor(R.color.green)
            clicked.textSize = 50F
            p2.add(value)
            if(checkWinP2()){
                score2+=1
                playerchance = 0
             val oscore: TextView = findViewById<TextView>(R.id.O_Score)
                oscore.text = score2.toString()
                Toast.makeText(this,"Player O WIN..!!!",Toast.LENGTH_SHORT).show()
                Timer().schedule(500){
                    clearBoard()
                }

                return
            }

        }

        if(moves.size==9){
            playerchance = 0
            Toast.makeText(this,"DRAW",Toast.LENGTH_SHORT).show()
//            delay(1000)
            Timer().schedule(500){
                clearBoard()
            }

        }
    }
//
    private fun clearBoard() {
//        clear the board

        p1.clear()
        p2.clear()
        moves.clear()
        playerchance = 0
        for (i in buttonarray){

                clearbutton(i)


        }

    }

    @SuppressLint("ResourceAsColor")
    private fun clearbutton(i: Button) {
//        i.setBackgroundColor(R.color.white)
        i.text= ""
    }
//

    private fun checkWinP1(): Boolean {
        if(p1.containsAll(listOf(1,2,3)) or p1.containsAll(listOf(4,5,6)) or p1.containsAll(listOf(7,8,9)) or p1.containsAll(
                listOf(1,5,9)) or p1.containsAll(listOf(3,5,7)) or p1.containsAll(listOf(1,4,7)) or p1.containsAll(
                listOf(2,5,8)) or p1.containsAll(listOf(3,6,9))
            ){
            return true
        }
        return false
    }

    private fun checkWinP2(): Boolean {
        if(p2.containsAll(listOf(1,2,3)) or p2.containsAll(listOf(4,5,6)) or p2.containsAll(listOf(7,8,9)) or p2.containsAll(
                listOf(1,5,9)) or p2.containsAll(listOf(3,5,7)) or p2.containsAll(listOf(1,4,7)) or p2.containsAll(
                listOf(2,5,8)) or p2.containsAll(listOf(3,6,9))){
            return true
        }
        return false
    }


}


