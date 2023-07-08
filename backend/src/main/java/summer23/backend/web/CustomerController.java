package summer23.backend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;
import summer23.backend.domain.CustomerRepository;
import summer23.backend.domain.Customer;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	// Show customerlist
	@RequestMapping(value= {"/customerlist"})
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerRepository.findAll());
		return "customerlist";
	}
	
	// Add new customer
	@RequestMapping(value = "/addcustomer")
	public String addCustomer(Model model){
		model.addAttribute("customer", new Customer());
		return "addcustomer";
	}
	
	// Save new customer
	@PostMapping("/savecustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "editcustomer";
		}
		customerRepository.save(customer);
		return "redirect:customerlist";
	}
	
	// Delete customer, if there's no favorites
	@GetMapping("/deletecustomer/{id}")
    public RedirectView deleteCustomer(@PathVariable("id") Long customerId, RedirectAttributes attributes) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        // From optional to normal
        Customer normalCustomer = customer.get();
        if (normalCustomer.getFavorites().isEmpty()) {
            customerRepository.deleteById(customerId);
        } else {
            attributes.addFlashAttribute("error", "Customer can't be deleted since it has favorites!");
        }
        return new RedirectView("/customerlist");
    }
	
	// Edit customer
	@GetMapping("/editcustomer/{id}")
	public String editCustomer(Customer customer, @PathVariable("id") Long customerId, Model model){ 
		model.addAttribute("customer", customerRepository.findById(customerId));
		return "editsong";
	}
 
}