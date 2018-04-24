public class TestSplit {
    public static void main(String[] args) {
        String name = "biefeng|biefeng";
        for (String s : name.split("\\|")) {
            System.out.println(s);
        }
        String sun = "acount =? and uu =? or cc=?";
        for (String s : sun.split("and|or")) {
            System.out.println(s);
        }
    }
}
