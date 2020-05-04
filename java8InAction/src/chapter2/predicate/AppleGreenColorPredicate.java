package chapter2.predicate;

import chapter2.vo.Apple;

// 전략
public class AppleGreenColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return "green".equals( apple.getColor() );
    }

}
