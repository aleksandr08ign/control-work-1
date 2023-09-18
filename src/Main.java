import javax.lang.model.element.Name;
import java.text.MessageFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Павлов Матвей Иванович", 1, 65000);
        employees[1] = new Employee("Сорокин Александр Артемьевич", 2, 63000);
        employees[2] = new Employee("Морозова Сафия Демидовна", 3, 45000);
        employees[3] = new Employee("Гусев Данила Артёмович", 4, 71000);
        employees[4] = new Employee("Михайлов Илья Фёдорович", 5, 38000);
        employees[5] = new Employee("Голикова Сафия Максимовна", 1, 81000);
        employees[6] = new Employee("Алексеева Таисия Олеговна", 2, 58000);
        employees[7] = new Employee("Трифонова Алиса Ивановна", 3, 67000);
        employees[8] = new Employee("Окулова Кира Александровна", 4, 56000);
        employees[9] = new Employee("Журавлев Михаил Евгеньевич", 5, 66000);

        printEmployees(employees); // вызов метода (1)
        int salarySum = calculateSalary(employees); // (2)
        System.out.println("Сумма зарплат = " + salarySum);
        Employee minSalary = minSalary(employees); // (3)
        System.out.println("Сотрудник с минимальной зарплатой - " + minSalary.getName());
        Employee maxSalary = maxSalary(employees); // (4)
        System.out.println("Сотрудник с максимальной зарплатой - " + maxSalary.getName());
        double averageSalary = calculateAverageSalary(employees);// (5)
        System.out.println("Средняя зарплата = " + averageSalary);
        printNames(employees); // (6)
    }

    private static void printEmployees(Employee[] employees) { // (1)
        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int calculateSalary(Employee[] employees) { // (2)
        int salarySum = 0;
        for (Employee employee : employees) {
            salarySum += employee.getSalary();
        }
        return salarySum;
    }

    private static Employee minSalary (Employee[] employees) { // (3)
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < employees[index].getSalary()) {
                index = i;
            }
        } return employees[index];
    }

    private static Employee maxSalary (Employee[] employees) { // (4)
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > employees[index].getSalary()) {
                index = i;
            }
        } return employees[index];
    }

    private static double calculateAverageSalary(Employee[] employees) { // (5)
        int salarySum = calculateSalary(employees);
        double averageSum = (double) salarySum / employees.length;
        return averageSum;
    }

    private static void printNames(Employee[] employees) { // (6)
        System.out.println("ФИО сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}
