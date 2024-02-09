package prototype.copart.contractservices.contract.templates.pricing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingTemplateRepository extends JpaRepository<PricingTemplate, Long>
{ }
