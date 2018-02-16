/**
 * Created by kecso on 1/22/18.
 */
public class TestFunctionCall {
    public static void main(String[] args) {
        System.out.println("Test function call performance");

        double totalBudget = 123;
        double spendingTillYesterday = 344;

        long startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            double res = totalBudget - spendingTillYesterday < 0 ? 0 : totalBudget - spendingTillYesterday;
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("3 operand " + estimatedTime + "ns");

        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            double res = totalBudget - spendingTillYesterday;
            res = res < 0 ? 0 : res;
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("3 operand B " + estimatedTime + "ns");

        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            double remainingBudget = getRemainingBudgetTillYesterday(totalBudget, spendingTillYesterday);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("function call " + estimatedTime + "ns");
    }

    protected static double getRemainingBudgetTillYesterday(double totalBudget, double spendingTillYesterday) {
        double remainingBudgetTillYesterday = totalBudget - spendingTillYesterday;
        if (remainingBudgetTillYesterday < 0) {
            remainingBudgetTillYesterday = 0;
        }
        return remainingBudgetTillYesterday;
    }

}
