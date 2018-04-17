package hc.com.classify;


import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.libs_base.ARouterAddressManager;
import com.hc.libs_base.BaseFragment;

@Route(path = ARouterAddressManager.CLASSIFY_MAIN)
public class ClassifyMainActivity extends BaseFragment {


    @Override
    public int intiView() {
        return R.layout.classify_mainactivity_xml;
    }

    @Override
    public void findView() {
        view.findViewById(R.id.classify_main_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterAddressManager.FOUND_MAIN).navigation();
            }
        });
    }
}
