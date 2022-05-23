#### Java截图工具直接上传到阿里云对象存储

​		经常使用markdown编写博客或者文档的朋友们应该知道，需要上传照片到图床是一个很麻烦的时候，我们需要保存图片，然后上传到图床，然后复制地址放入markdown文件当中，市面上支持直接从剪贴板中插入文件的图床几乎都收费且价格很不划算，因此开发了一个工具，截图后直接上传到阿里云对象存储，并将返回的地址存入剪贴板直接使用。

##### 使用方法

对源码不感兴趣的朋友可以直接下载压缩包修改配置文件

![](https://facesearch-hoom.oss-cn-hangzhou.aliyuncs.com/face/09c57784-145a-4a9c-a3e5-ec3e13f45e60.jpg)

修改config中的文件

```yml
aliyun:
  endpoint: # 阿里云的节点地址
  keyid:  # 填写刚刚生成的AccessKey
  keysecret:   # 填写刚刚生成的Accesssecret
  bucketname:  # bucket名称
  filehost:     #bucket下文件夹的路径
```

点击bat运行软件（需要java环境）

![](https://facesearch-hoom.oss-cn-hangzhou.aliyuncs.com/face/aabd700a-55e6-4417-83a2-5e86cbd9a17b.jpg)

![](https://facesearch-hoom.oss-cn-hangzhou.aliyuncs.com/face/b09fc7ab-09d6-4047-a5f0-02d7e9e81968.jpg)