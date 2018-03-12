package lei.com.yulei.quarter.Personalworkscentre.centre_bean;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2018/1/28.
 */

public class Center_Bean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : {"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"},"worksEntities":[{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1516884385549s5.jpg","createTime":"2018-01-25T20:46:25","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":10,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/15168843855498b9d38e2416441b4d34e6be3229ff777.mp4","wid":255,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1516927200558timg1.jpg","createTime":"2018-01-26T08:40:00","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":3,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/151692720055806a9edbf252acdd5165879bc223f4c58.mp4","wid":256,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1516956745048s3.jpeg","createTime":"2018-01-26T16:52:25","favoriteNum":null,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":1,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1516956745048littleBird.mp4","wid":257,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/15170148640301513341066240.jpg","createTime":"2018-01-27T09:01:04","favoriteNum":null,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517014864030haodeba.mp4","wid":258,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/15170151136271513341066240.jpg","createTime":"2018-01-27T09:05:13","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":5,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517015113627haodeba.mp4","wid":259,"workDesc":null}]}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"}
         * worksEntities : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1516884385549s5.jpg","createTime":"2018-01-25T20:46:25","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":10,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/15168843855498b9d38e2416441b4d34e6be3229ff777.mp4","wid":255,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1516927200558timg1.jpg","createTime":"2018-01-26T08:40:00","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":3,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/151692720055806a9edbf252acdd5165879bc223f4c58.mp4","wid":256,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1516956745048s3.jpeg","createTime":"2018-01-26T16:52:25","favoriteNum":null,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":1,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1516956745048littleBird.mp4","wid":257,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/15170148640301513341066240.jpg","createTime":"2018-01-27T09:01:04","favoriteNum":null,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517014864030haodeba.mp4","wid":258,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/15170151136271513341066240.jpg","createTime":"2018-01-27T09:05:13","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":5,"praiseNum":null,"uid":1758,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517015113627haodeba.mp4","wid":259,"workDesc":null}]
         */

        private UserBean user;
        private List<WorksEntitiesBean> worksEntities;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<WorksEntitiesBean> getWorksEntities() {
            return worksEntities;
        }

        public void setWorksEntities(List<WorksEntitiesBean> worksEntities) {
            this.worksEntities = worksEntities;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1516841991537timg.jpg
             * nickname : 熊猫
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }

        public static class WorksEntitiesBean {
            /**
             * commentNum : null
             * cover : https://www.zhaoapi.cn/images/quarter/1516884385549s5.jpg
             * createTime : 2018-01-25T20:46:25
             * favoriteNum : null
             * latitude : 39.95
             * localUri : null
             * longitude : 116.30
             * playNum : 10
             * praiseNum : null
             * uid : 1758
             * videoUrl : https://www.zhaoapi.cn/images/quarter/15168843855498b9d38e2416441b4d34e6be3229ff777.mp4
             * wid : 255
             * workDesc : null
             */

            private Object commentNum;
            private String cover;
            private String createTime;
            private Object favoriteNum;
            private String latitude;
            private Object localUri;
            private String longitude;
            private int playNum;
            private Object praiseNum;
            private int uid;
            private String videoUrl;
            private int wid;
            private Object workDesc;

            public Object getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(Object commentNum) {
                this.commentNum = commentNum;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getFavoriteNum() {
                return favoriteNum;
            }

            public void setFavoriteNum(Object favoriteNum) {
                this.favoriteNum = favoriteNum;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public Object getLocalUri() {
                return localUri;
            }

            public void setLocalUri(Object localUri) {
                this.localUri = localUri;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public int getPlayNum() {
                return playNum;
            }

            public void setPlayNum(int playNum) {
                this.playNum = playNum;
            }

            public Object getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(Object praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }

            public Object getWorkDesc() {
                return workDesc;
            }

            public void setWorkDesc(Object workDesc) {
                this.workDesc = workDesc;
            }
        }
    }
}
