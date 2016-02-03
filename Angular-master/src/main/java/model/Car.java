package model;

public class Car {
	
	String plateNumber;
	String plateType;
	long plateSeat;
	
	boolean rented;

	public String getPlateNumber() {
		return plateNumber;
	}
	public String getPlateType() {
		return plateType;
	}
	public long getPlateSeat() {
		return plateSeat;
	}
	
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;

	}
	public void setPlateType(String plateType) {
		this.plateType = plateType;

	}
	public void setPlateSeat(long plateSeat) {
		this.plateSeat=plateSeat;
	}
	
	
	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

}
