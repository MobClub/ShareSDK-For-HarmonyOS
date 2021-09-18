package cn.yoozoo.mob.DayDay.manager.share;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import cn.yoozoo.mob.DayDay.platform.PlatformShareManager;
import cn.yoozoo.mob.DayDay.platform.wechat.friends.WechatShare;
import com.mob.MobSDK;

import java.util.HashMap;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import ohos.app.AbilityContext;
/**
 * Created by yjin on 2017/5/17.
 * 分享的操作类，各个平台的分享代码写在这里。
 * 这里可以直接拷贝代码，粘贴到合适的位置。
 */

public class ShareTypeManager {
    private AbilityContext context = null;
    private MyPlatformActionListener myPlatformActionListener = null;

    public ShareTypeManager(AbilityContext context) {
        this.context = context;
        myPlatformActionListener = new MyPlatformActionListener();
    }

    public void shareText(Platform platform) {
        PlatformShareManager platformShareManager = new PlatformShareManager();
        platformShareManager.setContext(context);
        platformShareManager.setPlatformActionListener(myPlatformActionListener);
        platformShareManager.shareText(platform.getName());
    }

    public void shareVideo(Platform platform) {
        PlatformShareManager platformShareManager = new PlatformShareManager();
        platformShareManager.setContext(context);
        platformShareManager.setPlatformActionListener(myPlatformActionListener);
        platformShareManager.shareVideo(platform.getName());
    }

    public void shareImage(Platform platform) {
        PlatformShareManager platformShareManager = new PlatformShareManager();
        platformShareManager.setContext(context);
        platformShareManager.setPlatformActionListener(myPlatformActionListener);
        platformShareManager.shareImage(platform.getName());
    }


    public void shareMiniProgram(Platform platform) {
        WechatShare wechatShare = new WechatShare(myPlatformActionListener);
        wechatShare.shareMiniProgram(context);
    }

    public void shareWebPage(Platform platform ) {
        PlatformShareManager platformShareManager = new PlatformShareManager();
        platformShareManager.setPlatformActionListener(myPlatformActionListener);
        platformShareManager.setContext(context);
        platformShareManager.shareWebPager(platform.getName());
    }

    public void shareMusic(Platform platform) {
        PlatformShareManager platformShareManager = new PlatformShareManager();
        platformShareManager.setContext(context);
        platformShareManager.setPlatformActionListener(myPlatformActionListener);
        platformShareManager.shareMusic(platform.getName());
    }


    /**
     * share QQ mini program
     * **/
    public void shareQQMiniProgram(Platform platform) {
        PlatformShareManager platformShareManager = new PlatformShareManager();
        platformShareManager.setPlatformActionListener(myPlatformActionListener);
        platformShareManager.shareQQMiniProgram(platform.getName());
    }


    class MyPlatformActionListener implements PlatformActionListener {
        @Override
        public void onComplete(final Platform platform, int i, HashMap<String, Object> hashMap) {
            context.getUITaskDispatcher().asyncDispatch(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MobSDK.getContext(), "Share Complete", Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public void onError(final Platform platform, int i, Throwable throwable) {
            throwable.printStackTrace();
            final String error = throwable.toString();
            context.getUITaskDispatcher().asyncDispatch(new Runnable() {
                @Override
                public void run() {
                    try {
                        //if (platform.getName().equals("Douyin")) {
                            //Toast.makeText(MobSDK.getContext(), "Share Failure" + error, Toast.LENGTH_LONG).show();
                        //} else if (contextThis != null) {
                            //dialog(contextThis, "Share Failure" + error);
                        //} else {
                            Toast.makeText(MobSDK.getContext(), "Share Failure" + error, Toast.LENGTH_LONG).show();
                        //}
                    } catch (Throwable t) {
                        Log.e("QQQ", " ShareTypeManager  onError===> " + t);
                    }
                }
            });
        }

        @Override
        public void onCancel(Platform platform, int i) {
            try {
                //if (platform.getName().equals("Douyin")) {
                    //Toast.makeText(MobSDK.getContext(), "Cancel Share", Toast.LENGTH_LONG).show();
                //} else if (contextThis != null) {
                    //dialog(contextThis, "Cancel Share");
                //} else {
                    Toast.makeText(MobSDK.getContext(), "Cancel Share", Toast.LENGTH_LONG).show();
                //}
            } catch (Throwable t) {
                Log.e("QQQ", " ShareTypeManager  onCancel===> " + t);
            }
        }
    }

}
