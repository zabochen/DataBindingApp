package ua.ck.zabochen.databinding.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ua.ck.zabochen.databinding.R
import ua.ck.zabochen.databinding.databinding.FragmentUserBinding
import ua.ck.zabochen.databinding.model.User

class UserFragment : Fragment() {

    companion object {
        fun newInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Binding
        val fragmentUserBinding: FragmentUserBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)

        // Set data
        fragmentUserBinding.user = User(1, "User_1")

        // View
        return fragmentUserBinding.root
    }

}