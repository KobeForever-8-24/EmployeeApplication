// --== CS400 File Header Information ==--
// Name: Weijie Zhou
// Email: wzhou226@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: No note

/**
 * @program: EmployeeApplication
 * @description: This is the main interface of the program
 * @author: Weijie Zhou
 * @create: 2020-09-27 13:01
 **/

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        LogInAndRegister logInAndRegister = new LogInAndRegister();
        while (true) {
            // Here is the start of the program
            System.out.println("Welcome to the Employee Lookup System");
            System.out.println("Please select options below:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);
            String input = "";
            do {
                System.out.print("Enter (1/2/3): ");
                input = scanner.nextLine();
            } while (!input.equals("1") && !input.equals("2") && !input.equals("3"));//
            if (input.equals("3")) {
                break;
            }
            String username = logInAndRegister(logInAndRegister, input);
            if (username == null) {
                continue;
            }
            System.out.println("Welcome Home! " + username);
            if (logInAndRegister.isAdmin(username)) {
                String option = "";
                while (true) {
                    do {
                        /*Here is the user interface of the program for administrator*/
                        System.out.println("\n-------------Employee Information Management Software-------------");
                        System.out.println("1. Get an Employee information (1318-1793)");
                        System.out.println("2. Add Employee");
                        System.out.println("3. Delete Employee");
                        System.out.println("4. Update Employee");
                        System.out.println("5. logout");
                        System.out.print("Please select（1-5) : ");
                        option = scanner.nextLine();
                    } while (!option.equalsIgnoreCase("1")  // rule out the possibility of user typing errors in the next few lines
                            && !option.equalsIgnoreCase("2")
                            && !option.equalsIgnoreCase("3")
                            && !option.equalsIgnoreCase("4")
                            && !option.equalsIgnoreCase("5"));

                    if (option.equalsIgnoreCase("5")) { // if the user enter 5, stop the program
                        break;
                    }

                    int id;
                    while (true) {
                        System.out.print("Employee ID: ");
                        input = scanner.nextLine();
                        try {
                            id = Integer.parseInt(input);
                            break;
                        } catch (Exception e) {
                            System.out.println("Please enter an integer!");
                        }
                    }
                    Employee employee = employeeDatabase.getEmployee(id);// get the employee from according to entered id from database

                    if (option.equalsIgnoreCase("1")) {// user enter 1 for getting information
                        if (employee != null) {
                            System.out.println("Name: " + employee.getName());
                            System.out.println("Date of Birth: " + employee.getDateOfBirth());
                            System.out.println("Gender: " + employee.getGender());
                            System.out.println("Job Title: " + employee.getJobTitle());
                            System.out.println("Status: " + employee.getStatus());
                            System.out.println("Business Unit: " + employee.getBusinessUnit());
                        } else {
                            System.out.println("No Info Available!");
                        }
                    } else if (option.equalsIgnoreCase("2")) {// user enter 2 for adding employee
                        int empID = id;
                        String name;
                        LocalDate dateOfBirth;
                        LocalDate recordDate;
                        LocalDate hireDate;
                        String jobTitle;
                        String gender;
                        String status;
                        String businessUnit;

                        System.out.print("Employee name: ");
                        name = scanner.nextLine();

                        while (true) {
                            System.out.print("Employee gender (1.male/2.female): ");
                            try {
                                int num = Integer.parseInt(scanner.nextLine());

                                if (num == 1) {
                                    gender = "Male";
                                } else if (num == 2) {
                                    gender = "Female";
                                } else {
                                    System.out.println("Invalid output");
                                    continue;
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input!");
                            }
                        }
                        int year, month, day;
                        while (true) {
                            try {
                                System.out.println("Employee date of birth ");
                                while (true) {
                                    System.out.print("year: ");
                                    try {
                                        year = Integer.parseInt(scanner.nextLine());
                                        if (year < 1500 || year > 2020) {
                                            throw new Exception("invalid year");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input!");
                                    }
                                }

                                while (true) {
                                    System.out.print("month: ");
                                    try {
                                        month = Integer.parseInt(scanner.nextLine());
                                        if (month < 1 || month > 12) {
                                            throw new Exception("invalid month");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input!");
                                    }
                                }

                                while (true) {
                                    System.out.print("day: ");
                                    try {
                                        day = Integer.parseInt(scanner.nextLine());
                                        if (day < 1 || day > 31) {
                                            throw new Exception("invalid day");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input!");
                                    }
                                }
                                dateOfBirth = LocalDate.of(year, month, day);
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid Date");
                            }
                        }

                        while (true) {
                            try {
                                System.out.println("Employee hire date: ");

                                while (true) {
                                    System.out.print("year: ");
                                    try {
                                        year = Integer.parseInt(scanner.nextLine());
                                        if (year < 1500 || year > 2020) {
                                            throw new Exception("invalid year");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input!");
                                    }
                                }

                                while (true) {
                                    System.out.print("month: ");
                                    try {
                                        month = Integer.parseInt(scanner.nextLine());
                                        if (month < 1 || month > 12) {
                                            throw new Exception("invalid month");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input!");
                                    }
                                }

                                while (true) {
                                    System.out.print("day: ");
                                    try {
                                        day = Integer.parseInt(scanner.nextLine());
                                        if (day < 1 || day > 31) {
                                            throw new Exception("invalid day");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input!");
                                    }
                                }

                                hireDate = LocalDate.of(year, month, day);
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid Date");
                            }
                        }

                        System.out.print("Employee job title: ");
                        jobTitle = scanner.nextLine();

                        System.out.print("Employee status (1.Active/2.Terminated): ");
                        int num;
                        while (true) {
                            try {
                                num = Integer.parseInt(scanner.nextLine());
                                if (num < 1 || num > 2) {
                                    throw new Exception("invalid input");
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input!");
                            }
                        }
                        if (num == 1) {
                            status = "Active";
                        } else {
                            status = "Terminated";
                        }

                        System.out.print("Employee business unit: ");
                        businessUnit = scanner.nextLine();

                        recordDate = LocalDate.now();
                        employeeDatabase.addEmployee(empID, name, dateOfBirth, recordDate, hireDate, jobTitle,
                                gender, status, businessUnit);
                    } else if (option.equalsIgnoreCase("3")) {//user enter 3 for deleting employee
                        if (employeeDatabase.removeEmployee(id)) {
                            System.out.println("Deletion successful!");
                        } else {
                            System.out.println("Deletion failed!");
                        }
                    } else if (option.equalsIgnoreCase("4")) {//user enter 4 for updating employee
                        if (employee != null) {
                            System.out.println("Update Employee: ");
                            System.out.println("1. Update Employee Name");
                            System.out.println("2. Update Employee Date Of Birth");
                            System.out.println("3. Update Employee Hire Date");
                            System.out.println("4. Update Employee Record Date");
                            System.out.println("5. Update Employee Title");
                            System.out.println("6. Update Employee Gender");
                            System.out.println("7. Set Employee Status");
                            System.out.println("8. Update Business Unit");
                            System.out.println("9. Main Menu");
                            System.out.println("Select option (1-9): ");
                            do {
                                option = scanner.nextLine();
                            } while (!option.equalsIgnoreCase("1")  // rule out the possibility of user typing errors in the next few lines
                                    && !option.equalsIgnoreCase("2")
                                    && !option.equalsIgnoreCase("3")
                                    && !option.equalsIgnoreCase("4")
                                    && !option.equalsIgnoreCase("5")
                                    && !option.equalsIgnoreCase("6")
                                    && !option.equalsIgnoreCase("7")
                                    && !option.equalsIgnoreCase("8")
                                    && !option.equalsIgnoreCase("9"));
                            if (option.equalsIgnoreCase("1")) {
                                System.out.println("Employee name: ");
                                String name = scanner.nextLine();
                                employeeDatabase.updateName(id, name);
                            } else if (option.equalsIgnoreCase("2")) {//user enter 2 for updating selected employee's Date of Birth

                                while (true) {
                                    try {
                                        System.out.println("Employee date of birth");
                                        int year, month, day;
                                        while (true) {
                                            System.out.print("year: ");
                                            try {
                                                year = Integer.parseInt(scanner.nextLine());
                                                if (year < 1500 || year > 2020) {
                                                    throw new Exception("invalid year");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }

                                        while (true) {
                                            System.out.print("month: ");
                                            try {
                                                month = Integer.parseInt(scanner.nextLine());
                                                if (month < 1 || month > 12) {
                                                    throw new Exception("invalid month");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }

                                        while (true) {
                                            System.out.print("day: ");
                                            try {
                                                day = Integer.parseInt(scanner.nextLine());
                                                if (day < 1 || day > 31) {
                                                    throw new Exception("invalid day");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }
                                        employeeDatabase.updateDateOfBirth(id, LocalDate.of(year, month, day));
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Output");
                                    }
                                }
                            } else if (option.equalsIgnoreCase("3")) {// user enter 3 for updating selected employee's hire date

                                while (true) {
                                    try {
                                        System.out.println("Employee hire date: ");
                                        int year, month, day;
                                        while (true) {
                                            System.out.print("year: ");
                                            try {
                                                year = Integer.parseInt(scanner.nextLine());
                                                if (year < 1500 || year > 2020) {
                                                    throw new Exception("invalid year");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }

                                        while (true) {
                                            System.out.print("month: ");
                                            try {
                                                month = Integer.parseInt(scanner.nextLine());
                                                if (month < 1 || month > 12) {
                                                    throw new Exception("invalid month");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }

                                        while (true) {
                                            System.out.print("day: ");
                                            try {
                                                day = Integer.parseInt(scanner.nextLine());
                                                if (day < 1 || day > 31) {
                                                    throw new Exception("invalid day");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }
                                        employeeDatabase.updateHireDate(id, LocalDate.of(year, month, day));
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Output");
                                    }
                                }
                            } else if (option.equalsIgnoreCase("4")) {//user enter 4 for updating selected employee's record date

                                while (true) {
                                    try {
                                        System.out.print("Employee record date: ");
                                        int year, month, day;
                                        while (true) {
                                            System.out.print("year: ");
                                            try {
                                                year = Integer.parseInt(scanner.nextLine());
                                                if (year < 1500 || year > 2020) {
                                                    throw new Exception("invalid year");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }

                                        while (true) {
                                            System.out.print("month: ");
                                            try {
                                                month = Integer.parseInt(scanner.nextLine());
                                                if (month < 1 || month > 12) {
                                                    throw new Exception("invalid month");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }

                                        while (true) {
                                            System.out.print("day: ");
                                            try {
                                                day = Integer.parseInt(scanner.nextLine());
                                                if (day < 1 || day > 31) {
                                                    throw new Exception("invalid day");
                                                }
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("Invalid input!");
                                            }
                                        }
                                        employeeDatabase.updateRecordDate(id, LocalDate.of(year, month, day));
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Output");
                                    }
                                }
                            } else if (option.equalsIgnoreCase("5")) {//user enter 5 for updating selected employee's title
                                System.out.print("title: ");
                                String title = scanner.nextLine();
                                employeeDatabase.updateTitle(id, title);
                            } else if (option.equalsIgnoreCase("6")) {//user enter 6 for updating selected employee's gender
                                String gender;
                                while (true) {
                                    System.out.print("Employee gender (1.male/2.female): ");
                                    try {
                                        int num = Integer.parseInt(scanner.nextLine());

                                        if (num == 1) {
                                            gender = "Male";
                                        } else if (num == 2) {
                                            gender = "Female";
                                        } else {
                                            System.out.println("Invalid output");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input!");
                                    }
                                }
                                employeeDatabase.updateGender(id, gender);
                            } else if (option.equalsIgnoreCase("7")) {//user enter 7 for setting selected employee's status
                                System.out.print("Employee status (1.Active/2.Terminated): ");
                                String status;
                                int num;
                                while (true) {
                                    try {
                                        num = Integer.parseInt(scanner.nextLine());
                                        if (num < 1 || num > 2) {
                                            throw new Exception("invalid input");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input!");
                                    }
                                }
                                if (num == 1) {
                                    status = "Active";
                                } else {
                                    status = "Terminated";
                                }
                                employeeDatabase.setStatus(id, status);
                            } else if (option.equalsIgnoreCase("8")) {//user enter 8 for update selected employee's business unit
                                System.out.print("Business unit: ");
                                String bu = scanner.nextLine();
                                employeeDatabase.updateBusinessUnit(id, bu);
                            }
                        } else {
                            System.out.println("No Match Found");
                        }
                    } else {
                        break;
                    }
                }
            } else {
                while (true) {
                    // Here is the user interface of the program for ordinary user
                    System.out.println("\n-------------Employee Information Management Software-------------");
                    System.out.println("1. get Employee");
                    System.out.println("2. logout");
                    System.out.print("Please select（1-2）\n");
                    String option = scanner.nextLine();
                    int empID;
                    if (option.equalsIgnoreCase("2")) {
                        break;
                    }
                    while (true) {
                        System.out.println("Employee id: ");
                        try {
                            empID = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                        }
                    }
                    Employee employee = employeeDatabase.getEmployee(empID);
                    System.out.println("Name: " + employee.getName());
                    System.out.println("Date of Birth: " + employee.getDateOfBirth());
                    System.out.println("Gender: " + employee.getGender());
                    System.out.println("Job Title: " + employee.getJobTitle());
                    System.out.println("Status: " + employee.getStatus());
                    System.out.println("Business Unit: " + employee.getBusinessUnit());
                }
            }
            System.out.println("You have logged out!");
        }
        System.out.println("Program ended!");
    }

    /**
     * @Description: This function is used to implement the basic registration and login functions
     * @Param: [logInAndRegister, input]
     * @return: java.lang.String
     * @Author: Weijie Zhou
     * @Date: 2020/9/27
     */
    public static String logInAndRegister(LogInAndRegister logInAndRegister, String input) {
        String username = "";
        String password = "";
        Scanner scanner = new Scanner(System.in);
        if (input.equals("1")) {
            System.out.println("Please register");
            System.out.print("username: ");
            username = scanner.nextLine();
            while (logInAndRegister.isUserExist(username)) {
                System.out.println("Username exists! Try another one.");
                System.out.print("username: ");
                username = scanner.nextLine();
            }
            System.out.print("password: ");
            password = scanner.nextLine();
            System.out.print("Are you administrator (y/n): ");
            input = scanner.nextLine();
            while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
                System.out.println("Invalid input");
                System.out.print("Are you administrator (y/n): ");
                input = scanner.nextLine();
            }
            logInAndRegister.addUser(username, password, input.equalsIgnoreCase("y"));
        } else {
            System.out.println("Please log in");
            System.out.print("username: ");
            username = scanner.nextLine();
            System.out.print("password: ");
            password = scanner.nextLine();
            if (!logInAndRegister.logIn(username, password)) {
                return null;
            }
        }

        return username;
    }
}
