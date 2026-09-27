package kz.bitlab.g128sprinttask61.repository;

import java.util.List;
import kz.bitlab.g128sprinttask61.entity.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {

  @Query("SELECT ar FROM ApplicationRequest ar "
      + "WHERE upper(ar.userName) like upper(concat('%', :text , '%')) "
      + "OR upper(ar.course.name) like upper(concat(:text, '%')) ")
  List<ApplicationRequest> search(String text);

  @Query(nativeQuery = true, value = "SELECT ar.*, c.name, c.price, c.description, c.id as c_id FROM application_requests ar "
      + "INNER JOIN courses c on c.id = ar.course_id "
      + "WHERE ar.user_name ilike ?1 OR c.name ilike ?1")
  List<ApplicationRequest> searchSql(String text);
}
