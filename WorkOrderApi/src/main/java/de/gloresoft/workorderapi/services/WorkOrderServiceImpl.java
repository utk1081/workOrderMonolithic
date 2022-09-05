package de.gloresoft.workorderapi.services;

import de.gloresoft.workorderapi.entities.WorkOrder;
import de.gloresoft.workorderapi.exceptions.ResourceAlreadyExistsException;
import de.gloresoft.workorderapi.exceptions.ResourceNotFoundException;
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

    @Override
    public WorkOrder findById(Long id) {
        return this.workOrderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("This id:"+id+" does not exist."));
    }

    @Override
    public void removeById(Long id) {
        if(!this.workOrderRepository.existsById(id)) {
            throw new ResourceNotFoundException("This id:"+id+" does not exist.");
        }
        this.workOrderRepository.deleteById(id);
    }

    @Override
    public void addWorkOrder(WorkOrder workOrder) {
        if(this.workOrderRepository.existsById(workOrder.getId())) {
            throw new ResourceAlreadyExistsException("This id:"+workOrder.getId()+" already exists.");
        }
        this.workOrderRepository.save(workOrder);
    }

    @Override
    public void updateWorkOrder(WorkOrder workOrder, Long id) {
        if(!this.workOrderRepository.existsById(id)) {
            throw new ResourceNotFoundException("This id:"+id+" does not exist.");
        }
        workOrder.setId(id);
        this.workOrderRepository.save(workOrder);
    }

}
