package unreal.org.ktapp.http.di.component

import dagger.Component
import org.unreal.core.di.component.CoreComponent
import org.unreal.core.di.scope.NetScope
import unreal.org.ktapp.function.main.presenter.MainPresenterImpl
import unreal.org.ktapp.http.di.module.ServiceModule

/**
 * <b>类名称：</b> ServiceComponent <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年05月25日 08:57<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */

@NetScope
@Component(dependencies = arrayOf(CoreComponent::class),
        modules = arrayOf(ServiceModule::class))
interface ServiceComponent {
    fun inject(mainPresenterImpl : MainPresenterImpl)

}