package hc.com.app.persen.loginpersen;

import hc.com.app.module.loginmodule.LoginModule;
import hc.com.app.module.loginmodule.loginmoduleimp.LoginModuleImp;
import hc.com.app.view.loginview.LoginView;

/**
 * Created by Administrator on 2018/4/18.
 * mark:hc
 */
public class LoginPersen {
   //ui界面
    private LoginView loginView;
    //逻辑处理
    private LoginModule loginModule;

    public LoginPersen(LoginView loginView) {
        this.loginView = loginView;
        loginModule = new LoginModule();
    }

    /**
     * 模拟登录
     */
    public void onLogin() {
        loginModule.OnLoginLister(loginView.getUsername(), loginView.getPassWord(), new LoginModuleImp.OnLoginLister() {
            @Override
            public void OnSuccess(String result) {
                loginView.setOnSuccess(result);
            }

            @Override
            public void OnError(String error) {
                loginView.setOnError(error);
            }
        });
    }
}
