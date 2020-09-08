package cn.bdqn;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 商品类:
 * 编号:      名字:      数量:     价格:     类别:(id)
 * 定义List集合:  存放10个商品
 * <p>
 * 商品扩展类:   继承 商品类    扩展数量      产地
 * <p>
 * 利用stream 完成以下:
 * 1   找出最贵的商品信息
 * 2   查询名字里面带 花  的商品
 * 3   查询 类别  1 里面 商品数量为 0 的商品 并且转为map集合, 键为 商品编号,  值为 商品对象
 * 4   求出 类别 2 所有商品的  最高价   最低价   平均价
 * 5   求出每种类别下面商品为0的商品
 * 6   查询商品价格大于100的商品,  并且使用扩展类  设置产地为中国, 并且使用价格进行排序 ,返回扩展类集合
 */
public class zuoye {
    List<Student> list = new ArrayList<>();

    @Before
    public void inif() {
        list.add(new Student(1001,"aaa",101,1));
        list.add(new Student(1002,"bbb",16,2));
        list.add(new Student(1003,"ccc",29,1));
        list.add(new Student(1004,"fff",32,1));
        list.add(new Student(1005,"ddd",17,3));
        list.add(new Student(1006,"ggg",23,3));
        list.add(new Student(1007,"eee",500,2));
        list.add(new Student(1008,"hhh",23,3));
        list.add(new Student(1009,"iii",51,1));
        list.add(new Student(1010,"kkk",300,1));
        list.add(new Student(1011,"xxx",16,2));
        list.add(new Student(1012,"nnn",32,3));
        list.add(new Student(1013,"lll",20,2));
        list.add(new Student(1014,"mmm",22,1));
    }

    @Test
    public void test1() {
        Optional<Student> max = list.stream().max((stu1, stu2) -> stu1.getAge() > stu2.getAge() ? 1 : -1);
        System.out.println(max);
    }

    @Test
    public void test2() {
        Stream<Student> a = list.stream().filter(student -> student.getSname().contains("a"));
        a.forEach(s->System.out.println(s));
    }
    @Test
    public void test3(){
        Stream<Student> studentStream = list.stream().filter(student -> student.getType().equals(1));
        Stream<Student> studentStream1 = studentStream.filter(student -> student.getSno().equals(1001));
        Map<Integer, Student> collect = studentStream1.collect(Collectors.toMap(o -> o.getSno(), o ->o));
        System.out.println(collect.toString());
    }
    @Test
    public void test4(){
        List<Student> studentStream = list.stream().filter(student -> student.getType().equals(2)).collect(Collectors.toList());
        IntSummaryStatistics collect = studentStream.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(collect.getAverage());
        System.out.println(collect.getMin());
        System.out.println(collect.getMax());
    }
    @Test
    public void test5(){
        List<Student> studentStream = list.stream().filter(student -> student.getSno().equals(0)).collect(Collectors.toList());
        System.out.println(studentStream);
    }
    @Test
    public void test6(){
        Stream<Student> studentStream = list.stream().filter(student -> student.getAge() > 100).sorted();
        Map<Integer, StudentTow> stu = studentStream.collect(Collectors.toMap(student -> student.getSno(), o -> new StudentTow("中国")));
        System.out.println(stu.toString());
    }

}
