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


        //  printEmployees(employees); // вызов метода (1)
        // int salarySum = calculateSalary(employees); // (2)
        //  System.out.println("Сумма зарплат = " + salarySum);
        // Employee minSalary = minSalary(employees); // (3)
        //  System.out.println("Сотрудник с минимальной зарплатой - " + minSalary.getName());
        // Employee maxSalary = maxSalary(employees); // (4)
        //  System.out.println("Сотрудник с максимальной зарплатой - " + maxSalary.getName());
        //  double averageSalary = calculateAverageSalary(employees);// (5)
        //  System.out.println("Средняя зарплата = " + averageSalary);
        //  printNames(employees); // (6)

        // 2 часть
        indexSalary(employees);
        minSalaryDepartment(employees);
        maxSalaryDepartment(employees);
        sumSalaryDepartment(employees);
        averageSalaryDepartment(employees);
        indexSalaryDepartment(employees);
        infoDepartment(employees);
        salaryIsLess(employees);
        salaryIsMore(employees);


    }


    private static void printEmployees(Employee[] employees) { // (1)
        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // private static int calculateSalary(int employees) { // (2)
    //   int salarySum = 0;
    //for (Employee employee : employees) {
    //    salarySum += employee.getSalary();
    //  }
    //  return salarySum;
    // }

    private static Employee minSalary(Employee[] employees) { // (3)
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < employees[index].getSalary()) {
                index = i;
            }
        }
        return employees[index];
    }

    private static Employee maxSalary(Employee[] employees) { // (4)
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > employees[index].getSalary()) {
                index = i;
            }
        }
        return employees[index];
    }

    //private static double calculateAverageSalary(Employee[] employees) { // (5)
    //    int salarySum = calculateSalary(employees);
    //    double averageSum = (double) salarySum / employees.length;
    //     return averageSum;
    //  }

    private static void printNames(Employee[] employees) { // (6)
        System.out.println("ФИО сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    // 2 часть
    public static void indexSalary(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary((int) (employees[i].getSalary() * 1.2));

        }
    }


    public static void minSalaryDepartment(Employee[] employees) { // 2.1
        int index = 0;
        int department = 2;
        int minSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department && (minSalary > employees[i].getSalary() || minSalary == 0)) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        System.out.println("в " + employees[index].getDepartment() + " департаменте минимальная заработная плата: " + employees[index].getName() + " " + employees[index].getSalary());
    }


    public static void maxSalaryDepartment(Employee[] employees) { // 2.2
        int index = 0;
        int department = 2;
        int maxSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department && (maxSalary < employees[i].getSalary() || maxSalary == 0)) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        System.out.println("в " + employees[index].getDepartment() + " департаменте максимальная заработная плата: " + employees[index].getName() + " " + employees[index].getSalary());
    }

    public static void sumSalaryDepartment(Employee[] employees) { // 2.3
        int salaryDepartment = 0;
        int department = 2;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                salaryDepartment += employees[i].getSalary();
            }
        }
        System.out.println("в " + department + " департаменте, затраты по зартплате составляют " + salaryDepartment);
    }

    public static void averageSalaryDepartment(Employee[] employees) { // 2.4
        int department = 2;
        int salaryDepartment = 0;
        int averageSumDepartment;
        int quantity = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                salaryDepartment += employees[i].getSalary();
                quantity += employees[i].getDepartment() / department;
            }
        }
        averageSumDepartment = salaryDepartment / quantity;
        System.out.println("в " + department + " департаменте, средняя заработная плата составляет " + averageSumDepartment);
    }

    private static void indexSalaryDepartment(Employee[] employees) { //2.5
        double indexSalaryDep;
        for (int i = 0; i < employees.length; i++) {
            indexSalaryDep = employees[i].getDepartment() * 1.01;
            employees[i].setSalary(employees[i].getSalary() * indexSalaryDep);
        }
        System.out.println();
    }


    private static void infoDepartment(Employee[] employees) { //2.6
        int department = 2;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println(employees[i].getName() + " " + employees[i].getSalary());
            }
        }
        System.out.println();
    }

    private static void salaryIsLess(Employee[] employees) { // 3.1
        int lessSum = 250000;
        System.out.println("Сотрудники с заработной платой меньше " + lessSum);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < lessSum) {
                System.out.println("№" + employees[i].getId() + " " + employees[i].getName() + " " + employees[i].getSalary());
            }
        }
        System.out.println();
    }

    private static void salaryIsMore(Employee[] employees) { //3.2
        int moreSum = 250000;
        System.out.println("Сотрудники с зартлатой от " + moreSum);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= moreSum) {
                System.out.println("N" + employees[i].getId() + " " + employees[i].getName() + " " + employees[i].getSalary());
            }
        }
    }
}



