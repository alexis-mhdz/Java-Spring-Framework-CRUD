package com.indra.crud;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.indra.crud.model.Country;
import com.indra.crud.model.Department;
import com.indra.crud.model.Employee;
import com.indra.crud.model.Job;
import com.indra.crud.model.JobHistory;
import com.indra.crud.model.JobHistoryIdentity;
import com.indra.crud.model.Location;
import com.indra.crud.model.Phone;
import com.indra.crud.model.Region;
import com.indra.crud.repository.EmployeesRepository;
import com.indra.crud.repository.JobHistoryRepository;
import com.indra.crud.service.CountryServiceImp;
import com.indra.crud.service.DepartmentServiceImp;
import com.indra.crud.service.EmployeeServiceImp;
import com.indra.crud.service.JobHistoryServiceImp;
import com.indra.crud.service.JobServiceImp;
import com.indra.crud.service.LocationServiceImp;
import com.indra.crud.service.PhoneServiceImp;
import com.indra.crud.service.RegionServiceImp;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	@Autowired
	private JobHistoryServiceImp jobHistoryServiceImp;
	@Autowired
	private DepartmentServiceImp departmentServiceImp;
	@Autowired
	private LocationServiceImp locationServiceImp;
	@Autowired
	private JobServiceImp jobServiceImp;
	@Autowired
	private CountryServiceImp countryServiceImp;
	@Autowired
	private RegionServiceImp regionServiceImp;
	@Autowired
	private PhoneServiceImp phoneServiceImp;
	@Autowired
	private EmployeesRepository employeesRepository;
	@Autowired
	private JobHistoryRepository jobHistoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		if(employeesRepository != null) {
			System.out.println("El repositorio empleados se inyecto.");
		}*/
		//findAllEmployees();
		//saveEmployee();
		//deleteEmployee();
		//updateEmployee();
		//buscarEmpleados();
		//actualizarEmpleado();
		//eliminarEmpleado();
		//agregarEmpleado();
		
		/* Employee Methods */
		//insertEmployee();
		//searchAllEmployees();
		//searchEmployee();
		//updateEmployee();
		//deleteEmployee();
		
		/* JobHistory Methods */
		//insertJobHistory();
		//searchAllJobHistory();
		//searchJobHistory();
		//updateJobHistory();
		//deleteJobHistory();
		
		/* Job Methods */
		//insertJob();
		//searchAllJobs();
		//searchJob();
		//updateJob();
		//deleteJob();
		
		/* Department Methods */
		//insertDepartment();
		//searchAllDepartments();
		//searchDepartment();
		//updateDepartment();
		//deleteDepartment();
		
		/* Location Methods */
		//insertLocation();
		//searchAllLocations();
		//searchLocation();
		//updateLocation();
		//deleteLocation();
		
		/* Country Methods */
		//insertCountry();
		//searchAllCountries();
		//searchCountry();
		//updateCountry();
		//deleteCountry();
		
		/* Region Methods */
		//insertRegion();
		//searchAllRegions();
		//searchRegion();
		//updateRegion();
		//deleteRegion();
		
		/* Phone Methods */
		//insertPhone();
		//searchAllPhones();
		//searchPhone();
		//updatePhone();
		//deletePhone();
	}
	
	/*
	private void buscarEmpleados() {
		System.out.println("Lista de todos los empleados: ");
		for(Employee employee: employeeServiceImp.buscarEmpleados()) {
			System.out.println(employee.toString());
		}
	}
	*/
	
	/*
	private void agregarEmpleado() {
		System.out.println("Agregando un nuevo empleado");
		
		Employee employee = new Employee();
		employee.setFirstName("Alexis");
		employee.setLastName("Mozo Hernandez");
		employee.setEmail("alexismhdz@hotmail.com");
		employee.setPhoneNumber("556.601.4749");
		employee.setHireDate(new Date());
		employee.setJobId("IT_PROG");
		employee.setSalary(6000.00);
		employee.setManagerId(100);
		employee.setDepartamentId(60);
			
		System.out.println(employeeServiceImp.agregarEmpleado(employee));
	}
	*/
	
	/*
	private void actualizarEmpleado() {
		System.out.println("Actualizando un empleado");
		
		Employee employee = new Employee();
		employee = employeeServiceImp.buscarEmpleado(209);
		employee.setEmail("alexis@hotmail.com");
		
		System.out.println(employeeServiceImp.actualizarEmpleado(employee));
	}
	*/
	
	/*
	private void eliminarEmpleado() {
		System.out.println("Eliminando un empleado");
		Employee employee = new Employee();
		employee.setEmployeeId(209);
		System.out.println(employeeServiceImp.eliminarEmpleado(employee));
	}
	*/
	
	/*
	private void findAllEmployees() {
		System.out.println("Lista de todos los empleados: ");
		Iterable<Employee> iter = employeesRepository.findAll();	
		for(Employee item: iter) {
			System.out.println(item.toString());			
		}
	}
	*/
	
	/*
	private void saveEmployee() {
		System.out.println("Insertando un nuevo empleado a la base de datos");
		
		java.util.Date fecha = new Date(0);
		Employee employee = new Employee();
		//employee.setEmployeeId(1001);
		employee.setFirstName("Alanadn");
		employee.setLastName("Mozo Hernandez");
		employee.setEmail("bcd112di@hotmail.com");
		employee.setPhoneNumbre("556.601.4749");
		employee.setHireDate(fecha);
		employee.setJobId("IT_PROG");
		employee.setSalary(6000.00);
		employee.setManagerId(100);
		employee.setDepartamentId(60);
		
		employeesRepository.save(employee);
		
	}*/
	
	/*
	private void deleteEmployee() {
		System.out.println("Eliminando un usuario de la base de datos.");
		employeesRepository.deleteById(208);
	}
	*/
	
	/*
	private void updateEmployee() {
		System.out.println("Actualizando un usuario de la base de datos.");
			
		Optional<Employee> regreso = employeesRepository.findById(208); 
		
		if(regreso.isPresent()) {
			Employee employee = regreso.get();
		
			employee.setEmail("ale1xsm@hotmail.com");
			
			employeesRepository.save(employee);
		}
		
	}*/
	
	/* Employee Methods */
	private void insertEmployee() {
		
		System.out.println("Insertando nuevo empleado");
		
		Date date = new Date();
		Employee employee = new Employee();
		Job job = new Job();
		job.setJobId("IT_PROG");
		Department department = new Department();
		department.setDepartmentId(60);
		Employee manager = new Employee();
		manager.setEmployeeId(100);
		
		employee.setFirstName("Alexis");
		employee.setLastName("Mozo Hernandez");
		employee.setEmail("alexishd@hotmail.com");
		employee.setPhoneNumber("556.601.4749");
		employee.setHireDate(date);
		//employee.setJobId("IT_PROG");
		employee.setJob(job);
		employee.setSalary(6000.00);
		employee.setManagerId(100);
		//employee.setManager(manager);
		employee.setDepartment(department);
		
		System.out.println(employeeServiceImp.insertEmployee(employee));
	}
	
	private void searchAllEmployees() {
		System.out.println("Lista de todos los Empleados: ");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = employeeServiceImp.searchAllEmployees();
		for(Employee employee: employeeList) {
			System.out.println(employee.toString());
		}
	}
	
	private void searchEmployee() {
		System.out.println("Buscando empleado: ");
		Employee employee = new Employee();
		employee.setEmployeeId(213);
		
		employee = employeeServiceImp.searchEmployee(employee);
		
		System.out.println(employee.toString());
	}
	
	private void updateEmployee() {
		System.out.println("Actualizando empleado: ");
		Employee employee = new Employee();
		employee.setEmployeeId(214);
		
		employee = employeeServiceImp.searchEmployee(employee);
		
		employee.setEmail("alexismhdz@hotmail.com");
		
		System.out.println(employeeServiceImp.updateEmployee(employee));
	}
	
	private void deleteEmployee() {
		
		System.out.println("Eliminando empleado: ");
		Employee employee = new Employee();
		employee.setEmployeeId(214);
		
		System.out.println(employeeServiceImp.deleteEmployee(employee));
		
	}
	
	/* JobHistory Methods */
	/*
	private void findJobHistory() {
		jobHistoryRepository.findById(new JobHistoryIdentity(200, new Date(01/07/02)));
	}
	*/
	
	private void insertJobHistory() {
		System.out.println("Insertando nuevo historial de trabajo");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		try {
			date = format.parse("10/10/2002");    			
		} catch (Exception ex) {}
		
		JobHistory jobHistory = new JobHistory();
		jobHistory.setId(new JobHistoryIdentity(190, date));
		
		try {
			date = format.parse("20/10/02");
		} catch (Exception ex) {}
		
		jobHistory.setEndDate(date);
		jobHistory.setJobId("SA_REP");
		
		System.out.println(jobHistoryServiceImp.insertJobHistory(jobHistory));
	}
	
	private void searchAllJobHistory() {
		System.out.println("Lista de todos los historiales de trabajo: ");
		List<JobHistory> jobHistoryList = new ArrayList<JobHistory>();
		jobHistoryList = jobHistoryServiceImp.searchAllJobHistory();
		for(JobHistory jobHistory: jobHistoryList) {
			System.out.println(jobHistory.toString());
		}
	}
	
	private void searchJobHistory() {
				
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		try {
			date = format.parse("10/10/2002");    			
		} catch (Exception ex) {}
				
		System.out.println("Buscando JobHistory");
		JobHistory jobHistory = new JobHistory();
		jobHistory.setId(new JobHistoryIdentity(190, date));
		System.out.println(jobHistoryServiceImp.searchJobHistory(jobHistory));

	}
	
	private void updateJobHistory() {
		System.out.println("Actualizando historial de trabajo");
		
		JobHistory jobHistory = new JobHistory();
		//jobHistory.setId(new JobHistoryIdentity(190, "10/10/02"));
		//jobHistory = jobHistoryServiceImp.searchJobHistory(jobHistory);
		//jobHistory.setEndDate("20/11/02");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		try {
			date = format.parse("10/10/2002");    			
		} catch (Exception ex) {}
				
		jobHistory.setId(new JobHistoryIdentity(190, date));
		jobHistory = jobHistoryServiceImp.searchJobHistory(jobHistory);
		
		try {
			date = format.parse("10/12/2002");    			
		} catch (Exception ex) {}
		
		jobHistory.setEndDate(date);
		jobHistory.setDepartmentId(50);
				
		System.out.println(jobHistoryServiceImp.updateJobHistory(jobHistory));
	}
	
	private void deleteJobHistory() {
		System.out.println("Eliminando historial de trabajo");
		
		JobHistory jobHistory = new JobHistory();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		try {
			date = format.parse("10/10/2002");    			
		} catch (Exception ex) {}
				
		jobHistory.setId(new JobHistoryIdentity(190, date));
		//jobHistory.setId(new JobHistoryIdentity(190, "10/10/02"));
		
		System.out.println(jobHistoryServiceImp.deleteJobHistory(jobHistory));
	}
	
	private void insertJob() {
		System.out.println("Insertando nuevo trabajo");
		
		Job job = new Job();
		job.setJobId("IT_SUPP");
		job.setJobTitle("Suport");
		job.setMinSalary(3000);
		job.setMaxSalary(9000);
		
		System.out.println(jobServiceImp.insertJob(job));
		
	}
	
	private void searchAllJobs() {
		System.out.println("Lista de todos los trabajos: ");
		List<Job> jobList = new ArrayList<Job>();
		jobList = jobServiceImp.searchAllJobs();
		for(Job job: jobList) {
			System.out.println(job.toString());
		}
	}
	
	private void searchJob() {
		System.out.println("Buscando Trabajo: ");
		Job job = new Job();
		job.setJobId("IT_SUPP");
		System.out.println(jobServiceImp.searchJob(job));
	}
	
	private void updateJob() {
		System.out.println("Actualizando trabajo: ");
		Job job = new Job();
		job.setJobId("IT_SUPP");
		
		job = jobServiceImp.searchJob(job);
		
		job.setJobTitle("Support");
		
		System.out.println(jobServiceImp.updateJob(job));
	}
	
	
	private void deleteJob() {
		System.out.println("Eliminando trabajo");
		
		Job job = new Job();
		job.setJobId("IT_SUPP");
		
		System.out.println(jobServiceImp.deleteJob(job));
	}
	
	private void insertDepartment() {
		System.out.println("Insertando nuevo departamento");
		
		Department department = new Department();
		department.setDepartmentName("IT Salesza");
		
		System.out.println(departmentServiceImp.insertDepartment(department));
		
	}
	
	
	private void searchAllDepartments() {
		System.out.println("Lista de todos los departamentos: ");
		List<Department> departmentList = new ArrayList<Department>();
		departmentList = departmentServiceImp.searchAllDepartments();
		for(Department department: departmentList) {
			System.out.println(department.toString());
		}
	}
	
	private void searchDepartment() {
		System.out.println("Buscando Departamento: ");
		Department department = new Department();
		department.setDepartmentId(320);
		System.out.println(departmentServiceImp.searchDepartment(department));
	}
	
	private void updateDepartment() {
		System.out.println("Actualizando departamento: ");
		Department department = new Department();
		department.setDepartmentId(320);
		
		department = departmentServiceImp.searchDepartment(department);
		
		department.setDepartmentName("IT Sales");
		
		System.out.println(departmentServiceImp.updateDepartment(department));
	}
	
	private void deleteDepartment() {
		System.out.println("Eliminando departamento");
		
		Department department = new Department();
		department.setDepartmentId(320);
		
		System.out.println(departmentServiceImp.deleteDepartment(department));
	}
	
	private void insertLocation() {
		System.out.println("Insertando nueva localización");
		
		Location location = new Location();
		location.setStreetAdrees("Medellin 193");
		location.setPostalCode("58900");
		location.setCity("Mexico City");
		location.setStateProvince("Distrito Federal");
		location.setCountryId("MX");
		
		System.out.println(locationServiceImp.insertLocation(location));
	}
	
	private void searchAllLocations() {
		System.out.println("Lista de todas las localizaciones: ");
		List<Location> locationList = new ArrayList<Location>();
		locationList = locationServiceImp.searchAllLocations();
		for(Location location: locationList) {
			System.out.println(location.toString());
		}
	}
	
	private void searchLocation() {
		System.out.println("Buscando Localización: ");
		Location location = new Location();
		location.setLocationId(3300);
		System.out.println(locationServiceImp.searchLocation(location));
	}
	
	private void updateLocation() {
		System.out.println("Actualizando localización: ");
		Location location = new Location();
		location.setLocationId(3300);
		
		location = locationServiceImp.searchLocation(location);
		
		location.setStreetAdrees("Medellin 200");
		
		System.out.println(locationServiceImp.updateLocation(location));
	}
	
	private void deleteLocation() {
		System.out.println("Eliminando localización");
		
		Location location = new Location();
		location.setLocationId(3300);
		
		System.out.println(locationServiceImp.deleteLocation(location));
	}
	
	private void insertCountry() {
		Country country = new Country();
		country.setCountryId("IR");
		country.setCountryName("Ireland");
		country.setRegionId(3);
		
		System.out.println(countryServiceImp.insertCountry(country));	
	}
	
	
	private void searchAllCountries() {
		System.out.println("Lista de todos los paises: ");
		List<Country> countryList = new ArrayList<Country>();
		countryList = countryServiceImp.searchAllCountries();
		for(Country country: countryList) {
			System.out.println(country.toString());
		}
	}
	
	private void searchCountry() {
		System.out.println("Buscando País: ");
		Country country = new Country();
		country.setCountryId("IR");
		System.out.println(countryServiceImp.searchCountry(country));
	}
	
	private void updateCountry() {
		System.out.println("Actualizando país: ");
		Country country = new Country();
		country.setCountryId("IR");
		
		country = countryServiceImp.searchCountry(country);
		
		country.setRegionId(1);
		
		System.out.println(countryServiceImp.updateCountry(country));
	}
	
	private void deleteCountry() {
		System.out.println("Eliminando país");
		
		Country country = new Country();
		country.setCountryId("IR");
		
		System.out.println(countryServiceImp.deleteCountry(country));
	}
	
	private void insertRegion() {
		Region region = new Region();
		region.setRegionName("Muy lejano");
		
		System.out.println(regionServiceImp.insertRegion(region));	
	}
	
	private void searchAllRegions() {
		System.out.println("Lista de todas las regiones: ");
		List<Region> regionList = new ArrayList<Region>();
		regionList = regionServiceImp.searchAllRegions();
		for(Region region: regionList) {
			System.out.println(region.toString());
		}
	}
	
	private void searchRegion() {
		System.out.println("Buscando Región: ");
		Region region = new Region();
		region.setRegionId(5);
		System.out.println(regionServiceImp.searchRegion(region));
	}
	
	private void updateRegion() {
		System.out.println("Actualizando región: ");
		Region region = new Region();
		region.setRegionId(5);
		
		region = regionServiceImp.searchRegion(region);
		
		region.setRegionName("Muy muy lejano");
		
		System.out.println(regionServiceImp.updateRegion(region));
	}
	
	private void deleteRegion() {
		System.out.println("Eliminando región: ");
		
		Region region = new Region();
		region.setRegionId(5);
		
		System.out.println(regionServiceImp.deleteRegion(region));
	}
	
	private void insertPhone() {
		Phone phone = new Phone();
		
		phone.setExtension("555");
		phone.setIsdCode("52");
		phone.setPhoneNumber("5566014749");
		phone.setType("Celular");
		phone.setEmployeeId(200);
		
		System.out.println(phoneServiceImp.insertPhone(phone));	
	}
	
	private void searchAllPhones() {
		System.out.println("Lista de todos los telefonos: ");
		List<Phone> phoneList = new ArrayList<Phone>();
		phoneList = phoneServiceImp.searchAllPhones();
		for(Phone phone: phoneList) {
			System.out.println(phone.toString());
		}
	}
	
	private void searchPhone() {
		System.out.println("Buscando Telefono: ");
		Phone phone = new Phone();
		phone.setId(1);
		System.out.println(phoneServiceImp.searchPhone(phone));
	}
	
	private void updatePhone() {
		System.out.println("Actualizando telefono: ");
		Phone phone = new Phone();
		phone.setId(1);
		
		phone = phoneServiceImp.searchPhone(phone);
		
		phone.setPhoneNumber("55-66-01-47-49");
		
		System.out.println(phoneServiceImp.updatePhone(phone));
	}
	
	private void deletePhone() {
		System.out.println("Eliminando telefono: ");
		
		Phone phone = new Phone();
		phone.setId(1);
		
		System.out.println(phoneServiceImp.deletePhone(phone));
	}
}
