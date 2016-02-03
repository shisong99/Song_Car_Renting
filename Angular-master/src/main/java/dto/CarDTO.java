package dto;

import model.Car;

public class CarDTO {
	
	String plateNumber;
    String plateType;
    long plateSeat;
    
	public CarDTO(Car car) {
		plateNumber = car.getPlateNumber();
		plateType=car.getPlateType();
		plateSeat=car.getPlateSeat();
	}

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
}
