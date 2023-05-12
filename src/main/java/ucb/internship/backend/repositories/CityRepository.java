package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.models.City;

public interface CityRepository extends JpaRepository<City, Integer>{
    
}
