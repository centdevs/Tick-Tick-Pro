package app.devzeus.ticktickpro.xposed

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage


class HookActivity: IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        if(lpparam?.packageName == appPackageName) {
            // unlock isPro() [first]
            XposedBridge.log("Tick Tick App found. Starting hook")
            XposedHelpers.findAndHookMethod(
                classOnePro, lpparam.classLoader, methodNamePro, object : XC_MethodHook() {
                    override fun afterHookedMethod(param: MethodHookParam?) {
                        super.afterHookedMethod(param)
                        param?.result = true
                        XposedBridge.log("DEVZEUS(ticktick pro) >>>>> Hooked isPro() [first method]")
                    }
                }
            )

            //unlock isPro() [second]
            XposedHelpers.findAndHookMethod(
                classTwoPro, lpparam.classLoader, methodNamePro, object : XC_MethodHook() {
                    override fun afterHookedMethod(param: MethodHookParam?) {
                        super.afterHookedMethod(param)
                        param?.result = true
                        XposedBridge.log("DEVZEUS(ticktick pro) >>>>> Hooked isPro() [second method]")
                    }
                }
            )

            // unlock themes
            XposedHelpers.findAndHookMethod(
                themeClass, lpparam.classLoader, themeMethod, object : XC_MethodHook() {
                    override fun afterHookedMethod(param: MethodHookParam?) {
                        super.afterHookedMethod(param)
                        param?.result = false
                        XposedBridge.log("DEVZEUS(ticktick pro) >>>>> Unlocked all themes")
                    }
                }
            )


        }
    }

    companion object {
        val appPackageName = "com.ticktick.task"
        val classOnePro = "$appPackageName.network.sync.common.model.SignUserInfo"
        val classTwoPro = "$appPackageName.network.sync.model.User7ProModel"
        val themeClass = "$appPackageName.model"
        val themeMethod = "isLockedTheme"
        val methodNamePro = "isPro"
    }
}