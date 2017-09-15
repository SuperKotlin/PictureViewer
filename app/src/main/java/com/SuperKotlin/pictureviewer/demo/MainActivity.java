package com.SuperKotlin.pictureviewer.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.SuperKotlin.pictureviewer.ImagePagerActivity;
import com.SuperKotlin.pictureviewer.PictureConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo
 */
public class MainActivity extends AppCompatActivity {
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");
        list.add("/storage/emulated/0/tencent/MicroMsg/WeiXin/mmexport1504885724246.jpg");

        findViewById(R.id.btn_picture_viewer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureConfig config = new PictureConfig.Builder()
                        .setListData((ArrayList<String>) list)//图片数据List<String> list
                        .setmIsLoaclPicture(true)//是否是本地图片
                        .setPosition(0)//图片下标（从第position张图片开始浏览）
                        .setDownloadPath("pictureviewer")//图片下载文件夹地址
                        .needDownload(true)//是否支持图片下载
                        .setPlacrHolder(R.mipmap.icon)//占位符图片（图片加载完成前显示的资源图片，来源drawable或者mipmap）
                        .build();
                ImagePagerActivity.startActivity(MainActivity.this, config);
            }
        });
    }
}
