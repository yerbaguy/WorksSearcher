package com.ebartmedia.workssearch

import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
//import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*

import android.support.v7.widget.AppCompatTextView
import android.util.Log
import android.view.ContextMenu
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)




        val hView = nav_view.getHeaderView(0);
        val textview = hView.findViewById(R.id.textView3) as TextView

        val textView2 = hView.findViewById<TextView>(R.id.textView2) as TextView





//        textview.setOnClickListener({
//
//            Log.d("lkjsdf", "lkjasdf")
//
//            val createAccount = CreateAccountFragment()
//
//            val manager = supportFragmentManager
//
//            val transaction = manager.beginTransaction()
//
//            transaction.replace(R.id.relativeLayout, createAccount)
//
//            transaction.addToBackStack(null)
//
//            transaction.commit()
//
//        })


//        textView3.setOnClickListener({
//
//            CreateAccountFragment()
//        })



//        fun createAccount(textView3: TextView) {
//
//
//
//
//
//
//            }





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

//        textView3.setOnClickListener({
//
//            val intent = Intent(this, CreateAccountFragment::class.java)
//
//            startActivity(intent)
//
//
//        })
    }



    fun createAccount(view: View) {


        Log.d("lkjasdf", "lkjasdflkj")

        textView3.setOnClickListener({


//                        val createAccount = CreateAccountFragment()
//
//            val manager = supportFragmentManager
//
//            val transaction = manager.beginTransaction()
//
//            transaction.replace(R.id.relativeLayout, createAccount)
//
//            transaction.addToBackStack(null)
//
//            transaction.commit()


//            FragmentTransaction fragmentTransaction = getFragmentManager().begin


            val createaccount = Intent(this, CreateAccount::class.java)

            startActivity(createaccount)




        })



    }



    fun toLogin(view: View) {


        textView2.setOnClickListener({


            //                        val createAccount = CreateAccountFragment()
//
//            val manager = supportFragmentManager
//
//            val transaction = manager.beginTransaction()
//
//            transaction.replace(R.id.relativeLayout, createAccount)
//
//            transaction.addToBackStack(null)
//
//            transaction.commit()


//            FragmentTransaction fragmentTransaction = getFragmentManager().begin


            val login = Intent(this@MainActivity, Login::class.java)

            startActivity(login)




        })





    }


    fun anotherLogin(view: View) {


        anotherLogin.setOnClickListener({

            val login = Intent(this@MainActivity, AnotherLogin::class.java)

            startActivity(login)

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
        menuInflater.inflate(R.menu.main, menu)
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



    fun onClick(v: View) {

        when (v.id) {

            R.id.textView3 -> {

                CreateAccountFragment()
            }
        }


    }




//    fun createAccountFragment(view: View) {
//
//
//
//
//        val intent = Intent(this@MainActivity, CreateAccountFragment::class.java)
//
//        startActivity(intent)
//
//    }



    fun displayScreen(id: Int) {

        val fragment = when (id) {

            R.id.textView3 -> {

                CreateAccountFragment()

//                textView3.setOnClickListener({
//
//                    CreateAccountFragment()
//
//
//                })
            }

            R.id.textView2 -> {

                CreateAccountFragment()
              //  LoginFragment()
            }


//            R.id.nav_add_word -> {
//                AddWordFragment()
//            }
//
//            R.id.nav_practice -> {
//
//                PracticeFragment()
//            }
//
//            R.id.nav_main -> {
//
//                MainFragment()
//            }

            else -> {

               // MainFragment()

                LoggedInFragment()
               // MainActivity()
              //  LoginFragment()
            }
        }

        supportFragmentManager
            .beginTransaction()
//            .replace(R.id.relativeLayout, fragment)
            .replace(R.id.textView2, fragment)
            .commit()



    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.








//        textView3.setOnClickListener({
//
//            val intent = Intent(this, CreateAccountFragment::class.java)
//
//            startActivity(intent)
//
//
//
//
//
//        })

////        textView3.setOnClickListener(View.OnClickListener {
////
////
////            val intent = Intent(this, CreateAccountFragment::class.java)
////
////            startActivity(intent)
//
//        })



        when (item.itemId) {

            R.id.textView -> {

                CreateAccountFragment()
            }


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
