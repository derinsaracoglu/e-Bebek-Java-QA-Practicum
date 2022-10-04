package MaasHesaplama;

public class Employee {
	String name; // �al��an�n ad� soyad�
	double salary; //�al��an�n maa��
	int workHours; //Haftal�k �al��ma saati
	int hireYear;  //��e Ba�lang�� Y�l�

	public Employee(String name, double salary, int workHours, int hireYear) {

		this.name = name;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
	}

	public double tax() {
		if (salary < 1000) {  //�al��an�n maa�� 1000 TL'den az ise vergi uygulanmayacakt�r.
			return salary;
		} else {
			double tax = salary * 0.03; //�al��an�n maa�� 1000 TL'den fazla ise maa��n�n %3'� kadar vergi uygulanacakt�r.
			return tax;
		}
	}
	
	public int bonus() {
		if(workHours > 40) {
			int bonus = (workHours - 40) * 30; //40 saatten fazla �al��m�� ise fazladan �al��t��� her saat ba��na 30 TL olacak �ekilde bonus 
			return bonus;
		}
		return 0;
	}
	
	public double raiseSalary() {
		if(hireYear <= 0 || hireYear >= 2021) {
			System.out.println("Ge�ersiz y�l.L�tfen tekrar deneyiniz.");
		}
		else {
			int farkYil = 2021 - hireYear;
			double zam;
			
			if(farkYil > 0 && farkYil < 10) {
				zam = salary * 0.05;
				return zam;
			}
			
			else if(farkYil > 9 && farkYil < 20) {
				zam = salary * 0.10;
				return zam;
			}
			
			else if(farkYil > 19) {
				zam = salary * 0.15;
				return zam;
			}
			
			else if(farkYil == 0) {
				return 0;
			}
			
		}
		
		return 0;
	}
	
	public String toString() {

		double total = salary - tax() + bonus() + raiseSalary();
		double tot = salary + bonus() - tax();
		System.out.println("Ad� : " + name);
		System.out.println("Maa�� : " + salary);
		System.out.println("�al��ma Saati : " + workHours);
		System.out.println("Ba�lang�� Y�l� : " + hireYear);
		System.out.println("Vergi : " + tax());
		System.out.println("Bonus : " + bonus());
		System.out.println("Maa� art��� : " + raiseSalary());
		System.out.println("Vergi ve Bonuslar ile birlikte maa� : " + tot);
		System.out.println("Toplam Maa� : " + total);

		return null;
	}
}

