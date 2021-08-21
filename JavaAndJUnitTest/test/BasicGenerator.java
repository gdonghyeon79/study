import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BasicGenerator {

    private final static char[] digits = {
            '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','-','.','_','~'
    };

    public static String next(){
        UUID u = UUID.randomUUID();
        return toIdString(u.getMostSignificantBits()) + toIdString(u.getLeastSignificantBits());
    }

    private static String toIdString(long i) {
        char[] buf = new char[32];
        int z = 64;
        int cp = 32;
        long b = z - 1;
        do{
            buf[--cp] = digits[(int)(i&b)];
            i>>>=6;

        }while(i != 0);
        return new String(buf, cp, (32-cp));
    }

    public static void main(String[] args) {
        List<String> checkArray = new ArrayList<>();

        boolean contains = false;
        for(int i=0 ; i < 500 ; i++){
            String id = BasicGenerator.next();
            //
            contains = checkArray.contains(id);

            checkArray.add(id);
            System.out.println(">> " + id + " Check : " + contains);
        }

        if(contains){
            System.out.println("Exist Duplicated Keys");
        }else{
            System.out.println("Safe No Duplication Key");
        }

    }
}
