package unreal.org.ktapp.http.service

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

/**
 * <b>类名称：</b> UserService <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年05月25日 14:27<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
interface UserService{
    @GET("login")
    fun login() : Observable<Response<Unit>>
}