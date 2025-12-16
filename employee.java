
	

	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.*;

	public class employee {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        ArrayList<HashMap<String, Object>> employeeList = new ArrayList<>();
	        HashSet<Integer> employeeIds = new HashSet<>();

	        System.out.println("Employee Bonus Engine");

	        System.out.print("Enter number of employees: ");
	        int n = sc.nextInt();

	        for (int i = 0; i < n; i++) {

	            System.out.println("\nEnter details for Employee " + (i + 1));

	            System.out.print("Employee ID: ");
	            int id = sc.nextInt();

	            if (employeeIds.contains(id)) {
	                System.out.println("Duplicate Employee ID! Skipping entry.");
	                i--;
	                continue;
	            }
	            employeeIds.add(id);

	            sc.nextLine();
	            System.out.print("Employee Name: ");
	            String name = sc.nextLine();

	            System.out.print("Salary: ");
	            double salary = sc.nextDouble();

	            System.out.print("Performance (%): ");
	            int performance = sc.nextInt();

	            double bonus = (salary * performance) / 100;
	            double totalSalary = salary + bonus;

	            HashMap<String, Object> emp = new HashMap<>();
	            emp.put("id", id);
	            emp.put("name", name);
	            emp.put("salary", salary);
	            emp.put("performance", performance);
	            emp.put("bonus", bonus);
	            emp.put("totalSalary", totalSalary);

	            employeeList.add(emp);
	        }

	        String outputFile = "output.csv";

	        try {
	            FileWriter fw = new FileWriter(outputFile);

	            fw.write("id,name,salary,performance,bonus,totalSalary\n");

	            for (HashMap<String, Object> emp : employeeList) {
	                fw.write(emp.get("id") + "," +
	                         emp.get("name") + "," +
	                         emp.get("salary") + "," +
	                         emp.get("performance") + "," +
	                         emp.get("bonus") + "," +
	                         emp.get("totalSalary") + "\n");
	            }

	            fw.close();
	            System.out.println("\nData successfully saved to output.csv");

	        } catch (IOException e) {
	            System.out.println("File handling error");
	        }

	        sc.close();
	    }
	}


