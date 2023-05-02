package LeetCode;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int n = salary.length-2;
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        double average = 0;
        for (int employeeSalary:salary){
            max = Math.max(max,employeeSalary);
            min = Math.min(min,employeeSalary);
            average += (double) employeeSalary/n;
        }
        return average - (min/n + max/n);
    }

    public static void main(String[] args) {
        AverageSalaryExcludingTheMinimumAndMaximumSalary a = new AverageSalaryExcludingTheMinimumAndMaximumSalary();
        int[] salary = {8000,1000,5000,4000,6000};
        System.out.println(a.average(salary));
    }
}
