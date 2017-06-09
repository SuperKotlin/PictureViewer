##效果演示:

![](/art/PictureViewer.gif)

##如何使用:

		//这是你的数据
        List<String> list = new ArrayList<>();
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fgepc1lpvfj20u011i0wv.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fgdmpxi7erj20qy0qyjtr.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fgchgnfn7dj20u00uvgnj.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fgbbp94y9zj20u011idkf.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fga6auw8ycj20u00u00uw.jpg");
        list.add("https://ws1.sinaimg.cn/large/d23c7564ly1fg7ow5jtl9j20pb0pb4gw.jpg");
        list.add("https://ws1.sinaimg.cn/large/d23c7564ly1fg6qckyqxkj20u00zmaf1.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1fg5dany6uzj20u011iq60.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1ffyp4g2vwxj20u00tu77b.jpg");
        list.add("https://ws1.sinaimg.cn/large/610dc034ly1ffxjlvinj5j20u011igri.jpg");

		//使用方式
        PictureConfig config = new PictureConfig.Builder()
                 .setListData((ArrayList<String>) list)//图片数据List<String> list
                 .setPosition(0)//图片下标（从第position张图片开始浏览）
                 .setDownloadPath("pictureviewer")//图片下载文件夹地址
                 .needDownload(true)//是否支持图片下载
                 .setPlacrHolder(R.mipmap.icon)//占位符图片（图片加载完成前显示的资源图片，来源drawable或者mipmap）
                 .build();
         ImagePagerActivity.startActivity(MainActivity.this, config);


##如何添加依赖库:

```
	dependencies {
	        compile 'com.github.SuperKotlin:PictureViewer:1.0'
	}
	
```
##或者可以下载`Demo`提取`module`添加

