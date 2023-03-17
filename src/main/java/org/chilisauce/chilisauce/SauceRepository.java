package org.chilisauce.chilisauce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer>, JpaSpecificationExecutor<Sauce> {

    List<Sauce> getSauceByScoville(String scoville);

    List<Sauce> getSauceByScovilleAndOrigin(String scoville, String origin);

    List<Sauce> getSauceByScovilleAndName(String scoville, String name);

    List<Sauce> getSauceByScovilleAndOriginAndName(String scoville, String origin, String name);

    List<Sauce> getSauceByOrigin(String origin);

    List<Sauce> getSauceByOriginAndName(String origin, String name);

    List<Sauce> getSauceByName(String name);

    @Query("SELECT s FROM Sauce s WHERE (:scoville IS NULL OR s.scoville = :scoville) AND (:origin IS NULL OR s.origin = :origin) AND (:name IS NULL OR s.name = :name)")
    List<Sauce> getFilteredList(String scoville, String origin, String name);

    //List<Sauce> findByParameters(String scoville, String origin, String name);



}
