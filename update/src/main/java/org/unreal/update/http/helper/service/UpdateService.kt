package org.unreal.update.http.helper.service

import io.reactivex.Observable
import org.unreal.update.converter.FileConverter.Companion.SAVE_PATH
import retrofit2.http.Url
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Streaming
import java.io.File


/**
 * 作者：zhangqiwen
 * 2017/6/8 0008 09:49
 * 名称：
 */
interface UpdateService {
    @Streaming
    @GET
    fun downloadWithDynamicUrl(@Url downloadUrl: String, @Header(SAVE_PATH) path: String): Observable<File>
}