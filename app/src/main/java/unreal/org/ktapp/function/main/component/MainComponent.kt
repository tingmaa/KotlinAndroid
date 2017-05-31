package unreal.org.ktapp.function.main.component

import dagger.Component
import org.unreal.core.di.component.CoreComponent
import org.unreal.core.di.scope.ActivityScope
import unreal.org.ktapp.function.main.MainActivity
import unreal.org.ktapp.function.main.module.MainModule

/**
 * <b>类名称：</b> ServiceComponent <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年05月25日 08:50<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
@ActivityScope
@Component(modules = arrayOf(MainModule::class) ,
        dependencies = arrayOf(CoreComponent::class))
interface MainComponent{
    fun inject(mainActivity: MainActivity)
}