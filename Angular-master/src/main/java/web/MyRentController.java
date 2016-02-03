package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Car;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dto.CarDTO;

@Controller
public class MyRentController implements RentService{

	List<Car> cars = new ArrayList<Car>();	
	
	public MyRentController(){
		Car car = new Car();
		car.setPlateNumber("11AA22");
		car.setPlateType("Citroen");
		car.setPlateSeat(2);
		car.setRented(false);	
		cars.add(car);
		
		car = new Car();
		car.setPlateNumber("22BB33");
		car.setPlateType("Mercedes-Benz");
		car.setPlateSeat(4);
		car.setRented(false);
		cars.add(car);
		
		car = new Car();
		car.setPlateNumber("33CC44");
		car.setPlateType("Bayerische Motoren Werke AG");
		car.setPlateSeat(4);
		car.setRented(false);
		cars.add(car);
		
		car = new Car();
		car.setPlateNumber("44DD55");
		car.setPlateType("Citroen");
		car.setPlateSeat(6);
		car.setRented(false);
		cars.add(car);
		
		car = new Car();
		car.setPlateNumber("55EE66");
		car.setPlateType("BUICK");
		car.setPlateSeat(4);
		car.setRented(false);		
		cars.add(car);
	}
	
	@RequestMapping(value = "/entryPoint", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Override
	public ResourceSupport get() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	*
	* @return all cars not rented
	*/
	@RequestMapping(value = "/car", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Override
	public List<CarDTO> getCars() {
		List<CarDTO> dtos = new ArrayList<CarDTO>();
		Car car;
		for(int i=0; i<cars.size(); i++){	
			car = cars.get(i);				
			if(car.isRented() == false){	
				CarDTO dto = new CarDTO(car);	
				dtos.add(dto);				
			}
		}
		return dtos;
	}

	/**
	* Return specifications of a car.
	* @param plateNumber
	* @return car specifications only (if not rented)
	* @throws Exception no car with this plate number or already rented
	*/
	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Override
	public CarDTO getCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
		return null;
	}

	/**
	* Rent a car.
	* @param plateNumber
	* @return car specifications
	* @throws Exception no car with this plate number or already rented
	*/
	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@Override
	public void rentCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
		List<CarDTO> dtos = new ArrayList<CarDTO>();
		Car car;
		for(int i=0; i<cars.size(); i++){	
			car = cars.get(i);				
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRented(true);
			}
		}
	}

	/**
	*
	** @return actions to be done
	* @throws Exception no car with this plate number or not rented
	*/
	@RequestMapping(value = "/car/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@Override
	public void renderCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
		List<CarDTO> dtos = new ArrayList<CarDTO>();
		Car car;
		for(int i=0; i<cars.size(); i++){	
			car = cars.get(i);				
			if(car.getPlateNumber().equals(plateNumber)){
				car.setRented(false);
			}
		}
	}

	@Override
	public List<CarDTO> getRentedCars() {
		List<CarDTO> dtos = new ArrayList<CarDTO>();
		Car car;
		for(int i=0; i<cars.size(); i++){	
			car = cars.get(i);				
			if(car.isRented() == true){	
				CarDTO dto = new CarDTO(car);	
				dtos.add(dto);				
			}
		}
		return dtos;
	
	}

	@Override
	public List<CarDTO> getNotRentedCars() {
		List<CarDTO> dtos = new ArrayList<CarDTO>();
		Car car;
		for(int i=0; i<cars.size(); i++){	
			car = cars.get(i);				
			if(car.isRented() == false){	
				CarDTO dto = new CarDTO(car);	
				dtos.add(dto);				
			}
		}
		return dtos;
	}

}
