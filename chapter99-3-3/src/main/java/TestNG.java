import org.junit.Test;

/**
     * @Description:
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2018年12月19日18:25:15
*/

public class TestNG {

    @Test
    public void test(){

        String temp = "1000";
//        int i = Integer.parseInt(temp);
        Long i = Long.parseLong(temp);
        System.out.println(i);

    }

}
