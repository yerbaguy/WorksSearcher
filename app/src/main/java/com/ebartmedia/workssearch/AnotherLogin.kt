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
import android.widget.Button
import android.widget.Toast
import com.ebartmedia.workssearch.models.PersonsLogin
import com.ebartmedia.workssearch.services.PersonsLoginService
import com.ebartmedia.workssearch.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_another_login.*
import kotlinx.android.synthetic.main.app_bar_another_login.*
import kotlinx.android.synthetic.main.content_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnotherLogin : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another_login)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        var button = findViewById<Button>(R.id.button)



          button.setOnClickListener({


              val personsLogin = PersonsLogin()


              var userName:String = loginUsername.text.toString()
              var userPassword:String = loginPassword.text.toString()



              Log.d("userName", "userName$userName")
              Log.d("userPassword", "userPassword$userPassword")




              personsLogin.username = userName
              personsLogin.password = userPassword




              //  val personsService = ServiceBuilder.buildService(PersonsService::class.java)
              val personsLoginService = ServiceBuilder.buildServiceToLogin(PersonsLoginService::class.java)
              //  val requestCall = personsService.addPersons(persons)
              val requestCall = personsLoginService.toLogin(personsLogin)




              requestCall.enqueue(object : Callback<PersonsLogin> {

                  override fun onResponse(call: Call<PersonsLogin>, response: Response<PersonsLogin>) {

                      if(response.isSuccessful) {

                          Toast.makeText(this@AnotherLogin, "Successfully Added", Toast.LENGTH_SHORT).show()
                      } else {

                          Toast.makeText(this@AnotherLogin, "Failed to add the person", Toast.LENGTH_SHORT).show()
                      }
                  }

                  override fun onFailure(call: Call<PersonsLogin>, t: Throwable) {

                      Toast.makeText(this@AnotherLogin, "Failed to add item", Toast.LENGTH_SHORT).show()
                  }

              })






          })





            val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
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
        menuInflater.inflate(R.menu.another_login, menu)
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
