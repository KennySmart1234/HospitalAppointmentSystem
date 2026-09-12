package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Admin;
import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.data.models.User;
import com.hospitalAppointmentSystem.data.models.UserRole;
import com.hospitalAppointmentSystem.data.repositories.AdminRepository;
import com.hospitalAppointmentSystem.data.repositories.DepartmentRepository;
import com.hospitalAppointmentSystem.data.repositories.UserRepository;
import com.hospitalAppointmentSystem.dtos.requests.AdminRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.requests.DepartmentRegisterRequest;
import com.hospitalAppointmentSystem.dtos.responses.AdminRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.DepartmentRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.UserResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AdminServiceImplTest {

    @Mock
    private AdminRepository adminRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private DepartmentRepository departmentRepository;
    @InjectMocks
    private AdminServiceImpl adminService;

    @Test
    public void registerAdmin_withValidDetails_registersSuccessfully_test() throws HospitalAppException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("admin@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Admin1234");
        request.setGender("Male");
        request.setAddress("Lagos");

        when(adminRepository.existsByEmail(request.getEmail())).thenReturn(false);

        Admin admin = new Admin();
        admin.setFullname("Kenny Smart");
        admin.setEmail("admin@gmail.com");
        admin.setLoggedIn(false);

        when(adminRepository.save(any(Admin.class))).thenReturn(admin);
        AdminRegistrationResponse response = adminService.registerAdmin(request);
        assertNotNull(response);

        verify(adminRepository).existsByEmail(request.getEmail());
        verify(adminRepository).save(any(Admin.class));
    }


    @Test
    public void registerAdmin_withExistingEmail_throwsException_test() throws HospitalAppException {

        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setFullname("Kenny Smart");
        request.setEmail("admin@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Admin1234");
        request.setGender("Male");
        request.setAddress("Lagos");

        when(adminRepository.existsByEmail(request.getEmail())).thenReturn(true);
        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.registerAdmin(request));
        assertEquals("Email already exist", exception.getMessage());

        verify(adminRepository).existsByEmail(request.getEmail());
        verify(adminRepository, never()).save(any(Admin.class));
    }



    @Test
    public void registerAdmin_withNullRequest_throwsException_test() throws HospitalAppException {

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.registerAdmin(null));

        assertEquals("Field cannot be empty", exception.getMessage());

        verify(adminRepository, never()).existsByEmail(anyString());
        verify(adminRepository, never()).save(any(Admin.class));
    }


    @Test
    public void registerAdmin_withEmptyFullname_throwsException_test() throws HospitalAppException {

        AdminRegistrationRequest request = new AdminRegistrationRequest();

        request.setFullname("");
        request.setEmail("admin@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Admin1234");
        request.setGender("Male");
        request.setAddress("Lagos");

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.registerAdmin(request));

        assertEquals("Invalid Fullname", exception.getMessage());

        verify(adminRepository, never()).existsByEmail(anyString());
        verify(adminRepository, never()).save(any(Admin.class));
    }


    @Test
    public void registerAdmin_withEmptyEmail_throwsException_test() throws HospitalAppException {

        AdminRegistrationRequest request = new AdminRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("");
        request.setPhone("123456789");
        request.setPassword("Admin1234");
        request.setGender("Male");
        request.setAddress("Lagos");

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.registerAdmin(request));

        assertEquals("Invalid email", exception.getMessage());

        verify(adminRepository, never()).existsByEmail(anyString());
        verify(adminRepository, never()).save(any(Admin.class));
    }


    @Test
    public void registerAdmin_withEmptyPhone_throwsException_test() throws HospitalAppException {

        AdminRegistrationRequest request = new AdminRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("admin@gmail.com");
        request.setPhone("");
        request.setPassword("Admin1234");
        request.setGender("Male");
        request.setAddress("Lagos");

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.registerAdmin(request));

        assertEquals("Invalid Phone", exception.getMessage());

        verify(adminRepository, never()).existsByEmail(anyString());
        verify(adminRepository, never()).save(any(Admin.class));
    }


    @Test
    public void registerAdmin_withEmptyPassword_throwsException_test() throws HospitalAppException {

        AdminRegistrationRequest request = new AdminRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("admin@gmail.com");
        request.setPhone("123456789");
        request.setPassword("");
        request.setGender("Male");
        request.setAddress("Lagos");

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.registerAdmin(request));

        assertEquals("Invalid password", exception.getMessage());

        verify(adminRepository, never()).existsByEmail(anyString());
        verify(adminRepository, never()).save(any(Admin.class));
    }


    @Test
    public void registerAdmin_withEmptyGender_throwsException_test() throws HospitalAppException {

        AdminRegistrationRequest request = new AdminRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("admin@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Admin1234");
        request.setGender("");
        request.setAddress("Lagos");

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.registerAdmin(request));

        assertEquals("Invalid Gender", exception.getMessage());

        verify(adminRepository, never()).existsByEmail(anyString());
        verify(adminRepository, never()).save(any(Admin.class));
    }


    @Test
    public void registerAdmin_withEmptyAddress_throwsException_test() throws HospitalAppException {

        AdminRegistrationRequest request = new AdminRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("admin@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Admin1234");
        request.setGender("Male");
        request.setAddress("");

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.registerAdmin(request));

        assertEquals("Invalid Address", exception.getMessage());

        verify(adminRepository, never()).existsByEmail(anyString());
        verify(adminRepository, never()).save(any(Admin.class));
    }


    @Test
    public void createDepartment_withValidDetails_createsSuccessfully_test() throws HospitalAppException {

        DepartmentRegisterRequest request = new DepartmentRegisterRequest();

        request.setName("Cardiology");
        when(departmentRepository.existsByName(request.getName())).thenReturn(false);

        Department department = new Department();
        department.setName("Cardiology");

        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        DepartmentRegistrationResponse response = adminService.createDepartment(request);

        assertNotNull(response);
        verify(departmentRepository).existsByName(request.getName());
        verify(departmentRepository).save(any(Department.class));
    }


    @Test
    public void createDepartment_withNullRequest_throwsException_test() throws HospitalAppException {

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.createDepartment(null));

        assertEquals("Department cannot be null", exception.getMessage());

        verify(departmentRepository, never()).existsByName(anyString());
        verify(departmentRepository, never()).save(any(Department.class));
    }

    @Test
    public void createDepartment_withEmptyName_throwsException_test() throws HospitalAppException {

        DepartmentRegisterRequest request = new DepartmentRegisterRequest();

        request.setName("");
        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.createDepartment(request));

        assertEquals("Department name is required", exception.getMessage());

        verify(departmentRepository, never()).existsByName(anyString());
        verify(departmentRepository, never()).save(any(Department.class));
    }

    @Test
    public void createDepartment_withExistingName_throwsException_test() throws HospitalAppException {

        DepartmentRegisterRequest request = new DepartmentRegisterRequest();

        request.setName("Cardiology");
        when(departmentRepository.existsByName(request.getName())).thenReturn(true);

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> adminService.createDepartment(request));

        assertEquals("Department Already exists", exception.getMessage());

        verify(departmentRepository).existsByName(request.getName());
        verify(departmentRepository, never()).save(any(Department.class));
    }


    @Test
    public void viewAllUsers_whenUsersExist_returnsUsers_test() {

        User user1 = new User();
        user1.setFullname("Kenny Smart");
        user1.setEmail("kenny@gmail.com");
        user1.setRole(UserRole.PATIENT);

        User user2 = new User();
        user2.setFullname("Stephen Olatunji");
        user2.setEmail("stephen@gmail.com");
        user2.setRole(UserRole.DOCTOR);

        List<User> users = List.of(user1, user2);

        when(userRepository.findAll()).thenReturn(users);
        List<UserResponse> responses = adminService.viewAllUsers();

        assertNotNull(responses);
        assertEquals(2, responses.size());

        verify(userRepository).findAll();
    }


    @Test
    public void viewAllUsers_whenNoUsersExist_returnsEmptyList_test() {

        when(userRepository.findAll()).thenReturn(List.of());

        List<UserResponse> responses = adminService.viewAllUsers();

        assertNotNull(responses);
        assertTrue(responses.isEmpty());

        verify(userRepository).findAll();
    }

    @Test
    public void viewAllUsers_whenOneUserExists_returnsOneUser_test() {

        User user = new User();
        user.setFullname("Kenny Smart");
        user.setEmail("kenny@gmail.com");
        user.setRole(UserRole.PATIENT);

        when(userRepository.findAll()).thenReturn(List.of(user));

        List<UserResponse> responses = adminService.viewAllUsers();

        assertNotNull(responses);
        assertEquals(1, responses.size());

        verify(userRepository).findAll();
    }
}