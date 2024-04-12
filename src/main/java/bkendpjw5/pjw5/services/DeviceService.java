package bkendpjw5.pjw5.services;

import bkendpjw5.pjw5.dao.DeviceDAO;
import bkendpjw5.pjw5.entities.Device;
import bkendpjw5.pjw5.exceptions.NotFoundException;
import bkendpjw5.pjw5.payloads.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private DeviceDAO dDAO;

    @Autowired
    private EmployeeService es;


    public Page<Device> getDevices(int page, int size, String sortBy) {
        if (size > 50) size = 50;
        Pageable p = PageRequest.of(page, size, Sort.by(sortBy));
        return dDAO.findAll(p);
    }

    public Device save(DeviceDTO newDevice) {
        return dDAO.save(new Device(
                newDevice.type(),
                newDevice.status(),
                es.findById(newDevice.employee())));
    }

    public Device findById(long id) {
        return this.dDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) {
        Device found = this.findById(id);
        this.dDAO.delete(found);
    }

    public Device findByIdAndUpdate(long id, DeviceDTO newDevice) {
        Device found = this.findById(id);
        found.setType(newDevice.type());
        found.setStatus(newDevice.status());
        found.setEmployee(es.findById(newDevice.employee()));
        dDAO.save(found);
        return found;

    }
}
