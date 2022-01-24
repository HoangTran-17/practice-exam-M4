package com.cg.controller;

import com.cg.model.Country;
import com.cg.model.Province;
import com.cg.service.ICountryService;
import com.cg.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICountryService countryService;

    @GetMapping
    public ModelAndView listProvince() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.setViewName("/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create", "province", new Province());
        Iterable<Country> countries = countryService.findAll();
        modelAndView.addObject("countries", countries);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveprovince(@ModelAttribute Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/list", "message", "Thêm thành phố thành công!");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView editProvince(@PathVariable long id) {
        Optional<Province> province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit", "province", province.get());
        Iterable<Country> countries = countryService.findAll();
        modelAndView.addObject("countries", countries);
        return modelAndView;

    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("province", province.get());
            return modelAndView;
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("province") Province province) {
        provinceService.remove(province.getId());
        return "redirect:";
    }

    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Province> provinceOptional = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("province", provinceOptional.get());
        return modelAndView;
    }
}
