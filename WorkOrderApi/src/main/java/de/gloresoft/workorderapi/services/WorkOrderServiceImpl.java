package de.gloresoft.workorderapi.services;

import de.gloresoft.workorderapi.entities.WorkOrder;
import de.gloresoft.workorderapi.repositories.WorkOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrderServiceImpl(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    @Override
    public Iterable<WorkOrder> findAllOrders() {
        return this.workOrderRepository.findAll();
    }

}
