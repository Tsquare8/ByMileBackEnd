package lm.com.ByMile;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepository extends JpaRepository<Driver, Integer> {  
	@Query ("SELECT u FROM Driver u where (:name is null OR UPPER(name) LIKE UPPER(CONCAT('%',:name,'%')))")
	public List<Driver> findAllByNameLike(@Param("name") String name);
}
