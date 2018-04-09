package hc.com.classify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.libs_base.ARouterAddressManager;

@Route(path = ARouterAddressManager.CLASSIFY_MAIN)
public class ClassifyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classify_mainactivity_xml);
        findViewById(R.id.classify_main_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterAddressManager.FOUND_MAIN).navigation();
            }
        });
    }
}
