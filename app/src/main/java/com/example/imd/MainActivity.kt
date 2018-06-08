package com.example.imd

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * Tag prefix for all logged messages, for easily locating them in log file.
 * The full tag will be of form `TAG_PREFIX + ClassName`.
 */
const val TAG_PREFIX: String = "IMD."

/**
 * This activity is loaded when app is started.
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    /**
     * Instances of member fragments. These will be shown according to side nav
     * selections. At start, [dashboardFragment] is shown.
     */
    private val dashboardFragment = DashboardFragment()
    private val stationFragment = StationFragment()
    private val customDataFragment = CustomDataFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, dashboardFragment)
                .commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.nav_dashboard -> {
                transaction.replace(R.id.fragment_container_main, dashboardFragment)
            }
            R.id.nav_stations -> {
                transaction.replace(R.id.fragment_container_main, stationFragment)
            }
            R.id.nav_custom -> {
                transaction.replace(R.id.fragment_container_main, customDataFragment)
            }
        }
        transaction.commit()

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
