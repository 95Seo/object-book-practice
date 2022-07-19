package Chapter12;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {

    public FormattedGradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
        super(title, pass, grades, scores);
    }

    // GradeLecture에는 average 메서드가 없다.
    // 만일 super 참조가 부모 클래스에 정의된 메서드를 실행하기 위한 것이었다면 이 코드는 오류다.
    // super 참조의 정확한 의도는 '지금 이 클래스의 부모 클래스에서부터 메서드 탐색을 시작하세요'다
    // 만일 부모 클래스에서 원하는 메서드를 찾지 못한다면, 더 상위 부모 클래스로 이동하면서 메서드가 존재하는지 검사한다.
    public String formatAverage() {
        return String.format("Avg: %1.1f", super.average());
    }
}
