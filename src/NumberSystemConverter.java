// NumberSystemConverter
// 2023 Rand7Y9Z@gmail.com

public class NumberSystemConverter {

    public static String programName = "NumberSystemConverter";
    public static double version = 1.0;

    public static void main(String[] args) {
        System.out.println("\n"+programName + " " + version + "\n" +""" 
                --------------------------------------------------------------------------------------------------------
                Converts a number from a any number system into another number system. """);

        Z:
        while (true) {
            System.out.println("To close to programm, write 'end'.\n");

            String[] a = new String[]{"input base: ", "input number: ", "output base: "};
            String[] b = new String[3];
            for (int i = 0; i < a.length; ) {
                String input = readLine(a[i]);
                if (input.equals("end")) {
                    System.out.println("--> The programm has been closed.");
                    break Z;
                }
                b[i] = input;
                if (i != 1) {
                    try {
                        Integer.parseInt(input);
                        i++;
                    } catch (Exception e) {
                        System.out.println("invalid input");
                    }
                } else {
                    i++;
                }
            }
            System.out.println("output number: " + numToNum(b[1], Integer.parseInt(b[0]), Integer.parseInt(b[2])));

        }

    }

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static String readLine(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int getValue(char digit) {
        if (digit >= '0' && digit <= '9') return digit - '0';

        return (digit >= 'A' && digit <= 'F') || (digit >= 'a' && digit <= 'f')? String.valueOf(digit).toUpperCase().charAt(0) - 'A' + 10: -1;
    }

    public static char getDigit(int value) {
        if (value >= 0 && value <= 9) return (char) (value + '0');

        return value >= 10 && value <= 35 ? (char) (value + 'A' - 10) : '*';
    }

    public static long numToDec(String nr, int base) {
        if (base < 2 || base > 36) return -1;

        long r = 0;
        long m = 0;

        for (int i = nr.length() - 1; i >= 0; i--) {
            long j = getValue(nr.charAt(i));
            if (j != -1 && j < base) {
                r += (long) (j * Math.pow(base, m));
                m++;
            }
        }

        return r;
    }

    public static String numToNum(String nr, int oldBase, int newBase) {
        if (oldBase < 2 || oldBase > 36 || newBase < 2 || newBase > 36) return "BaseError";

        StringBuilder r = new StringBuilder();

        long i = (int) numToDec(nr, oldBase);
        while (i > 0) {
            if (getDigit((int) (i % newBase)) != '*') r.insert(0, getDigit((int) (i % newBase)));
            i /= newBase;
        }

        return r.toString();
    }

}

