package com.cermati.test.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.cermati.test.BR
import com.cermati.test.R
import com.cermati.test.ViewModelProviderFactory
import com.cermati.test.databinding.FragmentHomeBinding
import com.cermati.test.ui.base.BaseFragment
import com.github.apps.ui.home.HomeNavigator
import javax.inject.Inject


class HomeFragment : BaseFragment<FragmentHomeBinding?, HomeViewModel>(), HomeNavigator {

    @JvmField
    @Inject
    var factory: ViewModelProviderFactory? = null

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this, factory!!).get(HomeViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    activity?.finish()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLoadMore()
    }

    private fun setLoadMore() {
//        viewDataBinding?.rvList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
//                    viewModel.loadMoreData(linearLayoutManager)
//
//            }
//        })
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun movePage() {
//        findNavController().navigate(R.id.mainPageFragment)
    }

    override fun handleError(throwable: Throwable?) {
        Toast.makeText(context, throwable?.message, Toast.LENGTH_SHORT).show()
    }
}