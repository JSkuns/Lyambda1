public class Main {

    public static void main(String[] args) {

        // Supplier<T> - (поставщик) не принимает никаких аргументов, но возвращает объект типа T
        Calculator calc = Calculator.instance.get(); // получаем (instance.get()) конструктор объекта Calculator

        // Predicate<T> - (высказывание об объекте) соблюдение некоторого условия
        System.out.println(calc.isPositive.test(5));
        System.out.println(calc.isPositive.test(-5));

        // Function<T,R> - функция перехода от объекта типа T, к объекту типа R
        System.out.println(calc.convert.apply(7));

        // Consumer<T> - (потребитель) выполняет некоторое действие над объектом T, но ничего не возвращает
        calc.println.accept(600);

        // UnaryOperator<T> - принимает один объект типа T, выполняет над ним какие-то операции, и возвращает объект типа T
        int x = calc.pow.apply(9);
        int y = calc.abs.apply(-33);
        calc.println.accept(x);
        calc.println.accept(y);

        // BinaryOperator<T> - принимает два объекта типа T, выполняет над ними какие-то операции, и возвращает объект типа T
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.multiply.apply(5, 5);
        calc.println.accept(a);
        calc.println.accept(b);
        calc.println.accept(c);

        // здесь ошибка
        int z = calc.devide.apply(a, b);

        // в результате вычисления происходит деление на ноль
        // a = 1 + 2 = 3;
        // b = 1 - 1 = 0;
        // z = 3 / 0 = ...

        // один из вариантов возможного решения:
//        double z = Double.NaN;
//        try {
//            z = calc.devide.apply(a, b);
//        } catch (ArithmeticException e) {
//            if (a > 0) {
//                z = Double.POSITIVE_INFINITY;
//                System.out.print("(a > 0) (b == 0) - divide by zero -> ");
//            } else if (a == 0) {
//                System.out.print("(a == 0) (b == 0) - divide by zero -> ");
//            } else {
//                z = Double.NEGATIVE_INFINITY;
//                System.out.print("(a < 0) (b == 0) - divide by zero -> ");
//            }
//        }  finally {
//            System.out.println(z); // так как вычисления в BinaryOperator<Integer>, то дробная часть отбрасывается
//        }

    }
}

