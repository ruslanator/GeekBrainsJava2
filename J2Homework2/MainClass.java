package J2Homework2;

public class MainClass {

    private static String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    //private static String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0 3"; test string
    //private static String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 gfg"; test string

    public static void main(String[] args) {
        String[][] arr = convertString(s);
        System.out.println(arraySum(arr));
    }

    static String[][] convertString(String s) {
        String tmp = s + "\n";
        int col = 0;
        for (int i = 0, space = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ' ') {
                space++;
            }
            if (tmp.charAt(i) == '\n') {
                col++;
                if (space == 3) space = 0;
                else throw new NewException("размер матрицы, полученной из строки, не равен 4x4");
                }
            }
        if(col == 4){
        } else throw new NewException("размер матрицы, полученной из строки, не равен 4x4");

        int length = s.split("\n").length;
        String[][] newStrings = new String[length][length];
        String[] indent = s.split("\n");

        for (int i = 0; i < length; i++) {
            String[] spaces = indent[i].split(" ");
            for (int j = 0; j < length; j++) {
                newStrings[i][j] = spaces[j];
            }
        }
        return newStrings;
    }

    static double arraySum(String[][] s) {
        int result = 0;
        for (String[] str : s) {
            for (String str1 : str) {
                try {
                    result += Integer.parseInt(str1);
                } catch (NumberFormatException e) {
                    System.out.println("Значение ячейки не является типом данных int \n" + e.getMessage());
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        return result / 2;
    }
}

