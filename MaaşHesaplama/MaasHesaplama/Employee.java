package MaasHesaplama;

public class Employee {
	String name; // Çalýþanýn adý soyadý
	double salary; //Çalýþanýn maaþý
	int workHours; //Haftalýk Çalýþma saati
	int hireYear;  //Ýþe Baþlangýç Yýlý

	public Employee(String name, double salary, int workHours, int hireYear) {

		this.name = name;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
	}

	public double tax() {
		if (salary < 1000) {  //Çalýþanýn maaþý 1000 TL'den az ise vergi uygulanmayacaktýr.
			return salary;
		} else {
			double tax = salary * 0.03; //Çalýþanýn maaþý 1000 TL'den fazla ise maaþýnýn %3'ü kadar vergi uygulanacaktýr.
			return tax;
		}
	}
	
	public int bonus() {
		if(workHours > 40) {
			int bonus = (workHours - 40) * 30; //40 saatten fazla çalýþmýþ ise fazladan çalýþtýðý her saat baþýna 30 TL olacak þekilde bonus 
			return bonus;
		}
		return 0;
	}
	
	public double raiseSalary() {
		if(hireYear <= 0 || hireYear >= 2021) {
			System.out.println("Geçersiz yýl.Lütfen tekrar deneyiniz.");
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
		System.out.println("Adý : " + name);
		System.out.println("Maaþý : " + salary);
		System.out.println("Çalýþma Saati : " + workHours);
		System.out.println("Baþlangýç Yýlý : " + hireYear);
		System.out.println("Vergi : " + tax());
		System.out.println("Bonus : " + bonus());
		System.out.println("Maaþ artýþý : " + raiseSalary());
		System.out.println("Vergi ve Bonuslar ile birlikte maaþ : " + tot);
		System.out.println("Toplam Maaþ : " + total);

		return null;
	}
}

