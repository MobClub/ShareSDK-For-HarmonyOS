package cn.yoozoo.mob.DayDay.platform.wechat.moments;
;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.yoozoo.mob.DayDay.utils.DemoUtils;
import cn.yoozoo.mob.DayDay.utils.ResourcesManager;
import ohos.app.Context;

import static cn.yoozoo.mob.DayDay.platform.wechat.friends.WechatShare.LINK_URL;


/**
 * Created by yjin on 2017/6/22.
 */

public class WechatMomentsShare {
    private PlatformActionListener platformActionListener;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public WechatMomentsShare(PlatformActionListener mListener) {
        this.platformActionListener = mListener;
        DemoUtils.isValidClient("com.tencent.mm");
    }

    public void shareText() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setShareType(Platform.SHARE_TEXT);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareImage() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        if (ResourcesManager.getInstace(context).getImagePath() == null) {
            shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        } else {
            shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        }
        shareParams.setShareType(Platform.SHARE_IMAGE);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareMusic() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        if (ResourcesManager.getInstace(context).getImagePath() == null) {
            shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        } else {
            shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        }
        shareParams.setUrl(ResourcesManager.getInstace(context).getMusicUrl());
        shareParams.setShareType(Platform.SHARE_MUSIC);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareVideo() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setUrl("http://www.mob.com/video/ShareSDK.mp4");
        if (ResourcesManager.getInstace(context).getImagePath() == null) {
            shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        } else {
            shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        }
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setShareType(Platform.SHARE_VIDEO);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareWebpager() {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setFilePath(ResourcesManager.getInstace(context).getFilePath());
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setUrl(LINK_URL);//ResourcesManager.getInstace(context).getUrl()
        shareParams.setImageData(ResourcesManager.getInstace(context).getImageBmp());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }


    public void shareImage(PlatformActionListener mListener) {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        if (ResourcesManager.getInstace(context).getImagePath() == null) {
            shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        } else {
            shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        }
        shareParams.setShareType(Platform.SHARE_IMAGE);
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

    public void shareMusic(PlatformActionListener mListener) {
        Platform platform = ShareSDK.getPlatform(WechatMoments.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
        shareParams.setUrl(ResourcesManager.getInstace(context).getUrl());
        shareParams.setMusicUrl(ResourcesManager.getInstace(context).getMusicUrl());
        shareParams.setShareType(Platform.SHARE_MUSIC);
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

}
