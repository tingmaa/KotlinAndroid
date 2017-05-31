package unreal.org.ktapp.function.main.module

import dagger.Module
import dagger.Provides
import org.unreal.core.di.scope.ActivityScope
import unreal.org.ktapp.function.main.contract.MainContract
import unreal.org.ktapp.function.main.presenter.MainPresenterImpl


/**
 * <b>类名称：</b> MainModule <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年05月25日 08:51<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
@Module
class MainModule(private val view: MainContract.View) {

    @ActivityScope
    @Provides
    internal fun providerView(): MainContract.View {
        return view
    }

    @ActivityScope
    @Provides
    internal fun providerPresenter(view: MainContract.View): MainContract.Presenter {
        return MainPresenterImpl(view)
    }

}