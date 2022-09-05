package de.gloresoft.workorderapi.services;

import de.gloresoft.workorderapi.entities.WorkOrder;

public interface WorkOrderService {

    Iterable<WorkOrder> findAllOrders();

    WorkOrder findById(Long id);

    void removeById(Long id);

    void addWorkOrder(WorkOrder workOrder);

    void updateWorkOrder(WorkOrder workOrder, Long id);

}
