package cn.yoozoo.mob.DayDay.platform.sina;

import android.text.TextUtils;

import cn.sharesdk.wechat.friends.Wechat;
import cn.yoozoo.mob.DayDay.utils.DemoUtils;
import cn.yoozoo.mob.DayDay.utils.ResourcesManager;
import com.mob.MobSDK;

import ohos.app.Context;
import org.json.JSONException;
import org.json.JSONObject;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;

import static cn.yoozoo.mob.DayDay.platform.wechat.friends.WechatShare.LINK_URL;

/**
 * Created by yjin on 2017/6/22.
 */

public class WeiboShare {
    private PlatformActionListener platformActionListener;
    private Context context;

    public WeiboShare(PlatformActionListener mListener, Context context) {
        this.context = context;
        this.platformActionListener = mListener;
    }

    public void shareText() {
        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareImage() {
        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        if (platform.isClientValid()) {
            Platform.ShareParams shareParams = new Platform.ShareParams();
            if (ResourcesManager.getInstace(context).getImagePath() == null) {
                shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
            } else {
                shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
            }
            shareParams.setText("sina image and text share   http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
            shareParams.setShareType(Platform.SHARE_IMAGE);
            shareParams.setLongitude(ResourcesManager.longitude);
            shareParams.setLatitude(ResourcesManager.latitude);
            platform.setPlatformActionListener(platformActionListener);
            platform.share(shareParams);
        } else {
             Platform.ShareParams shareParams = new Platform.ShareParams();
            shareParams.setText("sina image and text share   http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
            shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
            shareParams.setShareType(Platform.SHARE_IMAGE);
            platform.setPlatformActionListener(platformActionListener);
            platform.share(shareParams);
        }
    }

    public void shareVideo() {
        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setFilePath(ResourcesManager.getInstace(context).getFilePath());
        shareParams.setText("111111");
        shareParams.setShareType(Platform.SHARE_VIDEO);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }

    public void shareText(PlatformActionListener mListener) {
        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        if (!DemoUtils.isValidClientSina("com.sina.weibo")) {
            shareParams.setUrl(ResourcesManager.getInstace(context).getUrl());
        }
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

    public void shareImage(PlatformActionListener mListener) {
        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
        shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
        if (!DemoUtils.isValidClientSina("com.sina.weibo")) {
            shareParams.setUrl(ResourcesManager.getInstace(context).getUrl());
        }
        shareParams.setLongitude(ResourcesManager.longitude);
        shareParams.setLatitude(ResourcesManager.latitude);
        platform.setPlatformActionListener(mListener);
        platform.share(shareParams);
    }

    /**
     * 新浪linkcard分享
     **/
    public void shareLinkCard() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("url", "http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
            jsonObject.put("width", 120);
            jsonObject.put("height", 120);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setText("MobSDK 只为最优质的服务");
        sp.setLcCreateAt("2019-01-24");
        sp.setLcDisplayName("Mob-全球领先的第三方服务商");
        sp.setLcImage(jsonObject);
        sp.setLcSummary("不止是SDK");
        sp.setLcUrl("http://www.mob.com/");
        sp.setLcObjectType("webpage");
        platform.setPlatformActionListener(platformActionListener);
        platform.share(sp);
    }
    public void shareWebpager() {
        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
        shareParams.setUrl(LINK_URL);
        shareParams.setImageUrl("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg");
        shareParams.setShareType(Platform.SHARE_WEBPAGE);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }
}
