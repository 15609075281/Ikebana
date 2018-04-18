package hc.com.app.module.loginmodule;

import hc.com.app.module.loginmodule.loginmoduleimp.LoginModuleImp;

/**
 * Created by Administrator on 2018/4/18.
 */
public class LoginModule implements LoginModuleImp {


    @Override
    public void OnLoginLister(String username, String password, OnLoginLister onLoginLister) {
        if (username.equals(password)) {
            onLoginLister.OnSuccess("登录成功");
        } else {
            onLoginLister.OnError("登录失败");
        }
    }
}
