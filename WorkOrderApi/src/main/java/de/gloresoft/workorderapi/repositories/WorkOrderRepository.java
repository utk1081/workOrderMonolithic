package de.gloresoft.workorderapi.repositories;

import de.gloresoft.workorderapi.entities.WorkOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepository extends CrudRepository<WorkOrder, Long> {
}
