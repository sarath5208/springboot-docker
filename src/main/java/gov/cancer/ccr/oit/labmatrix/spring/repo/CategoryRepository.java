package gov.cancer.ccr.oit.labmatrix.spring.repo;

import gov.cancer.ccr.oit.labmatrix.spring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>
{

}
