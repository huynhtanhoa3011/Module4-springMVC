package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @RequestMapping(value = "",method = RequestMethod.GET)
    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public ModelAndView info(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customers/info.jsp");
        modelAndView.addObject("customer",customerService.findOne(id));
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView updateCustomer(Customer customer){
        ModelAndView modelAndView = new ModelAndView();
        customerService.save(customer);
        modelAndView.setViewName("redirect:/customers");
        return modelAndView;
    }

}
