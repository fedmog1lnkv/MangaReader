package com.fedmog1lnkv.mangareader.presentation.screens.main

import android.os.Build
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fedmog1lnkv.mangareader.R
import com.fedmog1lnkv.mangareader.databinding.ActivityMainScreenBinding
import com.fedmog1lnkv.mangareader.presentation.screens.account.AccountFragment
import com.fedmog1lnkv.mangareader.presentation.screens.bookmarks.BookmarksFragment
import com.fedmog1lnkv.mangareader.presentation.screens.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenActivity : AppCompatActivity() {

    private var _binding: ActivityMainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            navigate(HomeFragment())
        }
        initBottomNavigation()
    }

    override fun onStart() {
        super.onStart()
        onBackPressedDispatcher.addCallback {
            if (!navigateBack()) {
                finish()
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(OnBackInvokedDispatcher.PRIORITY_OVERLAY) {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun initBottomNavigation() {
        binding.apply {
            var useBottomNavigationListener = true
            bottomNavigation.setOnItemSelectedListener {
                if (!useBottomNavigationListener || it.isChecked) return@setOnItemSelectedListener true
                when (it.itemId) {
                    R.id.home_navigation_button -> {
                        navigate(HomeFragment())
                    }

                    R.id.bookmark_navigation_button -> {
                        navigate(BookmarksFragment())
                    }

                    R.id.account_navigation_button -> {
                        navigate(AccountFragment())
                    }
                }
                true
            }
            supportFragmentManager.addOnBackStackChangedListener {
                val entry =
                    supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
                val buttonId = when (entry.name) {
                    HomeFragment::class.simpleName ->
                        R.id.home_navigation_button

                    BookmarksFragment::class.simpleName ->
                        R.id.bookmark_navigation_button

                    AccountFragment::class.simpleName ->
                        R.id.account_navigation_button

                    else -> bottomNavigation.selectedItemId
                }
                useBottomNavigationListener = false
                bottomNavigation.selectedItemId = buttonId
                useBottomNavigationListener = true
            }
        }
    }

    private fun navigate(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.right_slide_in,
                R.anim.left_slide_out,
                R.anim.right_slide_in,
                R.anim.left_slide_out
            )
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(fragment::class.simpleName)
            .commit()
    }

    private fun navigateBack(): Boolean {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
            return true
        }
        return false
    }
}
