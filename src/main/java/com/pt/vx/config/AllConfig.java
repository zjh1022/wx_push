package com.pt.vx.config;


import com.pt.vx.domain.BirthDay;
import com.pt.vx.domain.FunctionConfig;
import com.pt.vx.domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 * PT微信公众号模板消息推送 2.4.0
 * BiliBili: 今天pt健康了吗
 * 成功了的小伙伴，欢迎来点赞投币评论哦~
 * 国庆节快乐！
 *               -- 2022/10/1 
 *
 * 注意：改下面的信息的时候，细心一点。
 *  1. 等于号右边有双引号("")的不要把双引号给丢了,标点符号记得用英文输入法！！！ 
 *  2. 等于号左边的代码不要修改！！！
 *  3. 和风天气/高德地图的key不使用的话可以不填，但是不要把代码删了！！！
 *  4. 具体有哪些内置模板，可以到src/main/java/com/pt/vx/config/KeyConfig.java里面查看
 *               -- 2022/10/25
 */
public class AllConfig {
    public static final String VxAppId = "wx3298fed81b417fea";
    public static final String VxAppSecret = "f04f6a985406590075be7bafbd4b9fd8";
    public static final String WeatherKey = "a333715e1bc2e9b2d43bbd145047a0d7";
    public static final String WeatherKey_HeFeng = "和风天气KEY";

    //下列所有填写的  true 为开启， false 为不开启 ，#XXXXXX是颜色16进制HEX码（不知道颜色16进制HEX码可以百度）
    //系统开关
    public static final boolean OPEN_MESSAGE_SPLIT = true; //是否开启消息分裂（大于100字的消息会被分裂成多个,如tianGou超过了一百个字的话：{{tianGou.DATA}}{{tianGou1.DATA}}））
    public static final boolean OPEN_WEATHER_NOW = false; //切换天气类型为实时（false为天气预报，true为实时天气）
    public static final boolean OPEN_HF_WEATHER = false; //切换天气源为和风天气（目前只支持天气预报）
    public static final boolean OPEN_MASTER_MODEL = false; //是否开启主人模式。开启后，后面的用户只会收到第一个用户的内容。
    public static final boolean OPEN_RANDOM_COLOR = true; //是否开启随机消息颜色
    public static final String[] random_colors = {"#FFCCCC", "#33A1C9", "#DC143C","#FF0000","#6B8E23","#236B8E","#FF7F00"}; //参与随机的颜色,颜色为颜色HEX码（不知道可以百度）


    //基本类型消息
    public static final FunctionConfig open_name = new FunctionConfig(true,"#FFCCCC");//是否开启称呼
    public static final FunctionConfig open_birthDay = new FunctionConfig(true,"#FFCCCC"); //是否开启日期计算
    public static final boolean open_self_date_compute = true; //本地计算时间，周为中文
    public static final FunctionConfig open_weather = new FunctionConfig(true,"#33A1C9"); //是否开启天气预报
    public static final FunctionConfig open_other_info= new FunctionConfig(true,"#DC143C"); //是否开启额外信息（需要开启日期计算或天气预报）

    public static final String info_weather_rain = "出门记得带伞哦~"; //天气预报有雨的时候展示的额外信息
    public static final String info_weather_temperature_0 = "温度过低，加厚加厚！！！"; //温度≤0的时候展示的额外信息
    public static final String info_weather_temperature_10 = "温度很低，多穿点衣服哦！"; //温度≤10的时候展示的额外信息
    public static final String info_weather_temperature_20 = "温度有点低，注意别着凉啦~"; //温度≤20的时候展示的额外信息
    public static final String info_weather_prefix_day = "白天"; //白天天气的前缀，比如温度≤0的时候就会展示为： 白天温度过低，加厚加厚！！！
    public static final String info_weather_prefix_night = "晚上"; //晚上天气的前缀
    public static final String info_weather_prefix_now = "现在"; //现在天气的前缀



