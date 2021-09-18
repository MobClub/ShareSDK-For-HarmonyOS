package cn.yoozoo.mob.DayDay.platform.tencent.qq;

import android.util.Log;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.yoozoo.mob.DayDay.utils.DemoUtils;
import cn.yoozoo.mob.DayDay.utils.ResourcesManager;
import ohos.app.Context;

import static cn.yoozoo.mob.DayDay.platform.wechat.friends.WechatShare.LINK_TEXT;
import static cn.yoozoo.mob.DayDay.platform.wechat.friends.WechatShare.LINK_URL;


/**
 * Created by yjin on 2017/6/22.
 */

public class QQShare {
    private PlatformActionListener platformActionListener;
    private Context context;

    public QQShare(PlatformActionListener mListener,Context context) {
        this.platformActionListener = mListener;
        this.context=context;
        String[] pks = {"com.tencent.mobileqq", "com.tencent.mobileqqi", "com.tencent.qqlite", "com.tencent.minihd.qq", "com.tencent.tim"};
        DemoUtils.isValidClient(pks);
    }
    public void shareText(){
        Platform platform = ShareSDK.getPlatform(QQ.NAME);
        Platform.ShareParams shareParams = new  Platform.ShareParams();
        shareParams.setText("Share SDK QQ文字分享");
        shareParams.setTitle("Share SDK QQ文字分享");
//        shareParams.setTitleUrl("http://www.baidu.com");//消息被点开之后的跳转界面
//        shareParams.setImageUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ffile.juzimi.com%2Fweibopic%2Fjrzdmi5.jpg&refer=http%3A%2F%2Ffile.juzimi.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1627206544&t=c008aa77edacce539807357a70201e53");
        platform.setPlatformActionListener(platformActionListener);
        shareParams.setShareType(Platform.SHARE_TEXT);
        platform.share(shareParams);
    }
    public void shareWebPager() {
        Platform platform = ShareSDK.getPlatform(QQ.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(LINK_TEXT);
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setTitleUrl(LINK_URL);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareImage() {
        Platform platform = ShareSDK.getPlatform(QQ.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        //shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        //Log.d("ShareSDK", " ImagePath " + ResourcesManager.getInstace(context).getImagePath());
        shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        platform.setPlatformActionListener(platformActionListener);
        shareParams.setShareType(Platform.SHARE_IMAGE);
        platform.share(shareParams);
    }

    public void shareMusic() {
        Platform platform = ShareSDK.getPlatform(QQ.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setTitleUrl(ResourcesManager.getInstace(context).getTitleUrl());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
        shareParams.setMusicUrl(ResourcesManager.getInstace(context).getMusicUrl());
        shareParams.setShareType(Platform.SHARE_MUSIC);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }


    public void shareQQMiniProgram() {
        Platform platform = ShareSDK.getPlatform(QQ.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText("QQ小程序");
        shareParams.setTitle("QQ互联");
        shareParams.setTitleUrl("http://www.qq.com/");
        shareParams.setImageUrl("http://www.3wyu.com/wp-content/uploads/6e0eaf15gy1fvr5tnm2dfj20f108gtad.jpg");
        shareParams.setShareType(Platform.QQ_MINI_PROGRAM);
        shareParams.setQQMiniProgramAppid("1108318575"); //官方的
        shareParams.setQQMiniProgramPath("page/share/index.html?share_name=QQ%E9%9F%B3%E4%B9%90&share_key=5aIqFGg&from=disk");
        shareParams.setQQMiniProgramType("");
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }
    public void shareVideo(){
        Platform platform = ShareSDK.getPlatform(QQ.NAME);
        Platform.ShareParams shareParams = new  Platform.ShareParams();
        shareParams.setTitle("QQ分享");
        shareParams.setFilePath(ResourcesManager.getInstace(context).getFilePath());
        shareParams.setShareType(Platform.SHARE_VIDEO);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

}
