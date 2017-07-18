package lm.com.ByMile;

import static javax.measure.unit.SI.KILOGRAM;
import java.util.Map;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class ByMileApplication {
//public class ByMileApplication  {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ByMileApplication.class, args);
	}
	
	@RequestMapping("/hello")
	  String hello(Map<String, Object> model) {
	      RelativisticModel.select();
	      Amount<Mass> m = Amount.valueOf("12 GeV").to(KILOGRAM);
	      model.put("science", "E=mc^2: 12 GeV = " + m.toString());
	      return "hello";
	  }

}
