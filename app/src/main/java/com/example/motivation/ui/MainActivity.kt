package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)
        textName.text=mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

    }

    override fun onClick(view: View) {
        val id = view.id

        val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageMorning)
        if (id == R.id.buttonNewPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }
    private  fun handleFilter(id: Int) {

        when(id) {
            R.id.imageAll -> {
                imageAll.setColorFilter(resources.getColor(R.color.colorAccent))
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(resources.getColor(R.color.colorAccent))
            }
            R.id.imageMorning -> {
                imageMorning.setColorFilter(resources.getColor(R.color.colorAccent))
            }
        }

    }
    private fun handleNewPhrase() {

    }
}
