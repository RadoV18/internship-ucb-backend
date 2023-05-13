package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ucb.internship.backend.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityId(Integer cityId);
}
