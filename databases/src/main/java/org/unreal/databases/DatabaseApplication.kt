package org.unreal.databases

import com.raizlabs.android.dbflow.config.DatabaseConfig
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager
import org.unreal.core.base.BaseApplication
import org.unreal.databases.sqlcipher.SqlCipherHelperImpl

/**
 * <b>类名称：</b> DatabaseApplication <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年06月01日 11:43<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
abstract class DatabaseApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        //todo SqlCipher 没有成功加密数据库，等待后期dbflow更新
        val flowConfig = FlowConfig
                .Builder(this)
                .addDatabaseConfig(
                        DatabaseConfig
                                .Builder(DatabaseApplication::class.java)
                                .openHelper(::SqlCipherHelperImpl)
                                .build())
                .build()
        FlowManager.init(flowConfig)
    }

    override fun onTerminate() {
        super.onTerminate()
        FlowManager.destroy()
    }
}