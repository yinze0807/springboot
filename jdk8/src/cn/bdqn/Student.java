package cn.bdqn;

public class Student {
    private Integer sno;
    private String sname;
    private Integer age;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(Integer sno, String sname, Integer age,Integer type) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.type=type;
    }

    public Student() {
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public static void show(String name){
        System.out.println(name+"真的很帅");
    }
    public static void show2(Student stu){
        System.out.println(stu);
    }
}
