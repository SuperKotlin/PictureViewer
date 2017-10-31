package com.SuperKotlin.pictureviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片下载类，因为这里都是无压缩下载，为了避免ANR所以开启子线程下载
 */
public class ImageUtil {

    public static String path = "pictureviewer";//下载路径
    private static final int DOWNLOAD_SUCCESS = 0X11;
    private static final int DOWNLOAD_FAILD = 0X12;
    private static Context mContext;

    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == DOWNLOAD_SUCCESS) {
                Toast.makeText(mContext, (String) msg.obj, Toast.LENGTH_SHORT).show();
            } else if (msg.what == DOWNLOAD_FAILD) {
                Toast.makeText(mContext, "保存失败", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public static void saveImage(final Context context, String url, final Bitmap bitmap) {
        mContext = context;
        //保存路径
        String imgDir = "";
        if (checkSDCard()) {
            imgDir = Environment.getExternalStorageDirectory().getPath() + "/" + path;
        } else {
            imgDir = Environment.getDataDirectory().getPath() + "/" + path;
        }
        //图片名称处理
        String[] fileNameArr = url.substring(url.lastIndexOf("/") + 1).split("\\.");
        final String fileName = fileNameArr[0] + ".png";
        //创建文件路径
        File fileDir = new File(imgDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        //创建文件
        final File imageFile = new File(fileDir, fileName);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileOutputStream fos = new FileOutputStream(imageFile);
                    boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    if (compress) {
                        Message message = new Message();
                        message.what = DOWNLOAD_SUCCESS;
                        message.obj = "保存成功，路径/sd卡/" + path + "/" + fileName;
                        mHandler.sendMessage(message);
                    } else {
                        mHandler.sendEmptyMessage(DOWNLOAD_FAILD);
                    }
                    fos.flush();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    mHandler.sendEmptyMessage(DOWNLOAD_FAILD);
                } catch (IOException e) {
                    e.printStackTrace();
                    mHandler.sendEmptyMessage(DOWNLOAD_FAILD);
                } catch (Exception e) {
                    e.printStackTrace();
                    mHandler.sendEmptyMessage(DOWNLOAD_FAILD);
                }
            }
        }).start();

        Uri uri = Uri.fromFile(imageFile);
        //发送广播，通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
    }

    private static boolean checkSDCard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }
}
