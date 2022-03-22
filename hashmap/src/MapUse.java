public class MapUse {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        for(int  i = 0; i < 20; i++) {
            map.insert("anurag"+i, i+1);
            System.out.println(map.loadFactor());
        }

        System.out.println(map.removeKey("anurag1"));
        System.out.println(map.removeKey("anurag7"));

        for(int  i = 0; i < 20; i++) {
            System.out.println("anurag"+i+":" + map.getValue("anurag"+i));
        }
    }
}
