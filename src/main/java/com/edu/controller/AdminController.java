package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Admin;
import com.edu.dao.Customer;
import com.edu.error.GlobalException;
import com.edu.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	//http://localhost:9999/saveAdmin - It is used for save Admin details
	@PostMapping("/saveAdmin")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin){
		Admin ad = adminService.saveAdmin(admin);
		return new ResponseEntity<Admin>(ad,HttpStatus.CREATED);
	}

	//http://localhost:9999/getAllAdmin  - It is used for fetch the details of existing Admin
	@GetMapping("/getAllAdmin")
	List<Admin> getAllAdmin(){
		return adminService.getAllAdmin();
	}
	
	//http://localhost:9999/deleteAdminById/adminid - It is used for Delete Admin By Admin Id
	@DeleteMapping("/deleteAdminById/{adminid}")
	String deleteAdminById(@PathVariable("adminid") Integer adminid) throws GlobalException {
		adminService.deleteAdminById(adminid);
		return "Record Deleted";
	}
	
	//http://localhost:9999/updateAdminById/{adminid} - It is Used to update Admin By Admin Id
	@PutMapping("/updateAdminById/{adminid}")
	Admin updateAdminById(@PathVariable("adminid") Integer adminid, @Valid @RequestBody Admin admin) throws GlobalException {
		return adminService.updateAdminById(adminid, admin);
	}
	
	//http://localhost:9999/getAdminById/{adminId} - It is used to fetch Admin Data By Admin ID
	@GetMapping("/getAdminById/{adminId}")
	public Admin getAdminById(@PathVariable("adminId") Integer adminid) {
		return adminService.getAdminById(adminid);
	}
	
	//http://localhost:9999/getAdminByusername/{username}/{password} - It is Used to fetch Admin By username & password
	@GetMapping("/getAdminByusername/{username}/{password}")
	public Admin getAdminByusername(@PathVariable("username") String username,@PathVariable("password") String password) {
		return adminService.getAdminByusername(username,password);
	}

}
