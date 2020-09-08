package cn.bdqn;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {
    List<Student> list = new ArrayList<>();
    //每次测试都会执行的方法
    @Before
    public void init(){
        list.add(new Student(1001,"aaa",19,1));
        list.add(new Student(1002,"bbb",16,2));
        list.add(new Student(1003,"ccc",29,1));
        list.add(new Student(1004,"fff",32,1));
        list.add(new Student(1005,"ddd",17,3));
        list.add(new Student(1006,"ggg",23,3));
        list.add(new Student(1007,"eee",43,2));
        list.add(new Student(1008,"hhh",23,3));
        list.add(new Student(1009,"iii",51,1));
        list.add(new Student(1010,"kkk",22,1));
        list.add(new Student(1011,"xxx",16,2));
        list.add(new Student(1012,"nnn",32,3));
        list.add(new Student(1013,"lll",20,2));
        list.add(new Student(1014,"mmm",22,1));
    }
    @Test
    public void stream01(){
        //获取流
            //集合获取
            list.stream();//串行流
            list.parallelStream();//并行流（多线程）
            //数组方式获取流
            Stream.of(1,2,3,4,5,6,7,8);
            //generate,linmit取100个数，否则无限流
            Stream.generate(new Random()::nextInt).limit(100);

    }
    @Test
    public void stream02(){
        //查询年龄最小 最大
//        Optional<Student> min = list.stream().min((stu1, stu2) -> stu1.getAge() < stu2.getAge() ? -1 : 1);
//        Optional<Student> max = list.stream().max((stu1, stu2) -> stu1.getAge() < stu2.getAge() ? -1 : 1);
//        Student student = min.get();
//        System.out.println(student);
        //collect终止返回list ， toset可以简单去重 ，tomap收集
//        List<Student> collect = list.stream().collect(Collectors.toList());
//        System.out.println(collect);
        //求年龄的总和 , summarizingInt方法可以得最大最小和等函数
        Integer collect1 = list.stream().collect(Collectors.summingInt(stu -> stu.getAge()));
        System.out.println(collect1);
//        list.stream().forEach(System.out::println);

        //分组
        Map<Boolean, List<Student>> collect = list.stream().collect(Collectors.partitioningBy(student -> student.getAge() < 20));
        System.out.println(collect);


    }
}
