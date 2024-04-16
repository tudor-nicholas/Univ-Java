
public class App {
    public static int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        return sum;
    }

    public static int cmmdc3(int a, int b, int c) {
        int cmmdcAB = cmmdc(a, b);
        return cmmdc(c, cmmdcAB);
    }

    public static int cmmdc(int a, int b) {
        int d = Math.max(a, b), i = Math.min(a, b), r = d % i;
        while (r != 0) {
            d = i;
            i = r;
            r = d % i;
        }
        return i;
    }

    static int numarCifre(int n) {
        int contor = 0;
        while (n != 0) {
            contor++;
            n = n / 10;
        }
        return contor;
    }

    static int numarDivizoriProprii(int a) {
        int contor = 0;
        for (int d = 2; d <= a / 2; d++)
            if (a % d == 0)
                contor++;
        return contor;
    }

    static int suma(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++)
            s += i;
        return s;
    }

    static long factorial(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
    }

    public static void main(String[] args) {
        int n = 5, x = 12, z = 620, y = 82;
        System.out.println("Ex1-");
        System.out.println("---------");
        System.out.println("Copiaza exemplele de mai sus");
        System.out.printf("%d!=%d\n", n, factorial(n));
        System.out.printf("Suma primelor %d numere naturale nenule este %d\n", n, suma(n));
        System.out.printf("Numarul divizorilor proprii lui %d este %d\n", x, numarDivizoriProprii(x));
        System.out.printf("Numarul cifrelor lui %d este %d\n", z, numarCifre(z));
        System.out.println("");
        System.out.println("Ex2-");
        System.out.println("---------");
        System.out.println("Aflati cmmdc pentru 2 numere");
        System.out.printf("Cmmdc: %d\n", cmmdc(x, z));
        System.out.println("");
        System.out.println("Ex3-");
        System.out.println("---------");
        System.out.printf("Cmmdc pentru 3 numere este: %d\n", cmmdc3(x, y, z));
        System.out.println("");
        System.out.println("Ex4-");
        System.out.println("---------");
        System.out.printf("Suma cifrelor unui numar este: %d\n", digitSum(z));
        System.out.println("");

    }
}
