package com.ebartmedia.workssearch

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.ebartmedia.workssearch.models.Persons
import com.ebartmedia.workssearch.services.PersonsService
import com.ebartmedia.workssearch.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.app_bar_create_account.*
import kotlinx.android.synthetic.main.content_create_account.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAccount : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

//
//        button = findViewById(R.id.button) as Button
//
//
//        button.setOnClickListener({
//
//
//            Log.d ("lkjasdf", "lkjasdf")
//
//        })


        var button = findViewById<Button>(R.id.button)


        button.setOnClickListener({

            val persons = Persons()

            Log.d("lkjsdf", "lkjsdf")


            var userName:String = createAccoutUserName.text.toString()
            var eMail:String = createAccountEmail.text.toString()
            var paSsword:String = createAccountPassword.text.toString()



            Log.d("usename", "username$userName")
            Log.d("email", "email$eMail")
            Log.d("password", "password$paSsword")



            persons.username = userName
            persons.email = eMail
            persons.password = paSsword



            val personsService = ServiceBuilder.buildService(PersonsService::class.java)
            val requestCall = personsService.addPersons(persons)



            requestCall.enqueue(object : Callback<Persons> {

                override fun onResponse(call: Call<Persons>, response: Response<Persons>) {

                    if(response.isSuccessful) {

                        Toast.makeText(this@CreateAccount, "Successfully Added", Toast.LENGTH_SHORT).show()
                    } else {

                        Toast.makeText(this@CreateAccount, "Failed to add the person", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Persons>, t: Throwable) {

                    Toast.makeText(this@CreateAccount, "Failed to add item", Toast.LENGTH_SHORT).show()
                }
                
            })




        })

    }




    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.create_account, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
