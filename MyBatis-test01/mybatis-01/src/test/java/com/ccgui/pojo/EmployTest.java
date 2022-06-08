package com.ccgui.pojo;
import com.mysql.cj.util.DnsSrv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class EmployTest {
    private static  int id;
    private static String worknu;
    private static String workname;
    private static String gender;
    private static int age;
    private static String idcard;

    private  static String city;
    private static Date  entrydate;

    public static int getId() {
        Random random = new Random();
        id = random.nextInt(100000);
        return id;
    }

    public static String getWorkun() {
        Random random = new Random();
        worknu = String.valueOf(random.nextInt(100000));
        return worknu;
    }



    public static String getWorkname() {
        String[] firstname={"周","吴","徐","孙","胡","朱","高","林","何","郭","马","罗","梁","宋","郑","谢","韩","唐","冯","董","萧","程","曹","袁","邓","许","傅"};
        String[] secondname={ "伟","刚","勇","毅","俊","峰","强","军","平","秀","娟","英","华","慧","巧","美","娜","静","淑","惠","珠","翠","雅","芝","玉","萍","红","娥","玲","芬","芳","燕","彩","春","菊","兰","凤","洁","梅","琳","素"};
        String[] thirdname={"东","文","辉","力","明","永","健","世","广","志","义","兴","良","海","山","仁","波","宁","贵","福","生","龙","云","莲","真","环","雪","荣","爱","妹","霞","香","月","莺","媛","艳","瑞","凡","佳","嘉","琼","勤","珍","贞","莉","桂","娣","叶","璧","璐","娅","琦","晶","妍"};

        Random random = new Random();
        int first =random.nextInt(firstname.length);
        int second =random.nextInt(secondname.length);
        int third =random.nextInt(thirdname.length);
        workname = firstname[first] + secondname[second] + thirdname[third];
        return workname;
    }


    public static String getGender() {
        String[] employGender={"男","女"};
        Random random = new Random();
        gender = employGender[random.nextInt(2)];
        return gender;
    }



    public static int getAge() {
        Random random = new Random();
        age = random.nextInt(47)+18;
        return age;
    }



    public static String getIdcard() {
        idcard = String.valueOf((int)((Math.random()*9+1)*100000)) + (int)((Math.random()*9+1)*100000)+ (int)((Math.random()*9+1)*100000);
        return idcard;
    }

    public static String getCity(){
        String[] citys = {"河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","台湾省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省"};
        Random random = new Random();
        String city = citys[random.nextInt(citys.length)];
        return city;
    }

    public static Date getEntrydate() throws ParseException {


        Random rndYear=new Random();
        int year=rndYear.nextInt(18)+2000;  //生成[2000,2017]的整数；年
        Random rndMonth=new Random();
        int month=rndMonth.nextInt(12)+1;   //生成[1,12]的整数；月
        Random rndDay=new Random();
        int Day=rndDay.nextInt(30)+1;       //生成[1,30)的整数；日
        String date = year+"-"+month+"-"+Day;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newTime = format.parse(date);
        System.out.println("转换以后的时间：："+newTime);//Sun Feb 02 02:02:02 CST 2020
        entrydate = newTime;
        return entrydate;
    }



    @Override
    public String toString() {

        try {
            return "Employ{" +
                    "id=" + getId() +
                    ", workun='" + getWorkun() + '\'' +
                    ", workname='" + getWorkname() + '\'' +
                    ", gender='" + getGender() + '\'' +
                    ", age=" + getAge() +
                    ", idcard='" + getIdcard() + '\'' +
                    ", city='" + getCity() + '\'' +
                    ", entrydate=" + getEntrydate() +
                    '}';
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
