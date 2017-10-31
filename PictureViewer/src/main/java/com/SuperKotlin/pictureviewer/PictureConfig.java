package com.SuperKotlin.pictureviewer;

import android.support.annotation.DrawableRes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhuyong on 2017/6/8.
 */

public class PictureConfig {
    public static boolean mIsShowNumber = true;//是否显示数字下标
    public static boolean needDownload = false;
    public static String path = "pictureviewer";
    public static int resId = 0;//占位符资源图片
    public static int position = 0;//下标
    public static ArrayList<String> list;

    public PictureConfig(Builder builder) {
        this.mIsShowNumber = builder.mIsShowNumber;
        this.needDownload = builder.needDownload;
        this.path = builder.path;
        this.resId = builder.resId;
        this.position = builder.position;
        this.list = builder.list;
    }

    public static class Builder implements Serializable {

        private boolean mIsShowNumber = true;//是否显示数字下标
        private boolean needDownload = false;
        private int resId = 0;
        private String path = "pictureviewer";
        private int position = 0;
        private ArrayList<String> list;

        public Builder() {
            super();
        }

        public Builder setListData(ArrayList<String> list) {
            this.list = list;
            return this;
        }

        public Builder setPosition(int position) {
            this.position = position;
            return this;
        }

        public Builder setIsShowNumber(boolean mIsShowNumber) {
            this.mIsShowNumber = mIsShowNumber;
            return this;
        }

        public Builder needDownload(boolean needDownload) {
            this.needDownload = needDownload;
            return this;
        }

        public Builder setDownloadPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setPlacrHolder(@DrawableRes int resId) {
            this.resId = resId;
            return this;
        }

        public PictureConfig build() {
            return new PictureConfig(this);
        }
    }

}
