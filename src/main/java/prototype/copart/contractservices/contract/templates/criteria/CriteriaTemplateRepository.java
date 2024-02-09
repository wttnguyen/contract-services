package prototype.copart.contractservices.contract.templates.criteria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaTemplateRepository extends JpaRepository<CriteriaTemplate, Long>
{ }
