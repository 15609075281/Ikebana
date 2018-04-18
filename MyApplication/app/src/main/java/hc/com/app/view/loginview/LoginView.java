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
     * 获取验证码
     *
     * @return
     */
    public abstract String getCode();

    /**
     * 获取密码
     *
     * @return
     */
    public abstract String getPassWord();

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
