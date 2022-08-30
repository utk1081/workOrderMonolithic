package de.gloresoft.workorderapi.services;

import de.gloresoft.workorderapi.entities.WorkOrder;

public interface WorkOrderService {

    Iterable<WorkOrder> findAllOrders();

}
