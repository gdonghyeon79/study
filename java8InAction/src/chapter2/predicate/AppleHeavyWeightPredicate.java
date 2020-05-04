package chapter2.predicate;

import chapter2.vo.Apple;

// 전략
public class AppleHeavyWeightPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() < 150;
    }

}
