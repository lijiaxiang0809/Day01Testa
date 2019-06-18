package com.example.geeknews.bean;

import java.util.List;

public class ZhiHuNewsBean {


    /**
     * date : 20190605
     * stories : [{"images":["https://pic2.zhimg.com/v2-bf447f5ac8778bc64837313139c407e9.jpg"],"type":0,"id":9712073,"ga_prefix":"060509","title":"「看电影」的能力，是需要学习的吗？"},{"images":["https://pic4.zhimg.com/v2-3093fb85665fa8c3e8f7ba005ec17f8b.jpg"],"type":0,"id":9712231,"ga_prefix":"060507","title":"为什么苹果会发布 Pro Display XDR？"},{"images":["https://pic1.zhimg.com/v2-ea02f5da298586bc1ca0c44395dc62b0.jpg"],"type":0,"id":9712097,"ga_prefix":"060506","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg","type":0,"id":9712095,"ga_prefix":"060407","title":"Uniqlo x KAWS 的发售「乱象」，是怎么出现的？"},{"image":"https://pic1.zhimg.com/v2-cbc334204e7ffb639735367122eff48c.jpg","type":0,"id":9712142,"ga_prefix":"060408","title":"旗帜鲜明地反对断骨增高手术"},{"image":"https://pic1.zhimg.com/v2-96666b0894871ab0dbcf76dcccac6c40.jpg","type":0,"id":9712046,"ga_prefix":"060308","title":"结婚 5 年，双方父母没见面，过年各回各家，Papi 酱的婚姻模式适合你吗？"},{"image":"https://pic3.zhimg.com/v2-c041e9c1e28edc3100309532742509f2.jpg","type":0,"id":9712013,"ga_prefix":"053108","title":"百度最难捱的一夜：五名高管闪电辞职内幕"},{"image":"https://pic1.zhimg.com/v2-548d3d615b68aa27421475875d2b410c.jpg","type":0,"id":9711876,"ga_prefix":"053008","title":"高铁这么好的东西，美国人为什么不大力发展？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-bf447f5ac8778bc64837313139c407e9.jpg"]
         * type : 0
         * id : 9712073
         * ga_prefix : 060509
         * title : 「看电影」的能力，是需要学习的吗？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg
         * type : 0
         * id : 9712095
         * ga_prefix : 060407
         * title : Uniqlo x KAWS 的发售「乱象」，是怎么出现的？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
