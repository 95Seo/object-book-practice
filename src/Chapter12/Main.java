package Chapter12;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Lecture lecture = new Lecture("객체지향 프로그래밍",
                70,
                Arrays.asList(81, 95, 75, 50, 45));

        String evaluration = lecture.evaluate();    // 결과 => "Pass:3 Fail:2"
        System.out.println(evaluration);

        Lecture lecture1 = new GradeLecture("객체지향 프로그래밍",
                70,
                Arrays.asList(new Grade("A", 100, 95),
                        new Grade("B",94,80),
                        new Grade("C", 79, 70),
                        new Grade("D",69,50),
                        new Grade("F",49,0)),
                Arrays.asList(81, 95, 75, 50, 45));

        // 결과 => "Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1"
        String evaluration1 = lecture1.evaluate();
        System.out.println(evaluration1);

        Professor professor = new Professor("다익스트라",
                new Lecture("알고리즘",
                        70,
                        Arrays.asList(81, 95, 75, 50, 45)));

        // 결과 => "[다익스트라] Pass:3 Fail:2 - Avg: 69.2"
        String statistics = professor.compileStatistics();
        System.out.println(statistics);

        // 만약 Professor의 생성자에 Lecture가 아닌 GradeLecture를 전달하면 어떻게 될까?
        Professor professor1 = new Professor("다익스트라",
                new GradeLecture("객체지향 프로그래밍",
                        70,
                        Arrays.asList(new Grade("A", 100, 95),
                                new Grade("B",94,80),
                                new Grade("C", 79, 70),
                                new Grade("D",69,50),
                                new Grade("F",49,0)),
                        Arrays.asList(81, 95, 75, 50, 45)));

        // 결과 => "[다익스트라] Pass:3 Fail:2 - A:1 B:1 C:1 D:1 F:1 - Avg: 69.2"
        String statistics1 = professor1.compileStatistics();
        System.out.println(statistics1);
    }
}
