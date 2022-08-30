package de.gloresoft.workorderapi.controllers;

import de.gloresoft.workorderapi.entities.WorkOrder;
import de.gloresoft.workorderapi.services.WorkOrderService;
import org.springframework.web.bind.annotation.GetMapping;
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
}
