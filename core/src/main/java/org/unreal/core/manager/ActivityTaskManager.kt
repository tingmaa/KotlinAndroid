package org.unreal.core.manager


import android.app.Activity
import java.util.*

/**
 * **类名称：** ActivityTaskManager <br></br>
 * **类描述：** <br></br>
 * **创建人：** Lincoln <br></br>
 * **修改人：** Lincoln <br></br>
 * **修改时间：** 2017年04月27日 10:21<br></br>
 * **修改备注：** <br></br>

 * @version 1.0.0 <br></br>
 */
class ActivityTaskManager private constructor() {

    private val activityLinkedList = mutableListOf<Activity>()

    //向list中添加Activity
    fun pushActivity(activity: Activity): ActivityTaskManager {
        activityLinkedList.add(activity)
        return instance
    }

    //结束特定的Activity(s)
    fun finishActivities(vararg activityClasses: Class<out Activity>): ActivityTaskManager {
        activityLinkedList
                .filter { Arrays.asList(*activityClasses).contains(it.javaClass) }
                .forEach { it.finish() }
        return instance
    }

    //结束所有的Activities
    fun finishAllActivities(): ActivityTaskManager {
        activityLinkedList.forEach { activity -> activity.finish() }
        return instance
    }

    fun popActivity(activity: Activity) {
        activityLinkedList.remove(activity)
    }

    companion object {

        val instance = ActivityTaskManager()

    }
}