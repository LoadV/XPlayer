package cn.ikan.libs.player.inter;

/**
 * Created by Taurus on 2016/8/30.
 */
public interface OnErrorListener {

    int ERROR_CODE_COMMON = 30001;
    int ERROR_CODE_NET_ERROR = 30002;

    void onError(int errorCode);
}
