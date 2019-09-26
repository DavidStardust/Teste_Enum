package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.print("Enter worker data:");
		System.out.println("Name:");
		String workerName = sc.nextLine();
		System.out.println("Level:");
		String workerLevel = sc.nextLine();
		System.out.println("Base Salary:");
		double baseSalary = sc.nextDouble();
		
		//Instanciar um funcion�rio
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		//Ler a quantidade de contratos
		System.out.println("How many contracts to this worker?: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration(hours): ");
			int hours = sc.nextInt();
			//Instanciar o contrato
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			//associa��o do contrato com o trabalhador
			worker.addContratct(contract);
		}
			System.out.println(worker); 
		sc.close();

	}

}
