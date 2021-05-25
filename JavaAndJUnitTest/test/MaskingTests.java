public class MaskingTests
{
    public static void main(String[] args) {

        System.out.println("test masking");



        // 이름 형식
        String name = "만수르";
        String NAME_PATTERN_3JA = "(?<=.{1}).";
        System.out.println("이름 : " + name);
        System.out.println("Masking 이름 : " + name.replaceAll(NAME_PATTERN_3JA , "*"));

        String NAME_PATTERN_4JA = "(?<=.{1}).{1}$";
        String name2 = "만수르다";
        System.out.println("이름2 : " + name2);
        System.out.println("Masking 이름2 : " + name2.replaceAll(NAME_PATTERN_4JA , "*"));

        // 이메일 형식
        String EMAIL_PATTERN = "(?<=.{2})[^@\\n](?=[^@\\n]*?@)|(?:(?<=@.)|(?!^)\\G(?=[^@\\n]*$)).(?=.*\\.)";
        String email = "john.doe@example.en.com";
        System.out.println("이메일 : " + email);
        System.out.println("Masking 이메일 : " + email.replaceAll(EMAIL_PATTERN, "*"));

        int strLength = email.toString().split("@")[0].length() - 3;
       // originStr.toString().replace(new RegExp('.(?=.{0,' + strLength + '}@)', 'g'), '*').replace(/.{6}$/, "******");


        String LAST_6_CHAR_PATTERN = "(.{6}$)";
        // 주민번호 형식
        String certNum = "123456-1234567";
        System.out.println("주민번호 : " + certNum);
        System.out.println("Masking 주민번호 : " + certNum.replaceAll(LAST_6_CHAR_PATTERN, "******"));

        // 연락처 형식
        String PHONE_PATTERN = "([\\w.])(?:[\\w.]*)";
        String phoneNum = "01012345678";
        System.out.println("연락처 : " + phoneNum);
        System.out.println("연락처 : " + phoneNum.replaceAll(PHONE_PATTERN, "$1$2*$3**$4$5**$6"));





    }
}
