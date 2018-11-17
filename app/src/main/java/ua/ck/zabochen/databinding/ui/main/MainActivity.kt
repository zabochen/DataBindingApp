package ua.ck.zabochen.databinding.ui.main

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import ua.ck.zabochen.databinding.R
import ua.ck.zabochen.databinding.ui.user.UserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var unbinder: Unbinder

    @BindView(R.id.activityMain_frameLayout_fragmentHolder)
    lateinit var fragmentHolder: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUi()
        if (savedInstanceState == null) {
            setFragment(fragmentHolder, UserFragment.newInstance())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::unbinder.isInitialized) {
            unbinder.unbind()
        }
    }

    private fun setUi() {
        // Layout & ButterKnife
        setContentView(R.layout.activity_main)
        unbinder = ButterKnife.bind(this)
    }

    private fun setFragment(fragmentHolder: FrameLayout, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(fragmentHolder.id, fragment)
                .commit()
    }
}
