package com.ccgui;

import java.util.Random;

public class Test01 {

    public static void main(String[] args) {

//            String[] firstname={"男};
//            String[] secondname={ "伟","刚","勇","毅","俊","峰","强","军","平","秀","娟","英","华","慧","巧","美","娜","静","淑","惠","珠","翠","雅","芝","玉","萍","红","娥","玲","芬","芳","燕","彩","春","菊","兰","凤","洁","梅","琳","素"};
//            String[] thirdname={"东","文","辉","力","明","永","健","世","广","志","义","兴","良","海","山","仁","波","宁","贵","福","生","龙","云","莲","真","环","雪","荣","爱","妹","霞","香","月","莺","媛","艳","瑞","凡","佳","嘉","琼","勤","珍","贞","莉","桂","娣","叶","璧","璐","娅","琦","晶","妍"};
        Random random = new Random();

        String  idcard = String.valueOf((int)((Math.random()*9+1)*100000)) + (int)((Math.random()*9+1)*100000)+ (int)((Math.random()*9+1)*100000);
        System.out.println(idcard);
    }
    }

