package hc.com.app.ui.loginactivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hc.libs_base.ARouterAddressManager;
import com.hc.libs_base.BaseActivity;
import hc.com.app.R;

/**
 * Created by Administrator on 2018/4/13.
 * maek:hc
 */
@Route(path = ARouterAddressManager.APP_LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity {

    @Override
    public int intiView() {
        return R.layout.app_loginactivity_xml;
    }

    @Override
    public void findView() {

    }
}
