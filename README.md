## 效果演示:

![](/art/PictureViewer.gif)

## 如何使用:

        //这是你的数据
        List<String> list = new ArrayList<>();
        //网络图片
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fgepc1lpvfj20u011i0wv.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fgdmpxi7erj20qy0qyjtr.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fgchgnfn7dj20u00uvgnj.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fgbbp94y9zj20u011idkf.jpg");
        //本地SD卡图片文件
        list.add("/storage/emulated/0/DCIM/Camera/IMG_20170126_113019.jpg");
        list.add("/storage/emulated/0/DCIM/Camera/IMG_20170126_113014.jpg");
        list.add("/storage/emulated/0/DCIM/Camera/IMG_20170126_114018.jpg");
        list.add("/storage/emulated/0/DCIM/Camera/IMG_20171031_152627.jpg");

		//使用方式
      	PictureConfig config = new PictureConfig.Builder()
               .setListData((ArrayList<String>) list)	//图片数据List<String> list
               .setPosition(0)	//图片下标（从第position张图片开始浏览）
               .setDownloadPath("pictureviewer")	//图片下载文件夹地址
               .setIsShowNumber(true)//是否显示数字下标
               .needDownload(true)	//是否支持图片下载
               .setPlacrHolder(R.mipmap.icon)	//占位符图片（图片加载完成前显示的资源图片，来源drawable或者mipmap）
               .build();
       	ImagePagerActivity.startActivity(MainActivity.this, config);


## 如何添加依赖库:

 - **Add it in your root build.gradle at the end of repositories:**

```
	    allprojects {
		   repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	    }
```


 -  **Add the dependency**
```
	dependencies {

	         compile 'com.github.SuperKotlin:PictureViewer:2.0.1'  //新版本

	         compile 'com.github.SuperKotlin:PictureViewer:1.0.1'	

	}

```


## 或者可以下载`Demo`提取`module`添加

# 更新记录:
## 版本2.0.1
 - 新增自定义数字下标显示和隐藏设置；

 - 图片加载框架由Picasso更换为Glide，支持对本地图片文件的加载，并且全部支持图片下载功能；

 - 解决在部分机型上虚拟键和数字下标重复的问题；

 - 优化代码体验，修复几个bug。


## 版本1.0.1
 - 第一版正式启用

### 关于我
 - 我的简书：[BraveJoy](http://www.jianshu.com/users/c96d2a9d160f/timeline)
 - 我的github：[SuperKotlin](https://github.com/SuperKotlin)