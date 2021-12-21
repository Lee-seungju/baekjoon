public class Test {

    public static void main(String[] args) {
        for (int i=1; i < 1000000; i++) {
            System.out.println("i = " + i);
            int result = test(i);
            int sum = 0;
            while (result != 0) {
                sum += result % 10;
                result /= 10;
            }
            if (sum + result != i) {
                System.out.println("-----error-----");
                System.out.println("sum = " + sum);
                System.out.println("result = " + result);
                System.out.println("i = " + i);
            }
        }
    }

    static public int test(int num) {
        int result = 0;
        int digit = 0;
        int copy = num;
        while (copy != 0) {
            copy /= 10;
            digit++;
        }
        copy = num;
        while (digit != 0) {
            int one_num;
            result *= 10;
            one_num = copy / ((int)Math.pow(10, digit - 1) + 1);
            int check = copy % ((int)Math.pow(10, digit - 1) + 1);
            if (one_num > 9) {
                one_num = 9;
            } else if (digit > 1 && digit <= 3 && check / ((int)Math.pow(10, digit - 2) + 1) <= 2 ||
                    digit > 1 && check / ((int)Math.pow(10, digit - 2) + 1) == 0) {
                one_num -= 1;
            }
            copy -= one_num * ((int)Math.pow(10, digit - 1) + 1);
            result += one_num;
            digit--;
        }
//        int sum = 0;
//        copy = result;
//        while (copy != 0) {
//            sum += copy % 10;
//            copy /= 10;
//        }

       return result;
    }
}
