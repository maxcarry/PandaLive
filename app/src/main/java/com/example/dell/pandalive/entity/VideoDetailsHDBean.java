package com.example.dell.pandalive.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/30.
 */

public class VideoDetailsHDBean {

    /**
     * video : [{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/08/28/32a08c5f6c3f4f34becaf960d5a47538-129.jpg?p=2&h=120","len":"00:04:32","order":"62","ptime":"2017-08-28 12:17:45","t":"《熊猫TOP榜》 20170828 第二季第十二期：煤炭兄妹尬舞嗨翻全场","url":"http://tv.cntv.cn/video/VSET100284428835/32a08c5f6c3f4f34becaf960d5a47538","vid":"32a08c5f6c3f4f34becaf960d5a47538","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/08/21/8ff497729f7e4d9881d643f41f90d378-129.jpg?p=2&h=120","len":"00:04:33","order":"61","ptime":"2017-08-21 13:18:46","t":"《熊猫TOP榜》 20170821 第二季第十一期：一起惹的祸，妹妹背黑锅","url":"http://tv.cntv.cn/video/VSET100284428835/8ff497729f7e4d9881d643f41f90d378","vid":"8ff497729f7e4d9881d643f41f90d378","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/08/14/5e018d3c4fc24654b2a25b1f430adf5e-129.jpg?p=2&h=120","len":"00:04:03","order":"60","ptime":"2017-08-14 12:52:16","t":"《熊猫TOP榜》 20170814 第二季第十期：滚滚们的幸福生活","url":"http://tv.cntv.cn/video/VSET100284428835/5e018d3c4fc24654b2a25b1f430adf5e","vid":"5e018d3c4fc24654b2a25b1f430adf5e","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/08/07/ed3ae7e52f44483f948eaf7ec52c383b-129.jpg?p=2&h=120","len":"00:04:27","order":"59","ptime":"2017-08-07 15:35:07","t":"《熊猫TOP榜》 20170807 第二季第九期：滚滚们个个都是\u201c小熊精\u201d","url":"http://tv.cntv.cn/video/VSET100284428835/ed3ae7e52f44483f948eaf7ec52c383b","vid":"ed3ae7e52f44483f948eaf7ec52c383b","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/07/31/75a69204b9144a5590cf30c7d327dfdd-129.jpg?p=2&h=120","len":"00:04:20","order":"58","ptime":"2017-07-31 15:41:43","t":"《熊猫TOP榜》20170731第二季第8期：舞王泰山闪耀回归","url":"http://tv.cntv.cn/video/VSET100284428835/75a69204b9144a5590cf30c7d327dfdd","vid":"75a69204b9144a5590cf30c7d327dfdd","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/07/24/32f339ac2009453ea7d212c71cbb89cf-129.jpg?p=2&h=120","len":"00:04:01","order":"57","ptime":"2017-07-24 13:02:50","t":"《熊猫TOP榜》 20170724 第二季第7期.\u201c煤老板\u201d强取豪夺小卖部","url":"http://tv.cntv.cn/video/VSET100284428835/32f339ac2009453ea7d212c71cbb89cf","vid":"32f339ac2009453ea7d212c71cbb89cf","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/07/17/3d92fae34dc14b2492de15d5dd122ac8-129.jpg?p=2&h=120","len":"00:04:39","order":"56","ptime":"2017-07-17 15:14:40","t":"《熊猫TOP榜》 20170717 第二季第6期：有这样的奶爸奶妈 欢乐一夏","url":"http://tv.cntv.cn/video/VSET100284428835/3d92fae34dc14b2492de15d5dd122ac8","vid":"3d92fae34dc14b2492de15d5dd122ac8","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/07/10/9a29f4991e7a48469729026e18ed9de1-129.jpg?p=2&h=120","len":"00:04:55","order":"55","ptime":"2017-07-10 13:53:27","t":"《熊猫TOP榜》 20170710 第二季第5期：煤炭兄妹的日常之你抢我抢","url":"http://tv.cntv.cn/video/VSET100284428835/9a29f4991e7a48469729026e18ed9de1","vid":"9a29f4991e7a48469729026e18ed9de1","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/07/03/45f281a7e16540fd8823d67c75149d92-129.jpg?p=2&h=120","len":"00:03:59","order":"54","ptime":"2017-07-03 14:43:25","t":"《熊猫TOP榜》 20170703 第二季第四期：滚滚造型大赛","url":"http://tv.cntv.cn/video/VSET100284428835/45f281a7e16540fd8823d67c75149d92","vid":"45f281a7e16540fd8823d67c75149d92","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/06/26/3998ae8b8a764b8e88e7dc7d75f331e4-129.jpg?p=2&h=120","len":"00:04:42","order":"53","ptime":"2017-06-26 16:23:08","t":"《熊猫TOP榜》 20170626 第二季第3期.这是一个神奇的院子","url":"http://tv.cntv.cn/video/VSET100284428835/3998ae8b8a764b8e88e7dc7d75f331e4","vid":"3998ae8b8a764b8e88e7dc7d75f331e4","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/06/19/99fd0bb05e1d49d999048c20dc7b49b9-129.jpg","len":"00:03:32","order":"52","ptime":"2017-06-19 14:47:12","t":"《熊猫TOP榜》 20170619 第二季.第2期.夏天和泡澡更配哦(成片)","url":"http://tv.cntv.cn/video/VSET100284428835/99fd0bb05e1d49d999048c20dc7b49b9","vid":"99fd0bb05e1d49d999048c20dc7b49b9","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/06/12/06ab416eb6a04d03848bb2a4bd4e6d52-129.jpg","len":"00:04:41","order":"51","ptime":"2017-06-12 15:47:04","t":"《熊猫TOP榜》 20170612 第二季第一期：窝头窝头请赐予我力量吧","url":"http://tv.cntv.cn/video/VSET100284428835/06ab416eb6a04d03848bb2a4bd4e6d52","vid":"06ab416eb6a04d03848bb2a4bd4e6d52","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/06/05/2e246a096bb544d8a923c41b063c7a71-129.jpg","len":"00:04:40","order":"50","ptime":"2017-06-05 15:39:11","t":"《熊猫TOP榜》 20170605 第五十期 吃粽子、过儿童节 这样的熊生 巴适","url":"http://tv.cntv.cn/video/VSET100284428835/2e246a096bb544d8a923c41b063c7a71","vid":"2e246a096bb544d8a923c41b063c7a71","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/05/29/66b6a588989a4ee7affe9f61202925f0-129.jpg","len":"00:03:49","order":"49","ptime":"2017-05-29 13:47:33","t":"《熊猫TOP榜》 20170529 第四十九期：卖萌和才华于一身的功夫熊猫","url":"http://tv.cntv.cn/video/VSET100284428835/66b6a588989a4ee7affe9f61202925f0","vid":"66b6a588989a4ee7affe9f61202925f0","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/05/22/06e4ebb0c3e14be4b2bc544807269c8b-105.jpg","len":"00:03:11","order":"48","ptime":"2017-05-22 15:04:15","t":"《熊猫TOP榜》 20170522 第四十八期：不吃苹果的熊猫不是乖滚滚","url":"http://tv.cntv.cn/video/VSET100284428835/06e4ebb0c3e14be4b2bc544807269c8b","vid":"06e4ebb0c3e14be4b2bc544807269c8b","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/05/15/16456a7943be474498e21b8b8f33f952-129.jpg","len":"00:03:59","order":"47","ptime":"2017-05-15 15:29:52","t":"《熊猫TOP榜》 20170515 第四十七期：都江堰基地扛把子回归","url":"http://tv.cntv.cn/video/VSET100284428835/16456a7943be474498e21b8b8f33f952","vid":"16456a7943be474498e21b8b8f33f952","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/05/08/6bf3d46c0d6f4d0f9a03f1d5c25ced9b-129.jpg","len":"00:04:22","order":"46","ptime":"2017-05-08 13:37:48","t":"《熊猫TOP榜》 20170508 第四十六期：冰冰越狱记","url":"http://tv.cntv.cn/video/VSET100284428835/6bf3d46c0d6f4d0f9a03f1d5c25ced9b","vid":"6bf3d46c0d6f4d0f9a03f1d5c25ced9b","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/05/01/76d6ece3031d4e09894da13dea0384c3-109.jpg","len":"00:03:19","order":"45","ptime":"2017-05-01 13:47:50","t":"《熊猫TOP榜》 20170501 第四十五期：城池坚守之战","url":"http://tv.cntv.cn/video/VSET100284428835/76d6ece3031d4e09894da13dea0384c3","vid":"76d6ece3031d4e09894da13dea0384c3","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/04/24/d7d835cfc9cb4002afd849ca1c2324ea-129.jpg","len":"00:03:47","order":"44","ptime":"2017-04-24 14:52:17","t":"《熊猫TOP榜》 20170424 第四十四期：掏出手机 搞事情","url":"http://tv.cntv.cn/video/VSET100284428835/d7d835cfc9cb4002afd849ca1c2324ea","vid":"d7d835cfc9cb4002afd849ca1c2324ea","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/04/17/4953e2cf834846bb841da7d33edbd4df-129.jpg","len":"00:04:13","order":"43","ptime":"2017-04-17 12:06:37","t":"《熊猫TOP榜》 20170417 第四十三期：网红也有真材实料","url":"http://tv.cntv.cn/video/VSET100284428835/4953e2cf834846bb841da7d33edbd4df","vid":"4953e2cf834846bb841da7d33edbd4df","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/04/10/9a568a7a99914e2aabfcb92a33d1b432-129.jpg","len":"00:03:37","order":"42","ptime":"2017-04-10 14:45:24","t":"《熊猫TOP榜》 20170410 第四十二期：上古神器在此 谁敢放肆","url":"http://tv.cntv.cn/video/VSET100284428835/9a568a7a99914e2aabfcb92a33d1b432","vid":"9a568a7a99914e2aabfcb92a33d1b432","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/04/03/95a7cd14bf3b46da8a410156c4662d21-111.jpg","len":"00:03:22","order":"41","ptime":"2017-04-03 08:50:08","t":"《熊猫TOP榜》 第四十一期 朕打拼的江山 尔等休想篡位(成片)","url":"http://tv.cntv.cn/video/VSET100284428835/95a7cd14bf3b46da8a410156c4662d21","vid":"95a7cd14bf3b46da8a410156c4662d21","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/03/27/80be4b6cb7c8469fa9a5a0da1ff80503-129.jpg","len":"00:03:56","order":"40","ptime":"2017-03-27 10:54:26","t":"《熊猫TOP榜》 20170327 第四十期 没带苹果 还敢来见朕？","url":"http://tv.cntv.cn/video/VSET100284428835/80be4b6cb7c8469fa9a5a0da1ff80503","vid":"80be4b6cb7c8469fa9a5a0da1ff80503","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/03/20/848e00a6d1e74143b500847d418865be-129.jpg","len":"00:03:53","order":"39","ptime":"2017-03-20 17:01:05","t":"《熊猫TOP榜》 20170320 第三十九期 2017届 群雄（熊）争霸赛(成片)","url":"http://tv.cntv.cn/video/VSET100284428835/848e00a6d1e74143b500847d418865be","vid":"848e00a6d1e74143b500847d418865be","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/03/13/a79ac5e16e6d4fe8be3c8515dbf7dda8-129.jpg","len":"00:04:12","order":"38","ptime":"2017-03-13 17:33:09","t":"《熊猫TOP榜》 20170313 第三十八期：奶爸也文艺","url":"http://tv.cntv.cn/video/VSET100284428835/a79ac5e16e6d4fe8be3c8515dbf7dda8","vid":"a79ac5e16e6d4fe8be3c8515dbf7dda8","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/03/06/e3691e7a9cae4486a60821de365edd00-129.jpg","len":"00:03:56","order":"37","ptime":"2017-03-06 12:43:30","t":"《熊猫TOP榜》 20170306 第三十七期：多一点真诚 少一点套路","url":"http://tv.cntv.cn/video/VSET100284428835/e3691e7a9cae4486a60821de365edd00","vid":"e3691e7a9cae4486a60821de365edd00","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/02/27/d95e5caeb40b480dbf5a018dd9b2acdc-129.jpg","len":"00:03:53","order":"36","ptime":"2017-02-27 16:42:17","t":"《熊猫TOP榜》 20170227 第三十六期：滚滚的N种出场方式","url":"http://tv.cntv.cn/video/VSET100284428835/d95e5caeb40b480dbf5a018dd9b2acdc","vid":"d95e5caeb40b480dbf5a018dd9b2acdc","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/02/20/de094a15d8be4d7d96a153fd32f1f0fc-129.jpg","len":"00:04:40","order":"35","ptime":"2017-02-20 13:43:58","t":"《熊猫TOP榜》 20170220 第三十五期 2016级网红滚滚诞生","url":"http://tv.cntv.cn/video/VSET100284428835/de094a15d8be4d7d96a153fd32f1f0fc","vid":"de094a15d8be4d7d96a153fd32f1f0fc","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/02/13/0b588ca1f2fa4e21b91225ef44d15643-129.jpg","len":"00:04:35","order":"34","ptime":"2017-02-13 15:24:57","t":"《熊猫TOP榜》 20170213 第三十四期：厉害了word滚滚 有这么多看家本领","url":"http://tv.cntv.cn/video/VSET100284428835/0b588ca1f2fa4e21b91225ef44d15643","vid":"0b588ca1f2fa4e21b91225ef44d15643","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/02/06/88638b85177a437eae87ba870fd615a2-129.jpg","len":"00:03:48","order":"33","ptime":"2017-02-06 12:06:50","t":"《熊猫TOP榜》 20170206 第三十三期： 春节你收了多少压岁钱","url":"http://tv.cntv.cn/video/VSET100284428835/88638b85177a437eae87ba870fd615a2","vid":"88638b85177a437eae87ba870fd615a2","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/01/23/ac599bdd9be34775bb068b6aec216aea-129.jpg","len":"00:03:56","order":"32","ptime":"2017-01-23 10:36:09","t":"《熊猫TOP榜》 20170123 第三十二期：奶爸拍照停不下来","url":"http://tv.cntv.cn/video/VSET100284428835/ac599bdd9be34775bb068b6aec216aea","vid":"ac599bdd9be34775bb068b6aec216aea","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/01/16/9ae58d30a808466ea6760a6201f29ff4-129.jpg","len":"00:03:56","order":"31","ptime":"2017-01-16 17:01:35","t":"《熊猫TOP榜》 20170116 第三十一期：新一任TOP榜主诞生","url":"http://tv.cntv.cn/video/VSET100284428835/9ae58d30a808466ea6760a6201f29ff4","vid":"9ae58d30a808466ea6760a6201f29ff4","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/01/09/0f76bc389ff44dfda9684aa3cb509f27-129.jpg","len":"00:04:36","order":"30","ptime":"2017-01-09 16:10:04","t":"《熊猫TOP榜》 20170109 第三十期：专业坑妹 不解释","url":"http://tv.cntv.cn/video/VSET100284428835/0f76bc389ff44dfda9684aa3cb509f27","vid":"0f76bc389ff44dfda9684aa3cb509f27","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/01/03/d2ca66f21cd64414be9a01893584f733-113.jpg","len":"00:03:26","order":"29","ptime":"2017-01-03 08:15:17","t":"《熊猫TOP榜》 20170102 第二十九期：轮胎的新玩儿法","url":"http://tv.cntv.cn/video/VSET100284428835/d2ca66f21cd64414be9a01893584f733","vid":"d2ca66f21cd64414be9a01893584f733","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2016/12/26/9def267ca19e492ba0c85c9949a2d2a9-129.jpg","len":"00:05:22","order":"28","ptime":"2016-12-26 15:18:44","t":"《熊猫TOP榜》 20161226 第二十八期：蔓越煤跨界背唐诗三百首","url":"http://tv.cntv.cn/video/VSET100284428835/9def267ca19e492ba0c85c9949a2d2a9","vid":"9def267ca19e492ba0c85c9949a2d2a9","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2016/12/19/7d9b28b0f889455aac2c33c2253f6519-129.jpg","len":"00:04:27","order":"27","ptime":"2016-12-19 11:36:42","t":"《熊猫TOP榜》 20161219 第二十七期：滚滚吃竹子的最高境界","url":"http://tv.cntv.cn/video/VSET100284428835/7d9b28b0f889455aac2c33c2253f6519","vid":"7d9b28b0f889455aac2c33c2253f6519","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/12/12/79f2dcf28a8c4dfab6da099887a8a7cc-129.jpg","len":"00:04:54","order":"26","ptime":"2016-12-12 12:09:53","t":"《熊猫TOP榜》 20161212 第二十六期：冰冰挑战\u201c跨界萌主\u201d宝座","url":"http://tv.cntv.cn/video/VSET100284428835/79f2dcf28a8c4dfab6da099887a8a7cc","vid":"79f2dcf28a8c4dfab6da099887a8a7cc","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2016/12/05/df25ad7f95c6429a85bb11df0a28387c-129.jpg","len":"00:04:24","order":"25","ptime":"2016-12-05 14:52:39","t":"《熊猫TOP榜》 20161205 第二十五期：蔓越煤成为跨界萌主","url":"http://tv.cntv.cn/video/VSET100284428835/df25ad7f95c6429a85bb11df0a28387c","vid":"df25ad7f95c6429a85bb11df0a28387c","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2016/11/28/0a753a22f0bc4cfa8e80f206b588d1c8-129.jpg","len":"00:04:03","order":"24","ptime":"2016-11-28 11:57:29","t":"《熊猫TOP榜》 20161128 第二十四期：来不及解释了 快上车","url":"http://tv.cntv.cn/video/VSET100284428835/0a753a22f0bc4cfa8e80f206b588d1c8","vid":"0a753a22f0bc4cfa8e80f206b588d1c8","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2016/11/21/bb21af1923794f338b9f329d8dd34bc0-129.jpg","len":"00:03:44","order":"23","ptime":"2016-11-21 14:32:05","t":"《熊猫TOP榜》 20161121 第二十三期：奶爸深夜撩熊记","url":"http://tv.cntv.cn/video/VSET100284428835/bb21af1923794f338b9f329d8dd34bc0","vid":"bb21af1923794f338b9f329d8dd34bc0","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2016/11/14/724ea96ed5db498cac7abe177e55b6eb-129.jpg","len":"00:03:55","order":"22","ptime":"2016-11-14 11:18:43","t":"《熊猫TOP榜》 20161114 第二十二期 明明可以靠脸吃饭 却偏偏要靠才华","url":"http://tv.cntv.cn/video/VSET100284428835/724ea96ed5db498cac7abe177e55b6eb","vid":"724ea96ed5db498cac7abe177e55b6eb","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2016/11/07/ca3c6004d9134d58a402ac61c7d3862e-106.jpg","len":"00:03:13","order":"21","ptime":"2016-11-07 12:54:19","t":"《熊猫TOP榜》 20161107 第二十一期：滚滚的万圣节礼物","url":"http://tv.cntv.cn/video/VSET100284428835/ca3c6004d9134d58a402ac61c7d3862e","vid":"ca3c6004d9134d58a402ac61c7d3862e","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2016/10/31/dbf063c367f34269af7a5e32cc15ee05-112.jpg","len":"00:03:24","order":"20","ptime":"2016-10-31 11:36:02","t":"《熊猫TOP榜》 20161031 第二十期：奶爸你给我站住，别跑","url":"http://tv.cntv.cn/video/VSET100284428835/dbf063c367f34269af7a5e32cc15ee05","vid":"dbf063c367f34269af7a5e32cc15ee05","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2016/10/24/42e0c8cd20234a5eb9a0d57982766dbc-129.jpg","len":"00:03:51","order":"19","ptime":"2016-10-24 11:03:24","t":"《熊猫TOP榜》 20161024 第十九期：我要去闯荡江湖了，再见啦！","url":"http://tv.cntv.cn/video/VSET100284428835/42e0c8cd20234a5eb9a0d57982766dbc","vid":"42e0c8cd20234a5eb9a0d57982766dbc","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2016/10/17/7fdcf8995f374edb8d082cbe721af2f9-113.jpg","len":"00:03:25","order":"18","ptime":"2016-10-17 09:48:48","t":"《熊猫TOP榜》 20161017 第十八期：奶爸蓝瘦香菇","url":"http://tv.cntv.cn/video/VSET100284428835/7fdcf8995f374edb8d082cbe721af2f9","vid":"7fdcf8995f374edb8d082cbe721af2f9","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/10/10/b08b1579740f4c9e9176f871aecc368d-101.jpg","len":"00:03:03","order":"17","ptime":"2016-10-10 12:53:22","t":"《熊猫TOP榜》 20161010 第十七期：滚滚的各种奇葩睡姿","url":"http://tv.cntv.cn/video/VSET100284428835/b08b1579740f4c9e9176f871aecc368d","vid":"b08b1579740f4c9e9176f871aecc368d","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2016/10/03/1c04e35d9cdc42f1ad5c8452fb97bce6-107.jpg","len":"00:03:14","order":"16","ptime":"2016-10-03 04:16:55","t":"《熊猫TOP榜》 20161003 第十六期：再多套路 也抵挡不住美食的诱惑","url":"http://tv.cntv.cn/video/VSET100284428835/1c04e35d9cdc42f1ad5c8452fb97bce6","vid":"1c04e35d9cdc42f1ad5c8452fb97bce6","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/09/30/e22e23b165964c50899653b338e3e9d3-108.jpg","len":"00:03:15","order":"15","ptime":"2016-09-30 09:50:20","t":"《熊猫TOP榜》 20160930 第十五期：国庆长假去看熊猫吧","url":"http://tv.cntv.cn/video/VSET100284428835/e22e23b165964c50899653b338e3e9d3","vid":"e22e23b165964c50899653b338e3e9d3","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2016/09/23/22557fbde7e34f829c492b914475e729-102.jpg","len":"00:03:03","order":"14","ptime":"2016-09-23 15:43:02","t":"《熊猫TOP榜》 20160923 第十四期：一言不合就抢笋","url":"http://tv.cntv.cn/video/VSET100284428835/22557fbde7e34f829c492b914475e729","vid":"22557fbde7e34f829c492b914475e729","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2016/09/16/d53c2e1c436241d39e9853a2bef2b1a6-95.jpg","len":"00:02:49","order":"13","ptime":"2016-09-16 10:47:49","t":"《熊猫TOP榜》 20160916 第十三期：奔跑吧 星安","url":"http://tv.cntv.cn/video/VSET100284428835/d53c2e1c436241d39e9853a2bef2b1a6","vid":"d53c2e1c436241d39e9853a2bef2b1a6","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/09/09/bfc78c593ee04504af06c8898dd62b09-106.jpg","len":"00:03:11","order":"12","ptime":"2016-09-09 11:12:12","t":"《熊猫TOP榜》 20160909 第十二期：高温蒸煮的日子终于熬过去了","url":"http://tv.cntv.cn/video/VSET100284428835/bfc78c593ee04504af06c8898dd62b09","vid":"bfc78c593ee04504af06c8898dd62b09","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2016/09/02/6a90ec5c1dc444639e9c580aaf9ce036-129.jpg","len":"00:03:47","order":"11","ptime":"2016-09-02 11:07:20","t":"《熊猫TOP榜》 20160902 第十一期：奶爸内心几乎是崩溃的","url":"http://tv.cntv.cn/video/VSET100284428835/6a90ec5c1dc444639e9c580aaf9ce036","vid":"6a90ec5c1dc444639e9c580aaf9ce036","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2016/08/26/0ceb22f52d4a40d7a5c97d978a9b739a-111.jpg","len":"00:03:21","order":"10","ptime":"2016-08-26 12:39:09","t":"《熊猫TOP榜》 20160826 第十期：喝奶不是我想要的熊生","url":"http://tv.cntv.cn/video/VSET100284428835/0ceb22f52d4a40d7a5c97d978a9b739a","vid":"0ceb22f52d4a40d7a5c97d978a9b739a","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2016/08/19/f56e03eba1f849d8a05eeffaefdb3789-104.jpg","len":"00:03:08","order":"9","ptime":"2016-08-19 11:50:33","t":"《熊猫物语》 20160819 熊猫TOP榜第九期：这支舞只为你而跳","url":"http://tv.cntv.cn/video/VSET100284428835/f56e03eba1f849d8a05eeffaefdb3789","vid":"f56e03eba1f849d8a05eeffaefdb3789","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2016/08/12/28bdd03a611e4753803d62e32675d900-89.jpg","len":"00:02:38","order":"8","ptime":"2016-08-12 13:46:35","t":"《熊猫物语》 20160812 熊猫TOP榜第八期：熊猫也想夺奥运金牌","url":"http://tv.cntv.cn/video/VSET100284428835/28bdd03a611e4753803d62e32675d900","vid":"28bdd03a611e4753803d62e32675d900","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2016/08/05/a5909a3c7b724e27a24816c510f61e9c-87.jpg","len":"00:02:33","order":"7","ptime":"2016-08-05 10:47:39","t":"《熊猫物语》 20160805 熊猫TOP榜第七期：要奶爸亲亲才能起来","url":"http://tv.cntv.cn/video/VSET100284428835/a5909a3c7b724e27a24816c510f61e9c","vid":"a5909a3c7b724e27a24816c510f61e9c","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2016/07/29/83a2c92a67de413ab29bd2bf49c81c23-86.jpg","len":"00:02:32","order":"6","ptime":"2016-07-29 11:30:53","t":"《熊猫物语》 20160729 熊猫TOP榜第六期：你是猴子请来的逗兵么","url":"http://tv.cntv.cn/video/VSET100284428835/83a2c92a67de413ab29bd2bf49c81c23","vid":"83a2c92a67de413ab29bd2bf49c81c23","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/07/22/ecefbc482a544ebab43f635c6f9089f5-84.jpg","len":"00:02:28","order":"5","ptime":"2016-07-22 16:26:41","t":"《熊猫物语》 20160722 熊猫TOP榜第五期","url":"http://tv.cntv.cn/video/VSET100284428835/ecefbc482a544ebab43f635c6f9089f5","vid":"ecefbc482a544ebab43f635c6f9089f5","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2016/07/15/2a3459281d1444dd9ec19df632847eea-78.jpg","len":"00:02:15","order":"4","ptime":"2016-07-15 10:47:25","t":"《熊猫物语》 20160715 熊猫TOP榜第四期：川话才是滚滚的绝配","url":"http://tv.cntv.cn/video/VSET100284428835/2a3459281d1444dd9ec19df632847eea","vid":"2a3459281d1444dd9ec19df632847eea","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2016/07/08/189bbb2f8b2247c681d460aee9914cac-75.jpg","len":"00:02:09","order":"3","ptime":"2016-07-08 11:45:43","t":"《熊猫物语》 20160708 熊猫TOP榜第三期：快来救救这只小团子","url":"http://tv.cntv.cn/video/VSET100284428835/189bbb2f8b2247c681d460aee9914cac","vid":"189bbb2f8b2247c681d460aee9914cac","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2016/07/01/e73dae84a15d4fe1bb59861fc9e3a085-96.jpg","len":"00:02:52","order":"2","ptime":"2016-07-01 10:58:22","t":"《熊猫物语》 20160701 熊猫TOP榜第二期：精彩视频TOP5","url":"http://tv.cntv.cn/video/VSET100284428835/e73dae84a15d4fe1bb59861fc9e3a085","vid":"e73dae84a15d4fe1bb59861fc9e3a085","vsid":"VSET100284428835"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2016/06/03/5549fa06c3434169873f7902eb986f6d-129.jpg","len":"00:05:23","order":"1","ptime":"2016-06-03 18:17:16","t":"《熊猫物语》 20160603 熊猫TOP榜：熊猫直播精彩一刻TOP5","url":"http://tv.cntv.cn/video/VSET100284428835/5549fa06c3434169873f7902eb986f6d","vid":"5549fa06c3434169873f7902eb986f6d","vsid":"VSET100284428835"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","js":"","name":"熊猫TOP榜","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100284428835","vsid":"VSET100284428835","yz":"","zcr":"","zy":""},"count":"62"}
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"bj":"","cd":"","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","js":"","name":"熊猫TOP榜","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"","url":"http://tv.cntv.cn/videoset/VSET100284428835","vsid":"VSET100284428835","yz":"","zcr":"","zy":""}
         * count : 62
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * bj :
             * cd :
             * desc : 这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面
             * dy :
             * enname : 其他
             * fcl :
             * fl :
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg
             * js :
             * name : 熊猫TOP榜
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj :
             * url : http://tv.cntv.cn/videoset/VSET100284428835
             * vsid : VSET100284428835
             * yz :
             * zcr :
             * zy :
             */

            private String bj;
            private String cd;
            private String desc;
            private String dy;
            private String enname;
            private String fcl;
            private String fl;
            private String img;
            private String js;
            private String name;
            private String nf;
            private String playdesc;
            private String relvsid;
            private String sbpd;
            private String sbsj;
            private String url;
            private String vsid;
            private String yz;
            private String zcr;
            private String zy;

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }
        }
    }

    public static class VideoBean {
        /**
         * em : CM01
         * img : http://p2.img.cctvpic.com/fmspic/2017/08/28/32a08c5f6c3f4f34becaf960d5a47538-129.jpg?p=2&h=120
         * len : 00:04:32
         * order : 62
         * ptime : 2017-08-28 12:17:45
         * t : 《熊猫TOP榜》 20170828 第二季第十二期：煤炭兄妹尬舞嗨翻全场
         * url : http://tv.cntv.cn/video/VSET100284428835/32a08c5f6c3f4f34becaf960d5a47538
         * vid : 32a08c5f6c3f4f34becaf960d5a47538
         * vsid : VSET100284428835
         */

        private String em;
        private String img;
        private String len;
        private String order;
        private String ptime;
        private String t;
        private String url;
        private String vid;
        private String vsid;

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }
    }
}
