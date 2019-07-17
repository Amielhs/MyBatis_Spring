package com.bdqn.mybatis.pojo;
/**
 * @ClassName: HelloSpring
 * @Description:HelloSpring实体类
 * @Author: amielhs
 * @Date 2019-06-25
 */
public class HelloSpring {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    /**
     * @Description:打印方法
     * @param: []
     * @return: void
     * @Date: 2019-06-25
     */
    public void print(){
        System.out.println("hello,"+name);
    }
}
