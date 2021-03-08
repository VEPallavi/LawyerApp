package com.ve.lawyer.ui.userflow

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.ve.lawyer.R
import com.ve.lawyer.ui.chat.ChatListActivity
import com.ve.lawyer.ui.common.fragment.*
import com.ve.lawyer.ui.userflow.fragment.*
import com.ve.lawyer.utils.SlideAnimationUtil
import kotlinx.android.synthetic.main.toolbar_main.*

class UserHomeActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private var navView: NavigationView? = null
    private var bottomNavView: BottomNavigationView? = null
    private var toolbar: Toolbar? = null
    private var mDrawerLayout: DrawerLayout? = null
    private var mDrawerToggle: ActionBarDrawerToggle? = null
    private var mNavigationHeaderView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        initialiseNavigationBar()
        setupClickListener()
        setDisplayFragment(1)
    }

    private fun initialiseNavigationBar() {
        mDrawerLayout = findViewById(R.id.drawer_layout)

        navView = findViewById(R.id.nav_view)
        bottomNavView = findViewById(R.id.bottom_navigation_view)

        val headerView = navView?.getHeaderView(0)
        headerView?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                setDisplayFragment(11)
                mDrawerLayout?.closeDrawer(GravityCompat.START)
            }
        })
        //headerTextView = (headerLayout)?.findViewById<TextView>(R.id.tv_userName)

        mDrawerToggle = ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        mDrawerLayout?.addDrawerListener(mDrawerToggle!!)
        navView?.setNavigationItemSelectedListener(this)
        bottomNavView?.setOnNavigationItemSelectedListener(this)
    }

    private fun setupClickListener() {
        iv_hamburgerMenu.setOnClickListener(this)
        iv_toolbarBack.setOnClickListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_dashboard -> {
                setDisplayFragment(1)
            }
            R.id.nav_chat -> {
                val intent = Intent(this@UserHomeActivity, ChatListActivity::class.java)
                startActivity(intent)
                SlideAnimationUtil.slideNextAnimation(this@UserHomeActivity)
            }
            R.id.nav_invite_friends -> {
                setDisplayFragment(3)
            }
            R.id.nav_rating_comment -> {
                setDisplayFragment(4)
            }
            R.id.nav_change_password -> {
                setDisplayFragment(5)
            }
            R.id.nav_help_and_support -> {
                setDisplayFragment(6)
            }
            R.id.nav_term_and_condition -> {
                setDisplayFragment(7)
            }
            R.id.nav_logout -> {
                showLogOutConfirmationDialog()
            }
            R.id.bottom_nav_home -> {
                setDisplayFragment(1)
            }
            R.id.bottom_nav_search -> {
                setDisplayFragment(8)
            }
            R.id.bottom_nav_category -> {
                setDisplayFragment(9)
            }
            R.id.bottom_nav_notification -> {
                setDisplayFragment(10)
            }
        }
        mDrawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.iv_hamburgerMenu -> {
                openDrawerLayout()
            }
            R.id.iv_toolbarBack -> {
                removeFragmentFromBackStack()
            }
        }
    }

    fun setDisplayFragment(fragmentType: Int) {
        var mFragment: Fragment? = null
        var fragmentName: String = ""
        when (fragmentType) {
            1 -> {
                mFragment = DashboardFragment()
                fragmentName = "DashboardFragment"
                replaceFragment(mFragment, fragmentName)
            }
            2 -> {
                mFragment = InviteFriendFragment()
                fragmentName = "InviteFriendFragment"
                replaceFragment(mFragment, fragmentName)
            }
            3 -> {
                mFragment = ContactListFragment()
                fragmentName = "InviteFriendsFragment"
                replaceFragment(mFragment, fragmentName)
            }
            4 -> {
                mFragment = RatingAndCommentFragment()
                fragmentName = "RatingAndCommentFragment"
                replaceFragment(mFragment, fragmentName)
            }
            5 -> {
                mFragment = ChangePasswordFragment()
                fragmentName = "ChangePasswordFragment"
                replaceFragment(mFragment, fragmentName)
            }
            6 -> {
                mFragment = HelpAndSupportFragment()
                fragmentName = "HelpAndSupportFragment"
                replaceFragment(mFragment, fragmentName)
            }
            7 -> {
                mFragment = TermAndConditionFragment()
                fragmentName = "TermAndConditionFragment"
                replaceFragment(mFragment, fragmentName)
            }
            8 -> {
                mFragment = SearchFragment()
                fragmentName = "SearchFragment"
                replaceFragment(mFragment, fragmentName)
            }
            9 -> {
                mFragment = CategoriesFragment()
                fragmentName = "CategoriesFragment"
                replaceFragment(mFragment, fragmentName)
            }
            10 -> {
                mFragment = NotificationFragment()
                fragmentName = "NotificationFragment"
                replaceFragment(mFragment, fragmentName)
            }
            11 -> {
                mFragment = ProfileFragment()
                fragmentName = "ProfileFragment"
                replaceFragment(mFragment, fragmentName)
            }
            12 -> {
                mFragment = UserPostsFragment()
                fragmentName = "UserPostsFragment"
                replaceFragment(mFragment, fragmentName)
            }
            13 -> {
                mFragment = PostQuestionFragment()
                fragmentName = "PostQuestionFragment"
                replaceFragment(mFragment, fragmentName)
            }
            14 -> {
                mFragment = PostDetailFragment()
                fragmentName = "PostDetailFragment"
                replaceFragment(mFragment, fragmentName)
            }
        }
    }

    //.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    fun replaceFragment(mFragment: Fragment, fragmentName: String) {
        supportFragmentManager.beginTransaction()
                .addToBackStack(fragmentName)
                .replace(R.id.fragment_container, mFragment)
                .commit()
    }

    fun addFragment(mFragment: Fragment, fragmentName: String) {
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, mFragment)
                .addToBackStack(fragmentName)
                .commit()
    }

    fun clearFragmentBackStack(name: String) {
//        supportFragmentManager.popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
//        val fragment = HomeFragment()
//        replaceFragment(fragment, "HomeFragment")
//        navView?.setCheckedItem(R.id.nav_home)
    }

    private fun removeFragmentFromBackStack() {
        if (supportFragmentManager.findFragmentById(R.id.fragment_container) is DashboardFragment) {
            showExitAppConfirmationDialog()
        } else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is CategoriesFragment) {
            supportFragmentManager.popBackStackImmediate()
        } else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is ChangePasswordFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is HelpAndSupportFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is TermAndConditionFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is NotificationFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is ContactListFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is ProfileFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is UserPostsFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is SearchFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is RatingAndCommentFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is PostQuestionFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is PostDetailFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is InviteFriendFragment) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            finish()
        }
    }

    override fun onBackPressed() {
        removeFragmentFromBackStack()
    }

    fun openDrawerLayout() {
        mDrawerLayout?.openDrawer(GravityCompat.START)
    }

    fun closeDrawerLayout() {
        mDrawerLayout?.closeDrawer(GravityCompat.START)
    }

    fun setToolbarTitle(toolbarTitle: String) {
        tv_toolbarTitle.text = toolbarTitle
    }

    fun setToolbarMenuIconVisibility(isVisible: Boolean) {
        if (isVisible) {
            iv_hamburgerMenu.visibility = View.VISIBLE
        } else {
            iv_hamburgerMenu.visibility = View.GONE
        }
    }

    fun setToolbarVisibility(isVisible: Boolean) {
        if (isVisible) {
            toolbar?.visibility = View.VISIBLE
        } else {
            toolbar?.visibility = View.GONE
        }
    }

    fun setToolbarBackIconVisibility(isVisible: Boolean) {
        if (isVisible) {
            iv_toolbarBack.visibility = View.VISIBLE
        } else {
            iv_toolbarBack.visibility = View.GONE
        }
    }

    fun setBottomNavigationBarVisibility(isVisible: Boolean) {
        if (isVisible) {
            bottomNavView?.visibility = View.VISIBLE
        } else {
            bottomNavView?.visibility = View.GONE
        }
    }

    fun showExitAppConfirmationDialog() {
        val alertDialog = AlertDialog.Builder(this)

        alertDialog.setMessage("Do you want to close this app?")
                .setCancelable(false)
                .setPositiveButton("YES", DialogInterface.OnClickListener { dialog, id ->
                    finish()
                })
                .setNegativeButton("NO",
                        DialogInterface.OnClickListener { dialog, id -> //  Action for 'NO' Button
                            dialog.cancel()
                        })
        // create dialog box
        val alert = alertDialog.create()
        // set title for alert dialog box
        alert.setTitle("Alert")
        // show alert dialog
        alert.show()
    }

    fun showLogOutConfirmationDialog() {
        val alertDialog = AlertDialog.Builder(this)

        alertDialog.setMessage("Are you sure want to logout from the app?")
                .setCancelable(false)
                .setPositiveButton("YES", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })
                .setNegativeButton("NO",
                        DialogInterface.OnClickListener { dialog, id -> //  Action for 'NO' Button
                            dialog.cancel()
                        })
        // create dialog box
        val alert = alertDialog.create()
        // set title for alert dialog box
        alert.setTitle("Alert")
        // show alert dialog
        alert.show()
    }
}