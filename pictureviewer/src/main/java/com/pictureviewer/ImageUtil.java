package com.pictureviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ImageUtil {


    public static String path = "pictureviewer";//下载路径

    public static Uri saveImage(Context context, String url, Bitmap bitmap) {
        //保存路径
        String imgDir = Environment.getExternalStorageDirectory().getPath() + "/" + path;
        //图片名称处理
        String[] fileNameArr = url.substring(url.lastIndexOf("/") + 1).split("\\.");
        String fileName = fileNameArr[0] + ".png";
        //创建文件路径
        File fileDir = new File(imgDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        //创建文件
        File imageFile = new File(fileDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            if (compress) {
                Toast.makeText(context, "保存成功，路径/sd卡/" + path + "/" + fileName, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "保存失败", Toast.LENGTH_SHORT).show();
            }
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Uri uri = Uri.fromFile(imageFile);
        //发送广播，通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
        return uri;
    }
}
