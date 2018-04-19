package hc.com.app.view.loginview;

/**
 * Created by Administrator on 2018/4/18.
 * mark:hc
 */
public interface LoginView {

    /**
     * 获取用户名
     *
     * @return
     */
    public abstract String getUsername();

    /**
     * 获取验证码_状态按钮
     *
     * @return
     */
    public abstract void setCode_txt(String code);
    public abstract void setCode(String code);

    /**
     *获取验证码
     * @return
     */
    public abstract String getCodeInput();

    /**
     * 成功反馈
     *
     * @param success
     */
    public abstract void setOnSuccess(String success);

    /**
     * 失败反馈
     *
     * @param error
     */
    public abstract void setOnError(String error);

}
