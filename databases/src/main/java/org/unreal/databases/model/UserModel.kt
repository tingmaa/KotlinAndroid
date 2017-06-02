package org.unreal.databases.model

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel
import org.unreal.databases.config.UnrealDatabase

/**
 * <b>类名称：</b> UserModel <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年06月01日 14:00<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
@Table(database = UnrealDatabase::class)
data class UserModel
(@PrimaryKey(autoincrement = true) var id: Int = 0, @Column var name: String? = null) : BaseRXModel()