package hc.com.app;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.libs_base.ARouterAddressManager;
import com.hc.libs_base.BaseActivity;
import com.hc.libs_base.database.realm.RealmSql;

/**
 *
 */

@Route(path = ARouterAddressManager.APP_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {
    public static final String TAG = "MainActivity";


    @Override
    public int intiView() {
        return R.layout.activity_main;
    }

    @Override
    public void findView() {
        findViewById(R.id.app_main_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterAddressManager.HOME_MAIN_HOME).navigation();
//                RealmSql realmSql = new RealmSql();
//                realmSql.saveExecuteTransactionAsync(new Object());
            }
        });
    }

}
