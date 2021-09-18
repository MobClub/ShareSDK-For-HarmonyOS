package cn.yoozoo.mob.DayDay.platform.tencent.qzone;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import cn.yoozoo.mob.DayDay.utils.DemoUtils;
import cn.yoozoo.mob.DayDay.utils.ResourcesManager;
import com.mob.MobSDK;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qzone.QZone;
import ohos.app.Context;

import static cn.yoozoo.mob.DayDay.platform.wechat.friends.WechatShare.LINK_TEXT;
import static cn.yoozoo.mob.DayDay.platform.wechat.friends.WechatShare.LINK_URL;


/**
 * Created by yjin on 2017/6/22.
 */

public class QQZoneShare {
	private PlatformActionListener platformActionListener;
    public static final int QZONE_VIDEO = 10082;
	private Context context;

	public void setContext(Context context) {
		this.context = context;
	}

	public QQZoneShare(PlatformActionListener mListener,Context context){
		setContext(context);
		this.platformActionListener = mListener;
		String [] pks = {"com.tencent.mobileqq","com.tencent.mobileqqi","com.tencent.qqlite","com.tencent.minihd.qq","com.tencent.tim"};
		DemoUtils.isValidClient(pks);
	}

	public void shareText(){
		Platform platform = ShareSDK.getPlatform(QZone.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText("Share SDK QQ空间文字分享");
		platform.setPlatformActionListener(platformActionListener);
		shareParams.setShareType(Platform.SHARE_TEXT);
		platform.share(shareParams);
	}

	public void shareWebPager(){
		Platform platform = ShareSDK.getPlatform(QZone.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(LINK_TEXT);
		shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
		shareParams.setUrl(LINK_URL);
		shareParams.setTitleUrl(ResourcesManager.getInstace(context).getTitleUrl());
		shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
		shareParams.setSite("ShareSDK test site");
		shareParams.setSiteUrl("https://www.mob.com");
		platform.setPlatformActionListener(platformActionListener);
		shareParams.setShareType(Platform.SHARE_WEBPAGE);
		platform.share(shareParams);
	}

	public void shareImage(){
		Platform platform = ShareSDK.getPlatform(QZone.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
		shareParams.setImageArray(ResourcesManager.getInstace(context).randomPic());
		shareParams.setText(ResourcesManager.getInstace(context).getText());
		shareParams.setShareTencentWeibo(false);
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

//    public void shareVideo(Activity activity) {
//        openSystemGallery(activity, QZONE_VIDEO);
//    }

    public void shareVideo(String videoPath){
        Platform platform = ShareSDK.getPlatform(QZone.NAME);
        Platform.ShareParams shareParams = new  Platform.ShareParams();
        shareParams.setFilePath(videoPath);
        Log.e("WWW", " 视频文件路径===》 " + videoPath);
        shareParams.setText(ResourcesManager.getInstace(context).getText());
        shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
        shareParams.setShareType(Platform.SHARE_VIDEO);
        platform.setPlatformActionListener(platformActionListener);
        platform.share(shareParams);
    }


//    private void openSystemGallery(final Activity activity, final int shareType) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setMessage("请选择视频").setPositiveButton("视频", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("video/*");
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
//                activity.startActivityForResult(intent, shareType);
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }

	public void shareText(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(QZone.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(context).getText());
		shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
		shareParams.setTitleUrl(ResourcesManager.getInstace(context).getTitleUrl());
		shareParams.setShareType(Platform.SHARE_TEXT);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareWebPager(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(QZone.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setText(ResourcesManager.getInstace(context).getText());
		shareParams.setTitle(ResourcesManager.getInstace(context).getTitle());
		shareParams.setUrl(ResourcesManager.getInstace(context).getUrl());
		shareParams.setShareType(Platform.SHARE_WEBPAGE);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareImage(PlatformActionListener mListener){
		Platform platform = ShareSDK.getPlatform(QZone.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setImagePath(ResourcesManager.getInstace(context).getImagePath());
		shareParams.setImageUrl(ResourcesManager.getInstace(context).getImageUrl());
		shareParams.setShareType(Platform.SHARE_IMAGE);
		platform.setPlatformActionListener(mListener);
		platform.share(shareParams);
	}

	public void shareVideo(){
		Platform platform = ShareSDK.getPlatform(QZone.NAME);
		Platform.ShareParams shareParams = new  Platform.ShareParams();
		shareParams.setFilePath(ResourcesManager.getInstace(context).getFilePath());
		shareParams.setShareType(Platform.SHARE_VIDEO);
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

	public void shareQQMiniProgram() {
		Platform platform = ShareSDK.getPlatform(QZone.NAME);
		Platform.ShareParams shareParams = new Platform.ShareParams();
		shareParams.setText("QQ小程序");
		shareParams.setTitle("QQ互联");
		shareParams.setTitleUrl("http://www.qq.com/");
		shareParams.setImageUrl("http://www.3wyu.com/wp-content/uploads/6e0eaf15gy1fvr5tnm2dfj20f108gtad.jpg");
		shareParams.setShareType(Platform.QQ_MINI_PROGRAM);
		shareParams.setQQMiniProgramAppid("1108318575");
		shareParams.setQQMiniProgramPath("page/share/index.html?share_name=QQ%E9%9F%B3%E4%B9%90&share_key=5aIqFGg&from=disk");
		shareParams.setQQMiniProgramType("");
		platform.setPlatformActionListener(platformActionListener);
		platform.share(shareParams);
	}

}
