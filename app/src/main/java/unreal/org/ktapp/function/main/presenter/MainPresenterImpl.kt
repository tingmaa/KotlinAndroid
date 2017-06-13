package unreal.org.ktapp.function.main.presenter

import org.unreal.core.base.BasePresenterImpl
import org.unreal.core.di.component.CoreComponent
import unreal.org.ktapp.function.main.contract.MainContract
import unreal.org.ktapp.http.di.component.DaggerServiceComponent
import unreal.org.ktapp.http.service.UserService
import javax.inject.Inject


/**
 * <b>类名称：</b> MainPresenterImpl <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年05月25日 14:41<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
class MainPresenterImpl(view: MainContract.View)
    : BasePresenterImpl<MainContract.View>(view)
        , MainContract.Presenter {

    @Inject
    lateinit var userService: UserService


    override fun injectComponent(coreComponent: CoreComponent) {
        DaggerServiceComponent.builder().coreComponent(coreComponent).build().inject(this)
    }

    fun loadData(){
        userService.login()
                .compose(lifecycleTransformer)

    }


}