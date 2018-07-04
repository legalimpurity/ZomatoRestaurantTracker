package com.legalimpurity.zomatorestauranttracker.ui.baseui

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.View
import android.view.inputmethod.InputMethodManager
import dagger.android.AndroidInjection

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<out BaseNavigator>>: AppCompatActivity(), BaseFragment.Callbacks {

    private lateinit var mViewDataBinding: T
    private lateinit var mViewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        performDependencyInjection()
        // This is to be done so that the fragment in the view does now calls its dependency injection before, or at least that why i think this is done in such a manner.
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        getViewModel()?.let {
            mViewModel = it
            mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
            mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
            mViewDataBinding.executePendingBindings()
        }
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    fun getViewDataBinding(): T = mViewDataBinding


    //Functions to be implemented by Activities
    abstract fun getViewModel(): V?

    abstract fun getBindingVariable(): Int
    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun getCoordinatorRootLayout(): CoordinatorLayout?

    // Fragment Functions
    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    // snackbarActionClicker is -1 in case of no action
    fun showMsg(errorStringResource: Int, actionString: Int, snackbarActionClicker: ((actionButView: View?) -> Unit)?)
    {
        showMsg(getString(errorStringResource),actionString,snackbarActionClicker)
    }

    fun showMsg(errorString: String, actionString: Int, snackbarActionClicker: ((actionButView: View?) -> Unit)?)
    {
        getCoordinatorRootLayout()?.let {
            val sk = Snackbar.make(it, errorString,Snackbar.LENGTH_LONG)
            if(actionString!=-1) {
                sk.setAction(actionString) { actionButView ->
                    snackbarActionClicker?.invoke(actionButView)
                    sk.dismiss()
                }
            }
            sk.show()

        }
    }
}