    //额外类型消息
    public static final FunctionConfig open_xinGuan_info = new FunctionConfig(true,"#FF7F00"); //是否开启用户城市新冠信息查询
    public static final FunctionConfig open_history_today = new FunctionConfig(false,"#FF7F00"); //是否开启历史上的今天
    public static final FunctionConfig open_qinghua = new FunctionConfig(true,"#FF7F00"); //是否开启情话一句
    public static final FunctionConfig open_dongman = new FunctionConfig(false,"#FF7F00"); //是否开启动漫台词(暂时无法使用了)
    public static final FunctionConfig open_tiangou = new FunctionConfig(true,"#FF7F00"); //是否开启舔狗日记
    public static final FunctionConfig open_world_read = new FunctionConfig(true,"#FF7F00"); //是否开启世界新闻
    public static final FunctionConfig open_random_read = new FunctionConfig(true,"#FF7F00"); //是否开启随机短句
    public static final FunctionConfig open_wozairenjian = new FunctionConfig(true,"#FF7F00"); //是否开启散文集我在人间凑日子
    public static final FunctionConfig open_poetry = new FunctionConfig(false,"#FF7F00"); //是否开启随机诗句(暂时无法使用了)
    public static final FunctionConfig open_english = new FunctionConfig(false,"#FF7F00"); //是否开启每日英语(暂时无法使用了)
    public static final FunctionConfig open_miyu = new FunctionConfig(false,"#FF7F00"); //是否开启谜语(暂时无法使用了)
    public static final FunctionConfig open_horoscope= new FunctionConfig(false,"#FF7F00"); //是否开启星座解析(只计算第一个birthDay的星座)
    public static final FunctionConfig random_module = new FunctionConfig(true,"#FF7F00"); //随机一个开启了的额外类型消息(开启以后，只会推送随机的)

    private static void init(){
        //如果要多个人的话，就复制这个一遍，然后填写里面的内容。这里默认两个人,大伙应该是两个人吧（笑）
        //如果开启了master模式，除第一个用户外，其他用户只需要填写微信号
        //要计算几个日期，就写几个new BirthDay,第一个在模板中是{{birthDay.DATA}}，第二个是{{birthDay1.DATA}}，第三个是{{birthDay2.DATA}}以此类推
        //  注意：日期里面的数字，填正常的数字就行了.比如1就是1，不要填01
        //  注意：每个用户信息的最后一项不需要加逗号！！！
        //new BirthDay()里面代表[年]、[月]、[日]、[是否是农历(true为农历、false为公历)]、[是否统计天数(true为统计，false为倒计时)]、[倒计时到0天提示信息(如果类型为统计可以不填)]
        userList.add(getUser(
                "odxiA55UUkGiniFpzbISch3akA2w", //扫码关注你的测试号以后，测试平台会出现TA的微信号
                "zBmx5c7PYaq_rr2WazeF1LO5b3rTjcnJqgS_4n3Zc5U", //要给这个人发送的模板ID
                "郑江海", //咋称呼这个人
                "广东省深圳市", //这个人的详细地址
                "深圳", //这个人在的城市
                new BirthDay(1999,2,15,true,false,"郑江海生日快乐！！"),
                new BirthDay(1999,8,11,false,false,"生日快乐哦~~"),
                new BirthDay(2020,7,8,true,true),
                new BirthDay(2020,7,8,true,false,"周年快乐！！！")
        ));

        userList.add(getUser(
                "odxiA50OabzeZbdjTH_NtU0XgnVQ",//扫码关注你的测试号以后，测试平台会出现TA的微信号
                "zBmx5c7PYaq_rr2WazeF1LO5b3rTjcnJqgS_4n3Zc5U",//要给这个人发送的模板ID
                "师帅",//咋称呼这个人
                "北京市",//这个人的详细地址
                "北京",//这个人在的城市
                new BirthDay(1999,8,11,false,false,"生日快乐哦~~"),
                new BirthDay(1999,2,15,true,false,"pt生日快乐！！"),
                new BirthDay(2020,7,8,true,true),
                new BirthDay(2020,7,8,true,false,"周年快乐！！！")
        ));



    }

    public static final List<User> userList = new ArrayList<>();
    static {
        init();
    }


    private static User getUser(String vx, String templateId, String username, String address, String city, BirthDay... birthDays){
        User user=new User();
        user.setVx(vx);
        user.setUserName(username);
        user.setBirthDays(birthDays);
        user.setAddress(address);
        user.setCity(city);
        user.setTemplateId(templateId);
        return user;
    }
    private static User getUser(String vx, String templateId, String username, BirthDay... birthDays){
        return getUser(vx,templateId,username,null,null,birthDays);
    }
    private static User getUser(String vx, String templateId, BirthDay... birthDays){
        return getUser(vx,templateId,null,null,null,birthDays);
    }
    private static User getUser(String vx,BirthDay... birthDays){
        return getUser(vx,null,null,null,null,birthDays);
    }

}
