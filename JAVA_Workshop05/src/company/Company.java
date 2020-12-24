package company;

public class Company {
	private double salary;
	private double annualIncome;
	private double afterTaxIncome;
	private double bonus;
	private double afterTaxBonus;
	
	public Company() {
		
	}
	
	public Company(double salary) {
		this.salary = salary;
	}
	
	public double getIncome() {
		annualIncome = salary * 12;
		return annualIncome;
	}
	
	public double getAfterTaxIncome() {
		afterTaxIncome = getIncome() - (salary*0.1*12);
		return afterTaxIncome;
	}

	public double getBonus() {
		bonus = salary * 0.2;
		return bonus * 4;
	}
	
	public double getAfterTaxBonus() {
		afterTaxBonus = getBonus() - (bonus*0.055*4);
		return afterTaxBonus;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public void setAfterTaxBonus(double afterTaxBonus) {
		this.afterTaxBonus = afterTaxBonus;
	}
	
	
	
	
}
