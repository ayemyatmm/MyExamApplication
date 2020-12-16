package jp.co.cybermissions.com.example.myexamapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import jp.co.cybermissions.com.example.myexamapplication.exam.ExamsFragment
import jp.co.cybermissions.com.example.myexamapplication.score.ScoreFragment

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val fragmentMain = MainFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.myNavHostFragment,fragmentMain).commit()

    }

//    override fun passDataCom(editTextInput: String) {
//        val bundle = Bundle()
//        bundle.putString("message", editTextInput)
//
//        val transaction = this.supportFragmentManager.beginTransaction()
//        val fragmentScore = ScoreFragment()
//
//        fragmentScore.arguments = bundle
//
//        transaction.replace(R.id.myNavHostFragment,fragmentScore)
//        transaction.commit()
//
//    }
}