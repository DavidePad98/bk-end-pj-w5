package bkendpjw5.pjw5.controllers;

import bkendpjw5.pjw5.entities.Device;
import bkendpjw5.pjw5.exceptions.BadRequestException;
import bkendpjw5.pjw5.payloads.DeviceDTO;
import bkendpjw5.pjw5.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService ds;

    @GetMapping
    private Page<Device> getAllDevices(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String sort) {
        return ds.getDevices(page, size, sort);
    }

    @GetMapping("/{id}")
    private Device getDeviceById(@PathVariable long id) {
        return ds.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Device saveNewDevice(@RequestBody @Validated DeviceDTO payload, BindingResult validation) {
        if (validation.hasErrors()) throw new BadRequestException(validation.getAllErrors());
        else return ds.save(payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDevice(@PathVariable long id) {
        ds.findByIdAndDelete(id);
    }

    @PutMapping("/{id}")
    private Device updateDevice(@PathVariable long id, @RequestBody @Validated DeviceDTO payload, BindingResult validation) {
        if (validation.hasErrors()) throw new BadRequestException(validation.getAllErrors());
        else return ds.findByIdAndUpdate(id, payload);
    }
}