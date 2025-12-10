package com.tcs.boot.entity;

public class Loan {

long loadId;
String borrowerName;
String dateBorrowed;
int tenure;
int balanceEMI;
boolean loanStatus;
double amount;
public long getLoadId() {
	return loadId;
}
public void setLoadId(long loadId) {
	this.loadId = loadId;
}

public int getTenure() {
	return tenure;
}
public void setTenure(int tenure) {
	this.tenure = tenure;
}
public int getBalanceEMI() {
	return balanceEMI;
}
public void setBalanceEMI(int balanceEMI) {
	this.balanceEMI = balanceEMI;
}
public boolean isLoanStatus() {
	return loanStatus;
}
public void setLoanStatus(boolean loanStatus) {
	this.loanStatus = loanStatus;
}
public String getBorrowerName() {
	return borrowerName;
}
public void setBorrowerName(String borrowerName) {
	this.borrowerName = borrowerName;
}
public String getDateBorrowed() {
	return dateBorrowed;
}
public void setDateBorrowed(String dateBorrowed) {
	this.dateBorrowed = dateBorrowed;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

@Override
public String toString() {
	return "Loan [loadId=" + loadId + ", borrowerName=" + borrowerName + ", dateBorrowed=" + dateBorrowed + ", tenure="
			+ tenure + ", balanceEMI=" + balanceEMI + ", loanStatus=" + loanStatus + ", amount=" + amount + "]";
}

}
