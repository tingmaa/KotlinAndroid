package org.unreal.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.trello.rxlifecycle.android.RxLifecycleAndroid
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import org.unreal.widget.window.WaitScreen
import org.unreal.core.base.BaseApplication.Companion.coreComponent
import org.unreal.core.di.component.CoreComponent
import org.unreal.core.manager.ActivityTaskManager
import java.util.*
import javax.inject.Inject



/**
 * <b>类名称：</b> BaseActivity <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年05月25日 14:42<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
abstract class BaseActivity<P : BasePresenter> : RxAppCompatActivity(), BaseView {

    @Inject
    lateinit var presenter : P

    private var waitScreens: Stack<WaitScreen> = Stack()

    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        if (isCustomerView) {
            setContentView(bindLayout())
        }
        injectDagger(coreComponent)
        presenter.bindLifeCycle(
                RxLifecycleAndroid.bindActivity(lifecycle()))
        afterViews()
        ActivityTaskManager.instance.pushActivity(this)
    }


    protected abstract fun injectDagger(coreComponent: CoreComponent)

    override fun showWait() {
        val waitScreen = WaitScreen(this)
        waitScreens.push(waitScreen)
        waitScreen.show()
    }

    override fun showWait(message: String) {
        val waitScreen = WaitScreen(this)
        waitScreens.push(waitScreen)
        waitScreen.show(message)
    }

    override fun hideWait(onAnimationEnd: () -> Unit) {
        val waitScreen = waitScreens.pop()
        waitScreen.close(onAnimationEnd)
    }

    override fun closeWait() {
        val waitScreen = waitScreens.pop()
        waitScreen.dismiss()
    }

    override fun toast(message: CharSequence) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun finish() {
        ActivityTaskManager.instance.popActivity(this)
        super.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        while (!waitScreens.empty()) {
            val waitScreen = waitScreens.pop()
            waitScreen.dismiss()
        }
    }

    override fun finishAll() {
        ActivityTaskManager.instance.finishAllActivities()
    }

    @SafeVarargs
    override fun finish(vararg activityClasses: Class<out Activity>) {
        ActivityTaskManager.instance.finishActivities(*activityClasses)
    }

    override fun getContext(): Context {
        return this
    }

    open val isCustomerView: Boolean = true

    abstract fun bindLayout(): Int

    abstract fun afterViews()
}