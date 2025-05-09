package DAOTEORIA;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, HIRE_DATE, JOB_TITLE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employee.getEmployeeId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getLastName());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPhone());
            stmt.setDate(6, new java.sql.Date(employee.getHireDate().getTime())); // Convertir a java.sql.Date
            stmt.setString(7, employee.getJobTitle());
            stmt.executeUpdate();
            System.out.println("Empleado agregado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),rs.getString("LAST_NAME") , rs.getString("EMAIL"), rs.getString("PHONE"),rs.getDate("HIRE_DATE"), rs.getString("JOB_TITLE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),rs.getString("LAST_NAME") , rs.getString("EMAIL"), rs.getString("PHONE"),rs.getDate("HIRE_DATE"), rs.getString("JOB_TITLE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE = ?, HIRE_DATE = ?, JOB_TITLE = ? WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setDate(5, employee.getHireDate());
            stmt.setString(6, employee.getJobTitle());
            stmt.setInt(7, employee.getEmployeeId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getEmployeesWithOrders() {
        List<Employee> employeesWithOrders = new ArrayList<>();
        String sql = "SELECT DISTINCT e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME " +
                     "FROM EMPLOYEES e " +
                     "JOIN ORDERS o ON e.EMPLOYEE_ID = o.SALESMAN_ID";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                employeesWithOrders.add(new Employee(
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        null, 
                        null, 
                        null, 
                        null  
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesWithOrders;
    }

    @Override
    public List<Employee> getOrdersByEmployeeId(int employeeId) {
        List<Employee> orders = new ArrayList<>();
        String sql = "SELECT o.ORDER_ID, o.STATUS, o.ORDER_DATE " +
                     "FROM ORDERS o " +
                     "WHERE o.SALESMAN_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("ORDER_ID") +
                                   ", Status: " + rs.getString("STATUS") +
                                   ", Order Date: " + rs.getDate("ORDER_DATE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
//
//    public List<Employee> getEmployeesWithSalaryGreaterThan3000() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT * FROM EMPLOYEES WHERE SALARY > 3000";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"),
//                                           rs.getString("FIRST_NAME"),
//                                           rs.getString("LAST_NAME"),
//                                           rs.getString("EMAIL"),
//                                           rs.getString("PHONE"),
//                                           rs.getDate("HIRE_DATE"),
//                                           rs.getString("JOB_TITLE")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }
    
//    public List<Employee> getEmployeesOrderedByLastName() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT * FROM EMPLOYEES ORDER BY LAST_NAME ASC";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"),
//                                           rs.getString("FIRST_NAME"),
//                                           rs.getString("LAST_NAME"),
//                                           rs.getString("EMAIL"),
//                                           rs.getString("PHONE"),
//                                           rs.getDate("HIRE_DATE"),
//                                           rs.getString("JOB_TITLE")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//        
//    }
    
//    public int getEmployeeCount() {
//        String sql = "SELECT COUNT(*) FROM EMPLOYEES";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                return rs.getInt(1);
//            }
//            public List<Employee> getEmployeesWithLastNameStartingWithA() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE 'A%'";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"),
//                                           rs.getString("FIRST_NAME"),
//                                           rs.getString("LAST_NAME"),
//                                           rs.getString("EMAIL"),
//                                           rs.getString("PHONE"),
//                                           rs.getDate("HIRE_DATE"),
//                                           rs.getString("JOB_TITLE")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//    public double getAverageSalary() {
//        String sql = "SELECT AVG(SALARY) FROM EMPLOYEES";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                return rs.getDouble(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0.0;
//    }
//    public List<Employee> getEmployeesHiredIn2020() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT * FROM EMPLOYEES WHERE YEAR(HIRE_DATE) = 2020";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"),
//                                           rs.getString("FIRST_NAME"),
//                                           rs.getString("LAST_NAME"),
//                                           rs.getString("EMAIL"),
//                                           rs.getString("PHONE"),
//                                           rs.getDate("HIRE_DATE"),
//                                           rs.getString("JOB_TITLE")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }
//    public List<String> getJobTitleCounts() {
//        List<String> jobTitles = new ArrayList<>();
//        String sql = "SELECT JOB_TITLE, COUNT(*) FROM EMPLOYEES GROUP BY JOB_TITLE";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                jobTitles.add(rs.getString("JOB_TITLE") + ": " + rs.getInt(2));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return jobTitles;
//    }
//    public List<Employee> getEmployeesWithSalaryBetween2000And5000() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT * FROM EMPLOYEES WHERE SALARY BETWEEN 2000 AND 5000";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"),
//                                           rs.getString("FIRST_NAME"),
//                                           rs.getString("LAST_NAME"),
//                                           rs.getString("EMAIL"),
//                                           rs.getString("PHONE"),
//                                           rs.getDate("HIRE_DATE"),
//                                           rs.getString("JOB_TITLE")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }
//    public List<Employee> getTop5HighestSalaryEmployees() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT * FROM EMPLOYEES ORDER BY SALARY DESC LIMIT 5";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"),
//                                           rs.getString("FIRST_NAME"),
//                                           rs.getString("LAST_NAME"),
//                                           rs.getString("EMAIL"),
//                                           rs.getString("PHONE"),
//                                           rs.getDate("HIRE_DATE"),
//                                           rs.getString("JOB_TITLE")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }
//    public void deleteEmployeeById(int employeeId) {
//        String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, employeeId);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void updateEmployeeSalary(int employeeId, double newSalary) {
//        String sql = "UPDATE EMPLOYEES SET SALARY = ? WHERE EMPLOYEE_ID = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setDouble(1, newSalary);
//            stmt.setInt(2, employeeId);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public List<Employee> getEmployeesWithNoPhone() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT * FROM EMPLOYEES WHERE PHONE IS NULL";
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                employees.add(new Employee(rs.getInt("EMPLOYEE_ID"),
//                                           rs.getString("FIRST_NAME"),
//                                           rs.getString("LAST_NAME"),
//                                           rs.getString("EMAIL"),
//                                           rs.getString("PHONE"),
//                                           rs.getDate("HIRE_DATE"),
//                                           rs.getString("JOB_TITLE")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }










}


