package cn.bdqn;

public class StudentTow {
    private String chandi;

    public String getChandi() {
        return chandi;
    }

    public void setChandi(String chandi) {
        this.chandi = chandi;
    }

    public StudentTow(String chandi) {
        this.chandi = chandi;
    }

    @Override
    public String toString() {
        return "StudentTow{" +
                "chandi='" + chandi + '\'' +
                '}';
    }
}
