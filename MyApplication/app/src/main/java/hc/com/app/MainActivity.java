package hc.com.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.libs_base.ARouterAddressManager;
import com.hc.libs_base.MyApplication;

@Route(path = ARouterAddressManager.APP_MAIN)
public class MainActivity extends AppCompatActivity {

    public static  final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.app_main_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ARouter.init(new MyApplication());
                Log.e(TAG,"开始1");
                ARouter.getInstance().build(ARouterAddressManager.APP_TEST).navigation();
                Log.e(TAG,"结束");
            }
        });

    }
}
