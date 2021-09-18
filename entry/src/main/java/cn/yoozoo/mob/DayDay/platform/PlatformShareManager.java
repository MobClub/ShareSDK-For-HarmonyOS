package cn.yoozoo.mob.DayDay.platform;

/**
 * Created by yjin on 2017/6/19.
 */

import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.favorite.WechatFavorite;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.yoozoo.mob.DayDay.platform.sina.WeiboShare;
import cn.yoozoo.mob.DayDay.platform.tencent.qq.QQShare;
import cn.yoozoo.mob.DayDay.platform.tencent.qzone.QQZoneShare;
import cn.yoozoo.mob.DayDay.platform.wechat.favorite.WechatFavoriteShare;
import cn.yoozoo.mob.DayDay.platform.wechat.friends.WechatShare;
import cn.yoozoo.mob.DayDay.platform.wechat.moments.WechatMomentsShare;
import ohos.app.Context;

/**
 * 获取各个平台后进行分享的操作。
 */

public class PlatformShareManager {
    private Context context;
    private PlatformActionListener platformActionListener;

    public void setPlatformActionListener(PlatformActionListener platformActionListener) {
        this.platformActionListener = platformActionListener;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void shareText(String name) {
        if (name.equals(Wechat.NAME)) {
            WechatShare wechatShare = new WechatShare(platformActionListener);
            wechatShare.shareText(context);
        } else if (name.equals(WechatFavorite.NAME)) {
            WechatFavoriteShare wechatFavoriteShare = new WechatFavoriteShare(platformActionListener);
            wechatFavoriteShare.shareText();
        } else if (name.equals(WechatMoments.NAME)) {
            WechatMomentsShare wechatMomentsShare = new WechatMomentsShare(platformActionListener);
            wechatMomentsShare.shareText();
        } else if (name.equals(QZone.NAME)) {
            QQZoneShare qqZoneShare = new QQZoneShare(platformActionListener, context);
            qqZoneShare.shareText();
        } else if (name.equals(QQ.NAME)) {
            QQShare share = new QQShare(platformActionListener, context);
            share.shareText();
        } else if (name.equals(SinaWeibo.NAME)) {
            WeiboShare weiboShare = new WeiboShare(platformActionListener, context);
            weiboShare.shareText();
        }
    }

    public void shareImage(String name) {
        if (name.equals(Wechat.NAME)) {
            WechatShare wechatShare = new WechatShare(platformActionListener);
            wechatShare.shareImage(context);
        } else if (name.equals(WechatFavorite.NAME)) {
            WechatFavoriteShare wechatFavoriteShare = new WechatFavoriteShare(platformActionListener);
            wechatFavoriteShare.shareImage();
        } else if (name.equals(WechatMoments.NAME)) {
            WechatMomentsShare wechatMomentsShare = new WechatMomentsShare(platformActionListener);
            wechatMomentsShare.shareImage();
        } else if (name.equals(QZone.NAME)) {
            QQZoneShare qqZoneShare = new QQZoneShare(platformActionListener, context);
            qqZoneShare.shareImage();
        } else if (name.equals(QQ.NAME)) {
            QQShare share = new QQShare(platformActionListener, context);
            share.shareImage();
        } else if (name.equals(SinaWeibo.NAME)) {
            WeiboShare weiboShare = new WeiboShare(platformActionListener, context);
            weiboShare.shareImage();
        }
    }

    public void shareWebPager(String name) {
        if (name.equals(Wechat.NAME)) {
            WechatShare wechatShare = new WechatShare(platformActionListener);
            wechatShare.shareWebpager(context);
        } else if (name.equals(WechatMoments.NAME)) {
            WechatMomentsShare wechatShare = new WechatMomentsShare(platformActionListener);
            wechatShare.shareWebpager();
        } else if (name.equals(WechatFavorite.NAME)) {
            WechatFavoriteShare wechatFavoriteShare = new WechatFavoriteShare(platformActionListener);
            wechatFavoriteShare.shareWebpager();
        } else if (name.equals(QZone.NAME)) {
            QQZoneShare qqZoneShare = new QQZoneShare(platformActionListener, context);
            qqZoneShare.shareWebPager();
        } else if (name.equals(QQ.NAME)) {
            QQShare share = new QQShare(platformActionListener, context);
            share.shareWebPager();
        } else if (name.equals(SinaWeibo.NAME)) {
            WeiboShare share = new WeiboShare(platformActionListener, context);
            share.shareWebpager();
        }
    }

    public void shareVideo(String name) {
        if (name.equals(Wechat.NAME)) {
            WechatShare wechatShare = new WechatShare(platformActionListener);
            wechatShare.shareVideo(context);
        } else if (name.equals(WechatFavorite.NAME)) {
            WechatFavoriteShare wechatFavoriteShare = new WechatFavoriteShare(platformActionListener);
            wechatFavoriteShare.shareVideo();
        } else if (name.equals(WechatMoments.NAME)) {
            WechatMomentsShare wechatMomentsShare = new WechatMomentsShare(platformActionListener);
            wechatMomentsShare.shareVideo();
        } else if (name.equals(QZone.NAME)) {
            QQZoneShare qqZoneShare = new QQZoneShare(platformActionListener, context);
            qqZoneShare.shareVideo();
        } else if (name.equals(QQ.NAME)) {
            QQShare share = new QQShare(platformActionListener, context);
            share.shareVideo();
        }
        if (name.equals(SinaWeibo.NAME)) {
            WeiboShare weiboShare = new WeiboShare(platformActionListener, context);
            weiboShare.shareVideo();
        }
    }

    public void shareMusic(String name) {
        if (name.equals(Wechat.NAME)) {
            WechatShare wechatShare = new WechatShare(platformActionListener);
            wechatShare.shareMusic(context);
        } else if (name.equals(WechatFavorite.NAME)) {
            WechatFavoriteShare wechatFavoriteShare = new WechatFavoriteShare(platformActionListener);
            wechatFavoriteShare.shareMusic();
        } else if (name.equals(WechatMoments.NAME)) {
            WechatMomentsShare wechatMomentsShare = new WechatMomentsShare(platformActionListener);
            wechatMomentsShare.shareMusic();
        } else if (name.equals(QZone.NAME)) {
//
        } else if (name.equals(QQ.NAME)) {
            QQShare share = new QQShare(platformActionListener, context);
            share.shareMusic();
        }
    }


    public void shareQQMiniProgram(String name) {
        if (name.equals(QQ.NAME)) {
            QQShare qqShare = new QQShare(platformActionListener, context);
            qqShare.shareQQMiniProgram();
        }
        if (name.equals(QZone.NAME)) {
            QQZoneShare qqZoneShare = new QQZoneShare(platformActionListener, context);
            qqZoneShare.shareQQMiniProgram();
        }
    }

}
