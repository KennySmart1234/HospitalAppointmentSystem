package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.data.repositories.DepartmentRepository;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void getAllDepartments_returnsAllDepartments_test() {

        Department department1 = new Department();
        department1.setName("Cardiology");

        Department department2 = new Department();
        department2.setName("Dentistry");

        List<Department> departments = List.of(department1, department2);

        when(departmentRepository.findAll()).thenReturn(departments);

        List<Department> result = departmentService.getAllDepartments();

        assertEquals(2, result.size());
        assertEquals("Cardiology", result.get(0).getName());
        assertEquals("Dentistry", result.get(1).getName());

        verify(departmentRepository).findAll();
    }

    @Test
    public void getAllDepartments_returnsAllDepartments_andCountIs_4_test(){
        Department department1= new Department();
        department1.setName("Cardiology");

        Department department2 = new Department();
        department2.setName("Dentistry");

        Department department3 = new Department();
        department3.setName("Neurology");

        Department department4 = new Department();
        department4.setName("Semicolon");

        List<Department> departments = List.of(department1, department2, department3, department4);
        when(departmentRepository.findAll()).thenReturn(departments);

        List<Department> result = departmentService.getAllDepartments();
        assertEquals(4, result.size());

        assertEquals("Cardiology", result.get(0).getName());
        assertEquals("Dentistry", result.get(1).getName());
        assertEquals("Neurology", result.get(2).getName());
        assertEquals("Semicolon", result.get(3).getName());

        verify(departmentRepository).findAll();

    }


    @Test
    public void getDepartmentByName_withExistingDepartment_returnsDepartment_test() throws HospitalAppException {

        Department department = new Department();
        department.setName("Cardiology");

        when(departmentRepository.findByName("Cardiology")).thenReturn(Optional.of(department));

        Department result = departmentService.getDepartmentByName("Cardiology");

        assertEquals("Cardiology", result.getName());

        verify(departmentRepository).findByName("Cardiology");
    }



    @Test
    public void getDepartmentByName_withUnknownDepartment_throwsException_test() throws HospitalAppException {

        when(departmentRepository.findByName("Unknown")).thenReturn(Optional.empty());

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> departmentService.getDepartmentByName("Unknown"));

        assertEquals("Department not found", exception.getMessage());

        verify(departmentRepository).findByName("Unknown");
    }



    @Test
    public void getDepartmentById_withExistingDepartment_returnsDepartment_test() throws HospitalAppException {

        Department department = new Department();
        department.setName("Cardiology");

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));

        Department result = departmentService.getDepartmentById(1L);

        assertEquals("Cardiology", result.getName());

        verify(departmentRepository).findById(1L);
    }



    @Test
    public void getDepartmentById_withUnknownId_throwsException_test() throws HospitalAppException {

        when(departmentRepository.findById(99L)).thenReturn(Optional.empty());

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> departmentService.getDepartmentById(99L));

        assertEquals("Department not found", exception.getMessage());

        verify(departmentRepository).findById(99L);
    }





}