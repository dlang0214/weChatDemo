package com.emmanuel.wechatdemo.util;

import com.emmanuel.wechatdemo.App;
import com.emmanuel.wechatdemo.R;
import com.emmanuel.wechatdemo.bean.Comment;
import com.emmanuel.wechatdemo.bean.Picture;
import com.emmanuel.wechatdemo.bean.ShuoShuo;
import com.emmanuel.wechatdemo.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 2016/8/17.
 */
public class DataFactory {

    public static final String CONTENTS[] = {
            "事实上，长期以来，甲骨文起诉谷歌的这起安全一直备受整个软件行业的关注。多年以来，整个软件行业都担心此案可能产生的恶意影响。如果甲骨文最终获胜，那么这可能会引发其它诸多与APIs相关的诉讼案件。对程序员而言，像谷歌使用Java这样，仿效另一种语言的APIs是极其普遍的事。",
            "个人博客 http://blog.csdn.net/acmnickzhang",
            "好好写代码",
            "SHI LI XIU YIBO YINGYU",
            "分享精神，开源为乐，共同进步！",
            "不积小流无以至江海，不积跬步无以至千里",
            "笨鸟先飞。。。"
    };
    public static final String PHOTO_URL[] = {
            "http://img4.imgtn.bdimg.com/it/u=306417407,3315079289&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1895407444,732122393&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1267133660,2011180104&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1471400134&di=f2790eb5fdcdc6dedba437aa62a58940&src=http://img0.pconline.com.cn/pconline/1408/21/5313057_1408107-10_thumb.jpg",
            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1471400134&di=32e656b2b72f8bf7ed0a1bf64eaa73de&src=http://pic.3h3.com/up/2013-7/201377991457564943.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2196598284,153353657&fm=21&gp=0.jpg"
    };
    public static final String PICTURE_URL[] = {
            "http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg",
            "http://pic23.nipic.com/20120917/10076134_112929387108_2.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3504467926,1438117737&fm=206&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=663132532,1265075679&fm=206&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=430285025,1168446243&fm=206&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3814971924,4161415886&fm=206&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=731307697,3873909574&fm=206&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1681882397,3535453166&fm=206&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2059708553,255963759&fm=206&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1023930876,2577057362&fm=206&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2349257573,7606495&fm=206&gp=0.jpg"
//            "",
//            "",
//            "",
//            "",
//            "",
//            "",
//            "",
//            "",
//            "",
//            "",
//            "",
//            "",
//            ""
    };

    public static final String COMMENTS[] = {
            "hao",
            "haohaohaoahoaho",
            ".....",
            "字要多一点，多一点，多一点，多一点，多一点，多一点，多一点，多一点，多一点",
            "en",
            "hello"
    };

    public static Random random = new Random();

    public static List<ShuoShuo> createShuoShuo(int size){

        List<ShuoShuo>list = new ArrayList<>();
        ShuoShuo s = new ShuoShuo();
        s.user = createUser();
        s.content = createContent();
        s.zanList = getZans();
        s.commentList = getCommentList();
        s.videoPath = App.videoPath;
        list.add(s);
        for (int i=0; i<size; i++){
            ShuoShuo ss = new ShuoShuo();
            ss.user = createUser();
            ss.content = createContent();
            ss.picList = getPicList();
            ss.zanList = getZans();
            ss.commentList = getCommentList();
            list.add(ss);
        }
        return list;
    }

    private static User createUser(){
        User user = new User();
        user.name = getName();
        user.photoUrl = getPhotoUrl();
        return user;
    }

    private static String getName(){
        Random random1 = new Random();
        int nameLen = random.nextInt(6) + 1;
        StringBuilder name = new StringBuilder("");
        for(int i=0; i<nameLen; i++){
            int word = random1.nextInt(26) + 1;
            char ch;
            if(i == 0)
                ch = (char)('A' + word - 1);
            else
                ch = (char)('a' + word - 1);
            name.append(ch);
        }
        return name.toString();
    }

    private static List<String> getZans(){
        int size = random.nextInt(6);
        if(size == 5)
            size = 15; //测试下数量很多的情况
        List<String>zans = new ArrayList<>();
        for(int i=0; i<size; i++){
            zans.add(getName());
        }
        return zans;
    }

    private static String getPhotoUrl(){
        int index = (int)(Math.random() * PHOTO_URL.length * 100) % PHOTO_URL.length;
        return PHOTO_URL[index];
    }

    private static ArrayList<Picture> getPicList(){
        random = new Random();
        int picSize = random.nextInt(10); //0 -- 9张
        ArrayList<Picture>listPic = new ArrayList<>();
        for(int i=0; i<picSize; i++){
            int index = random.nextInt(PICTURE_URL.length);
            Picture picture = new Picture();
            picture.uri = PICTURE_URL[index];
            listPic.add(picture);
        }

        return listPic;
    }

    private static String createContent(){
        int index = (int)(Math.random() * CONTENTS.length * 100) % CONTENTS.length;
        return CONTENTS[index];
    }

    private static List<Comment> getCommentList(){
        List<Comment>list = new ArrayList<>();
        int size = random.nextInt(3);
        for(int i=0; i<size; i++){
            list.add(getComment());
        }
        return list;
    }

    private static Comment getComment(){
        Comment comment = new Comment();
        comment.fromUser = createUser();
        comment.content = getContent();
        return comment;
    }

    private static String getContent(){
        int size = COMMENTS.length;
        int index = random.nextInt(size);
        return COMMENTS[index];
    }

    public static List<User> createFriends(int num){
        List<User>listMyFriends = new ArrayList<>();
        for(int i=0; i<num; i++){
            User friend = createUser();
            listMyFriends.add(friend);
        }

        User user = new User();
        user.name = "张三";
        user.photoUrl = PHOTO_URL[0];

        User user1 = new User();
        user1.name = "李四";
        user1.photoUrl = PHOTO_URL[1];

        User user2 = new User();
        user2.name = "王五";
        user2.photoUrl = PHOTO_URL[2];

        User user3 = new User();
        user3.name = "马云";
        user3.photoUrl = PHOTO_URL[3];

        User user4 = new User();
        user4.name = "乔布斯";
        user4.photoUrl = PHOTO_URL[4];

//        listMyFriends.add(user);
//        listMyFriends.add(user1);
//        listMyFriends.add(user2);
//        listMyFriends.add(user3);
//        listMyFriends.add(user4);

        return listMyFriends;
    }

}
