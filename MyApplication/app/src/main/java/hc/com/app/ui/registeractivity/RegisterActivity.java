package hc.com.app.ui.registeractivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hc.libs_base.ARouterAddressManager;
import com.hc.libs_base.BaseActivity;
import hc.com.app.R;

/**
 * Created by Administrator on 2018/4/13.
 * mark:hc
 */
@Route(path = ARouterAddressManager.APP_REGISTER_ACTIVITY)
public class RegisterActivity extends BaseActivity {
    @Override
    public int intiView() {
        return  R.layout.app_registeractivity_xml;
    }

    @Override
    public void findView() {

    }
}
