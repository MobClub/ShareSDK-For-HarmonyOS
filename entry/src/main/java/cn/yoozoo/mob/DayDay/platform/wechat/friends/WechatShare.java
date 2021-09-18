package cn.yoozoo.mob.DayDay.platform.wechat.friends;


import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import cn.yoozoo.mob.DayDay.utils.DemoUtils;
import cn.yoozoo.mob.DayDay.utils.ResourcesManager;
import ohos.app.Context;

import static cn.yoozoo.mob.DayDay.utils.ResourcesManager.IMAGE_TEST_URL;


/**
 * Created by yjin on 2017/6/22.
 */

public class WechatShare {

    private PlatformActionListener platformActionListener;
    public final static String LINK_URL = "http://www.baidu.com";
    //public final static String LINK_URL = "http://m.93lj.com/sharelink?mobid=ziqMNf";
    public final static String LINK_TEXT = "loopShare 重磅上线！一键实现分享闭环！错过它，就错过了全世界~";
    private Context context;
    public WechatShare(PlatformActionListener mListener) {
        this.platformActionListener = mListener;
        DemoUtils.isValidClient("com.tencent.mm");
    }

    public void shareText(Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setShareType(Platform.SHARE_TEXT);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareImage(Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setImageUrl(IMAGE_TEST_URL);
        //shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        //Log.e("WWW", "imagePath ===> " + ResourcesManager.getInstace(context).getImagePath());
        shareParams.setShareType(Platform.SHARE_IMAGE);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareMusic(Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setImageUrl(IMAGE_TEST_URL);
        shareParams.setMusicUrl(ResourcesManager.getInstace(context).getMusicUrl());
        shareParams.setUrl(ResourcesManager.getInstace(context).getMusicUrl());
        shareParams.setShareType(Platform.SHARE_MUSIC);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareVideo(Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setUrl("http://www.mob.com/video/ShareSDK.mp4");
        shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        shareParams.setShareType(Platform.SHARE_VIDEO);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareWebpager(Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setUrl(LINK_URL);
        shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

//	public void shareApps(){
//		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
//		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setFilePath(ResourcesManager.getInstace(context).getFilePath());
//		shareParams.setText(ResourcesManager.getInstace(context).getText());
//		shareParams.setShareType(Platform.SHARE_APPS);
//		shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
//		shareParams.setExtInfo(ResourcesManager.EXT_INFO);
//		shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
//		platform.setPlatformActionListener(platformActionListener);
//		platform.share(shareParams);
//	}

    /**
     * 不展示分享文件，因为微信有可能废弃这个API
     **/
    public void shareFile(Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setFilePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setImageUrl(IMAGE_TEST_URL);
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setShareType(Platform.SHARE_FILE);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareText(PlatformActionListener mListener, Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setShareType(Platform.SHARE_TEXT);
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

    public void shareImage(PlatformActionListener mListener, Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
        shareParams.setImageData(ResourcesManager.getInstace(context).getImageBmp());
        shareParams.setShareType(Platform.SHARE_IMAGE);
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

    public void shareMusic(PlatformActionListener mListener, Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
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

    public void shareVideo(PlatformActionListener mListener, Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setUrl("http://www.mob.com/video/ShareSDK.mp4");
        if (ResourcesManager.getInstace(context).getImagePath() == null) {
            shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        } else {
            shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        }
        shareParams.setScence(0);
        shareParams.setShareType(Platform.SHARE_VIDEO);
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

    public void shareWebpager(PlatformActionListener mListener, Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setFilePath(ResourcesManager.getInstace(context).getFilePath());
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setUrl(ResourcesManager.getInstace(context).getUrl());
        shareParams.setImageData(ResourcesManager.getInstace(context).getImageBmp());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

//	public void shareApps(PlatformActionListener mListener){
//		Platform platform = ShareSDK.getPlatform(Wechat.NAME);
//		Platform.ShareParams shareParams = new  Platform.ShareParams();
//		shareParams.setFilePath(ResourcesManager.getInstace(context).getFilePath());
//		shareParams.setText(ResourcesManager.getInstace(context).getText());
//		shareParams.setShareType(Platform.SHARE_APPS);
//		shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
//		shareParams.setExtInfo(ResourcesManager.EXT_INFO);
//		shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
//		platform.setPlatformActionListener(mListener);
//		platform.share(shareParams);
//	}

    public void shareFile(PlatformActionListener mListener, Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setFilePath(ResourcesManager.getInstace(context).getFilePath());
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setShareType(Platform.SHARE_FILE);
        shareParams.setImageData(ResourcesManager.getInstace(context).getImageBmp());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

    public void shareEmoji(Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setImageData(ResourcesManager.getInstace(context).getImageBmp());
        shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
        shareParams.setShareType(Platform.SHARE_EMOJI);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareMiniProgram( Context context) {
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setUrl(ResourcesManager.getInstace(context).getUrl());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        shareParams.setImageData(ResourcesManager.getInstace(context).getImageBmp());
        shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
        shareParams.setShareType(Platform.SHARE_WXMINIPROGRAM);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }
}
