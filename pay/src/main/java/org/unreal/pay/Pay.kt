package org.unreal.pay

import android.app.Activity
import android.content.Intent
import org.unreal.pay.alipay.AliPayImplement
import org.unreal.pay.union.UnionBankPayImplement
import org.unreal.pay.weixin.WeiXinPayImplement

/**
 * <b>类名称：</b> Pay <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2017年06月01日 17:01<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
sealed class Pay {
    class WeiXinPay private constructor(val activity: Activity,
                                        val appId: String,
                                        val partnerId: String,
                                        val prepayId: String,
                                        val packageValue: String,
                                        val nonceStr: String,
                                        val timeStamp: String,
                                        val sign: String,
                                        val signType: String) : Pay() {

        private constructor(builder: Builder) :
                this(builder.activity,
                        builder.appId,
                        builder.partnerId,
                        builder.prepayId,
                        builder.packageValue,
                        builder.nonceStr,
                        builder.timeStamp,
                        builder.sign,
                        builder.signType)

        companion object {
            fun build(init: Builder.() -> Unit) = Builder(init).build()
        }

        class Builder private constructor() {
            constructor(init: Builder.() -> Unit) : this() {
                init()
            }

            lateinit var activity: Activity
            lateinit var appId: String
            lateinit var partnerId: String
            lateinit var prepayId: String
            lateinit var packageValue: String
            lateinit var nonceStr: String
            lateinit var timeStamp: String
            lateinit var signType: String
            lateinit var sign: String

            fun activity(init: Builder.() -> Activity) = apply { activity = init() }
            fun appId(init: Builder.() -> String) = apply { appId = init() }
            fun partnerId(init: Builder.() -> String) = apply { partnerId = init() }
            fun prepayId(init: Builder.() -> String) = apply { prepayId = init() }
            fun packageValue(init: Builder.() -> String) = apply { packageValue = init() }
            fun nonceStr(init: Builder.() -> String) = apply { nonceStr = init() }
            fun timeStamp(init: Builder.() -> String) = apply { timeStamp = init() }
            fun signType(init: Builder.() -> String) = apply { signType = init() }
            fun sign(init: Builder.() -> String) = apply { sign = init() }

            fun build() = WeiXinPay(this)
        }
    }

    class UnionBankPay private constructor(val activity: Activity,
                                           val tradeCode: String,
                                           val serverModel: String) : Pay() {
        private constructor(builder: Builder) : this(builder.activity,
                builder.tradeCode,
                builder.serverModel)

        companion object {
            fun build(init: Builder.() -> Unit) = Builder(init).build()
        }

        class Builder private constructor() {
            constructor(init: Builder.() -> Unit) : this() {
                init()
            }

            lateinit var activity: Activity
            lateinit var tradeCode: String
            lateinit var serverModel: String

            fun activity(init: Builder.() -> Activity) = apply { activity = init() }
            fun tradeCode(init: Builder.() -> String) = apply { tradeCode = init() }
            fun serverModel(init: Builder.() -> String) = apply { serverModel = init() }

            fun build() = UnionBankPay(this)
        }
    }

    class AliPay private constructor(val activity: Activity,
                 val order: String) : Pay(){
        constructor(builder : Builder) : this(builder.activity ,
        builder.order)

        companion object{
            fun build(init : Builder.() -> Unit) = Builder(init).build()
        }

        class Builder private constructor(){
            constructor(init: Builder.() -> Unit) : this() {
                init()
            }
            lateinit var activity: Activity
            lateinit var order: String

            fun activity(init: Builder.() -> Activity) = apply { activity = init() }
            fun order(init: Builder.() -> String) = apply { order = init() }

            fun build() = AliPay(this)
        }
    }
}

interface PayFunction {
    fun checkPluginState(onCheckState: (Boolean) -> Unit)
    fun payment()
    fun filterResult(result: Intent?)
}

fun payment(payOrder: Pay, onSuccess: () -> Unit, onError: (String) -> Unit): PayFunction {
    val functions: PayFunction
    when (payOrder) {
        is Pay.WeiXinPay -> {
            functions = WeiXinPayImplement(payOrder, onSuccess, onError)
        }
        is Pay.UnionBankPay -> {
            functions = UnionBankPayImplement(payOrder, onSuccess, onError)
        }
        is Pay.AliPay -> {
            functions = AliPayImplement(payOrder, onSuccess, onError)
        }
    }
    functions.payment()
    return functions

}



