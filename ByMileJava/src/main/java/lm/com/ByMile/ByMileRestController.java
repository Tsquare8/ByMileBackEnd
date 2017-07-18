package lm.com.ByMile;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
public class ByMileRestController {
	@Autowired
	private DriverRepository driverRepository;

	@RequestMapping(path = "/addDriver", method = RequestMethod.POST)
	public Driver newDriver(@RequestBody Driver driver) {
		driverRepository.save(driver);
		return driver;
	}

	@RequestMapping(path = "/findDriverInfo/{driverId}", method = RequestMethod.GET)
	public Driver findDriverInfo(@PathVariable(name = "driverId", required = true) Integer driverId) {

		Driver u = driverRepository.findOne(driverId);

		return u;
	}

	
	@RequestMapping(path = "/updateDriver", method = RequestMethod.POST)
	public ResponseEntity<?> updateDriver(@RequestBody Driver driver) {

		if (driver == null) {
			return new ResponseEntity<>(driver, HttpStatus.BAD_REQUEST);
		}
		if (driver.getDriverId() == 0) {
			return new ResponseEntity<>(driver, HttpStatus.BAD_REQUEST);
		}

		Driver existingUpdate = driverRepository.findOne(driver.getDriverId());
		driverRepository.save(existingUpdate);

		return new ResponseEntity<Driver>(existingUpdate, HttpStatus.OK);
	}

	@RequestMapping(path = "/deleteDriver", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDriver(@RequestBody Driver driver) {
		if (driver == null) {
			return new ResponseEntity<>(driver, HttpStatus.BAD_REQUEST);
		}

		if (driver.getDriverId() == 0) {
			return new ResponseEntity<>(driver, HttpStatus.BAD_REQUEST);
		}


		return new ResponseEntity<Driver>(HttpStatus.OK);
	}
}