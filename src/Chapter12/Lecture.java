package Chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {
    private int pass;
    private String title;
    private List<Integer> scores = new ArrayList<>();

    public Lecture(String title, int pass, List<Integer> scores) {
        this.title = title;
        this.pass = pass;
        this.scores = scores;
    }

    public String stats() {
        return String.format("Title: %s, Evaluation Method: %s", title, getEvaluationMethod());
    }

    // 만약 GradeLecture를 인스턴스화한 객체에서 stats메시지를 전송한다면, self참조에 의해 GradeLecture의 인스턴스에서 부터
    // GradeLecture의 인스턴스의 Class 포인터를 따라가 GradeLecture클래스에 정의된 stats를 찾게된다.
    // 만약 GradeLecture 클래스에 stats메서드가 없다면, Parents 포인터를 따라가 GradeLecture의 부모 클래스인
    // Lecture의 stats를 탐색한다. Lecture클래스의 stats를 실행한 후 코드에 따라 stats의 내부의 getEvaluationMethod를 실행하게 되면
    // self전송에 의해 다시 self참조가 가리키는 GradeLecture의 인스턴스부터 탐색하게 되고,
    // 결국, 코드에서 의도한 Lecture클래스 내부의 getEvaluationMethod 메소드가
    // 아닌 GradeLecture클래스의 내부에 정의된 getEvaluationMethod 메소드가 실행되게 된다.
    // 이것을 self전송에 의한 오류라고 부른다.
    public String getEvaluationMethod() {
        return "Pass or Fail";
    }

    public double average() {
        return scores.stream()
                .mapToDouble(Integer::intValue)
                .average().orElse(0);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public String evaluate() {
        return String.format("Pass:%d Fail:%d", passCount(), failCount());
    }

    private long passCount() {
        return scores.stream().filter(score -> score >= pass).count();
    }

    private long failCount() {
        return scores.size() - passCount();
    }
}
