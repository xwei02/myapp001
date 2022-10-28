package com.example.mora_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //將變數與XML綁定
        val ed_name = findViewById<EditText>(R.id.tv_text)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.ed_name)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        btn_mora.setOnClickListener{
            //判斷EditText的數字是否小於一，若成立則無法進行猜拳
            if (ed_name.length()<1){
                tv_text.text="請輸入玩家姓名"
                return@setOnClickListener
            }
            //取出EditText 文字作為玩家名稱並用變數儲存
            val playerName = ed_name.text
            //亂數產生0~1之間不含1的小數，0~2做為電腦的出拳
            val comMora = (Math.random()*3).toInt()
            //將玩家出拳結果對應成字串並用變數儲存
            val playerMoraText = when {
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "布"
            }
            val comMoraText = when(comMora){
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }
            tv_name.text = "名字\n$playerName"
            tv_mmora.text = "我方出拳\n$playerMoraText"
            tv_cmora.text = "電腦出拳\n$comMoraText"
            when{
                btn_scissor.isChecked && comMora ==2 ||
                        btn_stone.isChecked && comMora == 0 ||
                        btn_paper.isChecked && comMora == 1 ->{
                    tv_winner.text = "勝利者\n$playerName"
                    tv_text.text = "恭喜你獲勝了!!!"
                }
                btn_scissor.isChecked && comMora ==1 ||
                         btn_stone.isChecked && comMora ==2 ||
                         btn_paper.isChecked && comMora == 0 -> {
                    tv_winner.text = "勝利者\n 電腦"
                    tv_text.text = "可惜，電腦獲勝了!"
                }
                else ->{
                    tv_winner.text = "勝利者\n 平手"
                    tv_text.text = "平局，再出一次!"
                }
            }
        }
    }
}