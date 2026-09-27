package kz.bitlab.G114crm.repositories;

import kz.bitlab.G114crm.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRequestRepo extends JpaRepository<ApplicationRequest, Long> {

}
