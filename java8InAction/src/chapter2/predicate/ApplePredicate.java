package chapter2.predicate;

import chapter2.vo.Apple;

// 사과 선택 전략을 캡슐화함.
// 알고리즘 패밀리,
// 어떻게 다양한 동작을 수행할 수 있을까? filterApples 에서 ApplePredicate객체를 받아 애플의 조건을 검사하도록 메소드 수정.
public interface ApplePredicate {
    boolean test(Apple apple);
}
