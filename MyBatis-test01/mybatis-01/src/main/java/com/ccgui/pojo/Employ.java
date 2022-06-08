package com.ccgui.pojo;




import java.util.Date;
import java.util.Random;

public class Employ {
    private int id;
    private String worknu;
    private String workname;
    private String gender;
    private int age;
    private String idcard;
    private Date  entrydate;

    public Employ() {
    }

    public Employ(int id, String worknu, String workname, String gender, int age, String idcard, Date entrydate) {
        this.id = id;
        this.worknu = worknu;
        this.workname = workname;
        this.gender = gender;
        this.age = age;
        this.idcard = idcard;
        this.entrydate = entrydate;
    }

    public int getId() {
        Random random = new Random();
        this.id = random.nextInt(100000);
        return id;
    }

    public String getWorkun() {
        Random random = new Random();
        this.worknu = String.valueOf(random.nextInt(100000));
        return worknu;
    }



    public String getWorkname() {
        String[] firstname={"周","吴","徐","孙","胡","朱","高","林","何","郭","马","罗","梁","宋","郑","谢","韩","唐","冯","董","萧","程","曹","袁","邓","许","傅"};
        String[] secondname={ "伟","刚","勇","毅","俊","峰","强","军","平","秀","娟","英","华","慧","巧","美","娜","静","淑","惠","珠","翠","雅","芝","玉","萍","红","娥","玲","芬","芳","燕","彩","春","菊","兰","凤","洁","梅","琳","素"};
        String[] thirdname={"东","文","辉","力","明","永","健","世","广","志","义","兴","良","海","山","仁","波","宁","贵","福","生","龙","云","莲","真","环","雪","荣","爱","妹","霞","香","月","莺","媛","艳","瑞","凡","佳","嘉","琼","勤","珍","贞","莉","桂","娣","叶","璧","璐","娅","琦","晶","妍"};

        Random random = new Random();
        int first =random.nextInt(firstname.length);
        int second =random.nextInt(secondname.length);
        int third =random.nextInt(thirdname.length);
        this.workname = firstname[first] + secondname[second] + thirdname[third];
        return workname;
    }


    public String getGender() {
        String[] employGender={"男","女"};
        return gender;
    }



    public int getAge() {
        return age;
    }



    public String getIdcard() {
        return idcard;
    }



    public Date getEntrydate() {
        return entrydate;
    }



    @Override
    public String toString() {
        return "Employ{" +
                "id=" + id +
                ", workun='" + worknu + '\'' +
                ", workname='" + workname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", idcard='" + idcard + '\'' +
                ", entrydate=" + entrydate +
                '}';
    }
}
