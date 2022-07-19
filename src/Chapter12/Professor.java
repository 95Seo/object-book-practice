package Chapter12;

// 통계를 계산하는 책임을 지닌 Professor 클래스
// 각 교수별로 강의 성적 통계를 계산하는 기능
public class Professor {
    private String name;
    private Lecture lecture;

    public Professor(String name, Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }

    public String compileStatistics() {
        return String.format("[%s] %s - Avg: %.1f", name,
                lecture.evaluate(), lecture.average());
    }
}
