package cn.ikan.libs.player.inter;

/**
 * Created by Taurus on 2016/8/30.
 */
public interface OnPlayerEventListener {
    /** when player ready to start*/
    int EVENT_CODE_ON_INTENT_TO_START = 10000;
    /** when player prepared*/
    int EVENT_CODE_PREPARED = 20000;
    /** when video info ready , such as video rate info and so on.*/
    int EVENT_CODE_VIDEO_INFO_READY = 20001;
    /** when player start render screen*/
    int EVENT_CODE_RENDER_START = 20002;
    /** when the network is not good, start buffering*/
    int EVENT_CODE_BUFFERING_START = 20003;
    /** buffering end*/
    int EVENT_CODE_BUFFERING_END = 20004;
    /** when seek over call this event code*/
    int EVENT_CODE_SEEK_COMPLETE = 20005;
    /** when play video complete*/
    int EVENT_CODE_PLAY_COMPLETE = 20006;
    /** when player paused*/
    int EVENT_CODE_PLAY_PAUSE = 20007;
    /** when player resumed*/
    int EVENT_CODE_PLAY_RESUME = 20008;
    /** when change video definition*/
    int EVENT_CODE_PLAYER_CHANGE_DEFINITION = 20010;
    /** when seek to */
    int EVENT_CODE_PLAYER_SEEK_TO = 20011;
    /** when player set datat*/
    int EVENT_CODE_PLAYER_ON_SET_DATA_SOURCE = 20012;
    /** when player stop*/
    int EVENT_CODE_PLAYER_ON_STOP = 20013;

    void onPlayerEvent(int eventCode);
}
