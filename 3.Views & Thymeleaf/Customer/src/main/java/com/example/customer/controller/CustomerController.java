package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.model.Department;
import com.example.customer.service.CustomerService;
import com.example.customer.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers",customerList);
        return "/index";
    }

    @PostMapping("/search")
    public String Search(Model model,@RequestParam( name = "search") String name){
        List<Customer> customerList = customerService.findByName(name);
        model.addAttribute("customers",customerList);
        return "/index";
    }

    //Add
    @GetMapping("/create")
    public String create(Model model){
        List<Department> departmentList = customerService.findAllDepartment();
        model.addAttribute("departments",departmentList);
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer, @RequestParam("departmentSelect") int id , RedirectAttributes redirect){
        customer.setId((int) (Math.random() * 10000));
        customer.setDepartment(customerService.findByIdDepartment(id));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Add customer successfully!");
        return "redirect:/customer";
    }

    //Edit
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        List<Department> departmentList = customerService.findAllDepartment();
        model.addAttribute("departments",departmentList);
        model.addAttribute("customer",customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, @RequestParam("departmentSelect") int id,RedirectAttributes redirect){
        customerService.update(customer.getId(),customer);
        customer.setDepartment(customerService.findByIdDepartment(id));
        redirect.addFlashAttribute("success", "Edit customer successfully!");
        return "redirect:/customer";
    }
    //Delete

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    //view
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }


}
