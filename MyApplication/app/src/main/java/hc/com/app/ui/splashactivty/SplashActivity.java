package hc.com.app.ui.splashactivty;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.libs_base.ARouterAddressManager;
import com.hc.libs_base.BaseActivity;
import hc.com.app.R;

/**
 * Created by Administrator on 2018/4/13.
 * mark:hc
 */
@Route(path = ARouterAddressManager.APP_SPLASH_ACTIVITY)
public class SplashActivity extends BaseActivity {
    @Override
    public int intiView() {
        return R.layout.app_splashactivity_xml;
    }

    @Override
    public void findView() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ARouter.getInstance().build(ARouterAddressManager.APP_LOGIN_ACTIVITY).navigation();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
