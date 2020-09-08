package cn.bdqn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class test {

    @Test
    public void test1(){
        Aimpl a = new Aimpl();
        int i = a.add(10,20);
        System.out.println(i);
        int w =a.jian(20,10);
        System.out.println(w);
    }
    @Test
    public void test2(){
        A a = (num1,num2)->num1+num2;
        int add= a.add(10,20);
        System.out.println(add);
    }
    @Test
    public void test3(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1003,"ccc",29,1));
        list.add(new Student(1004,"fff",32,1));
        list.add(new Student(1005,"ddd",17,3));
        //以年龄排序
        list.sort((stu1,stu2)->stu1.getAge()>stu2.getAge()?1:-1);
        list.forEach(System.out::println);
    }
    @Test
    public void test4(){
        //代表了接受一个输入参数并且无返回的操作
        Consumer<Integer> a = (x)->System.out.println(x*100);
        a.accept(100);
    }
    @Test
    public void test5(){
        //接受一个输入参数，返回一个结果。
        Function<Integer,String> f = (a)->a+"武汉创美。";
        System.out.println(f.apply(10086));
    }
    @Test
    public void test6(){
        //接受一个输入参数，返回一个布尔值结果。
        Predicate<Student> p = (stu)->stu.getAge()>20;
       boolean s = p.test(new Student(1003,"ccc",29,1));
       System.out.println(s);
    }
    @Test
    public void test7(){
        //无参数，返回一个结果。
        Supplier<String> s = ()->"伯格很帅";
        System.out.println(s.get());
    }
    @Test
    public void test8(){
        //构造方法
        Supplier<Student> s = Student::new;
        Student stu=s.get();
        System.out.println(stu);
        //静态方法
        Consumer<String> c = Student::show;
        c.accept("尹哲");
        //对象(实例)方法
        Consumer<Student> d = Student::show2;
        d.accept(new Student(1003,"ccc",29,1));

    }
}
