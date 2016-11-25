XPlayer
====
[Demo apk download](http://fir.im/j2af)
<br><br>
[解码库下载](http://pan.baidu.com/share/link?shareid=875905087&uk=3356128450)
<br>
use
====
In this App,load phone storage all video files based on [MediaLoader](https://github.com/jiajunhui/MediaLoader)
<br>
```java
/** application中边播边缓存的配置*/
public class XPlayerApplication extends XUIApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initHttpCache();
    }

    private void initHttpCache() {
        HttpCacheSetting.initHttpCache(this,
                new HttpCacheSetting.CacheConfig()
                        .setCacheDir(getExternalCacheDir())
                        .setMaxFileCount(1000)
                        .setMaxCacheSize(2000*1024*1024)
                        .setFileNameGenerator(new Md5FileNameGenerator()));
    }
}
```
<br>

```java
/** 播放器的相关设置 */
/** 设置解码模式*/
mXPlayer.setDecodeMode(new PlayerMenu().getDecodeMode(decodeMode));
/** 设置渲染视图类型*/
mXPlayer.setViewType(ViewType.SURFACEVIEW);
/** 播放事件监听*/
mXPlayer.setOnPlayerEventListener(this);
/** 播放错误监听*/
mXPlayer.setOnErrorListener(this);
/** 启用边播变缓存*/
HttpProxyCacheServer httpProxyCacheServer = HttpCacheSetting.getHttpProxyCacheServer();
if(httpProxyCacheServer!=null && !isLocal){
    url = httpProxyCacheServer.getProxyUrl(url);
}
/** 播放指定的资源*/
mXPlayer.setData(url);
/** 启动播放*/
mXPlayer.start();

/** 注册加载监听*/
mXPlayer.setOnLoadingTimerChangeListener(new BaseBindControllerPlayer.OnLoadingTimerChangeListener() {
            @Override
            public void onLoadingTimeCounter(int seconds) {

            }

            @Override
            public void onLoadingTimeout() {

            }
        });

/** 注册网络变化监听*/
mXPlayer.setOnNetWorkStateChangeListener(new BasePlayerController.OnNetWorkStateChangeListener() {
            @Override
            public void onNetWorkError() {

            }

            @Override
            public void onNetWorkConnected() {

            }

            @Override
            public int getErrorIconResId() {
                return 0;
            }

            @Override
            public String getErrorTipText() {
                return null;
            }
        });

/** 播放控制组件的状态监听*/
mXPlayer.setOnControllerStateChangeListener(new BasePlayerController.OnControllerStateChangeListener() {
            @Override
            public void onPlayControllerShow() {

            }

            @Override
            public void onPlayControllerHidden() {

            }
        });

/** 播放状态变化的监听*/
mXPlayer.setOnPlayStateChangeListener(new BaseBindControllerPlayer.OnPlayStateChangeListener() {
            @Override
            public void onUserPaused() {

            }

            @Override
            public void onUserResumed() {

            }

            @Override
            public void onSourceChanged(boolean isFrontVideo) {

            }

            @Override
            public void onPlayerStop() {

            }

            @Override
            public void onPlayerRePlay() {

            }
        });

/** 手势监听*/
mXPlayer.setOnGestureTapListener(new BaseBindControllerPlayer.OnGestureTapListener() {
            @Override
            public void onGestureSingleTap() {

            }

            @Override
            public void onGestureDoubleTap() {

            }
        });


```
<br>
<br>
有问题请联系 email : junhui_jia@163.com
