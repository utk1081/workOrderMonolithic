package de.gloresoft.workorderapi.controllers;

import de.gloresoft.workorderapi.entities.WorkOrder;
import de.gloresoft.workorderapi.exceptions.ResourceNotFoundException;
import de.gloresoft.workorderapi.services.WorkOrderService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @GetMapping(path = "/workOrders", produces = "application/json")
    public Iterable<WorkOrder> getAllWorkOrders() {
        return this.workOrderService.findAllOrders();
    }

    @GetMapping("/workOrders/{id}")
    public WorkOrder getWorkOrder(@PathVariable String id) throws NumberFormatException {
        Long longId;
        try {
            longId = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(nfe.getMessage());
        }
        return this.workOrderService.findById(longId);
    }

    @PostMapping("/workOrders")
    public void addWorkOrder(@RequestBody WorkOrder workOrder) {
        this.workOrderService.addWorkOrder(workOrder);
    }

    @DeleteMapping("/workOrders/{id}")
    public void deleteWorkOrder(@PathVariable String id) throws ResourceNotFoundException {
        Long longId;
        try {
            longId = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(nfe.getMessage());
        }
        this.workOrderService.removeById(longId);
    }

    @PutMapping("/workOrders/{id}")
    public void updateWorkOrder(@RequestBody WorkOrder workOrder, @PathVariable String id) throws ResourceNotFoundException {
        Long longId;
        try {
            longId = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(nfe.getMessage());
        }
        this.workOrderService.updateWorkOrder(workOrder, longId);
    }
}
