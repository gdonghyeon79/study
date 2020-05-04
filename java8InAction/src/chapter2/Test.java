package chapter2;

import chapter2.predicate.ApplePredicate;
import chapter2.predicate.AppleRedAndHeavyPredicate;
import chapter2.vo.Apple;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList <>();
        // list 채우기

        // 두 번째 메소드 실행
        List<Apple> greenApples = filterApplesByColor( inventory, "green" );
        List<Apple> redApples = filterApplesByColor( inventory, "red" );

        // 네 번째 메소드 실행
        List<Apple> greenApples2 = filterApples_old( inventory, "green", 0 , true );
        List<Apple> heavyApples = filterApples_old( inventory, "", 0 , false );
        // 형편없는 코드 예, 앞으로 요구사항에 유연 대응 어려움, if 사과크기, 모양, 출하지 사과를 필터링 하고 싶다면?

        // >>> 동작파라미터화를 통해 유연성 얻는 방법.
        // predicate 패키지 참조, fitersApples  메소드 수정

        List<Apple> redAndHeavyApples = filterApples( inventory, new AppleRedAndHeavyPredicate() );

    }

    // 첫 번째 녹색 사과 필터링
    public static List <Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList <>();
        for(Apple apple : inventory){
            // 녹색 사과를 선택하는데 필요한 조건
            if("green".equals( apple.getColor() )){
                result.add(apple);
            }
        }
        return result;
    }

    // 빨간 사과도 필터링이 하고 싶어졌다. 쉽게 카피앤페이스트 할 수 있지만, 다양한 색 대비
    // 비슷한 코드를 구현한 다음에 추상화하라.

    // 두 번째 색을 파라미터화
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
        List<Apple> result = new ArrayList <>();
        for(Apple apple : inventory){
            if(apple.getColor().equals( color )){
                result.add(apple);
            }
        }
        return result;
    }

    // 세 번째, 무게 구분
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList <>();
        for(Apple apple : inventory){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    // 네 번째, 가능한 모든 속성으로 필터링
    public static List<Apple> filterApples_old(List<Apple> inventory, String color, int weight, boolean flag){
        List<Apple> result = new ArrayList <>();
        for(Apple apple : inventory){
            if((flag && apple.getColor().equals( color )) || (!flag&&apple.getWeight() >  weight) ){
                result.add( apple );
            }
        }
        return result;
    }

    // 다섯 번째, 추상적 조건으로 필터링.
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList <>();
        for(Apple apple : inventory){
            if(p.test( apple )){
                result.add( apple );
            }
        }
        return result;
    }

}
