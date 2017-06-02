package org.unreal.databases.config

import com.raizlabs.android.dbflow.annotation.Database
import org.unreal.databases.config.UnrealDatabase.NAME
import org.unreal.databases.config.UnrealDatabase.VERSION

/**
 * <b>类名称：</b> UnrealDatabase <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年06月01日 13:53<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
@Database(name = NAME, version = VERSION)
object UnrealDatabase {

    const val NAME = "unrealDatabases" // we will add the .db extension

    const val VERSION = 1
}