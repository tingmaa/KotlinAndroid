package org.unreal.core.base

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tool_bar.*
import org.unreal.core.R


/**
 * <b>类名称：</b> ToolBarActivity <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年05月25日 16:49<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
abstract class ToolBarActivity<P : BasePresenter> : BaseActivity<P>(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_tool_bar)
        layoutInflater.inflate(bindLayout(), content, true)
        initToolbar()
        super.onCreate(savedInstanceState)
    }

    /**
     * Init toolbar.
     */
    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        toolbarTitle.text = setTitle()
        toolbar.setNavigationOnClickListener({ finish() })
    }

    /**
     * Hide navigation.
     */
    fun hideNavigation() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    /**
     * Hide toolbar.
     */
    fun hideToolbar() {
        toolbar.visibility = View.GONE
    }

    /**
     * Show toolbar.
     */
    fun showToolbar() {
        toolbar.visibility = View.VISIBLE
    }


    /**
     * Sets title.

     * @return the title
     */
    abstract fun setTitle(): String


    fun setTitle(title: String) {
        toolbarTitle.text = title
    }

    override val isCustomerView: Boolean = false

}