# Blog_SSM
我的个人博客，已使用SSM框架重构，可以后台管理博客内容。基于Docker部署，使用Nginx作为负载均衡。
前端使用 Materialize，使用Maven作为项目管理工具，版本控制使用Git，开发工具使用Intellij IDEA。
数据库使用 MySQL搭建了主主互备的数据库系统，数据库连接池使用Druid，使用Redis sentinel搭建了主从复制的缓存系统。


项目旧地址为https://github.com/Esieve/Blog

博客网址为http://www.esieve.me
- [x] JDK1.8
- [x] Docker部署
- [x] 文本编辑CKEditor
- [x] ~~评论模块接入网易云跟帖~~
- [x] 去掉了原用户模块设计
- [x] 增加了用户访问统计模块
- [x] 评论模块更新为disqus，并实现评论回调
- [x] 登陆显示头像

TODO LIST
- [ ] 完善后台图片管理
- [ ] 话题提取模块
- [ ] jwt身份验证
- [ ] 实现整个博客系统的独立安装
