package kz.bitlab.g128springrestapi.controller;

import kz.bitlab.g128springrestapi.entity.Brand;
import kz.bitlab.g128springrestapi.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Brand getBrand(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public void addBrand(@RequestBody Brand brand) {
        brandService.addBrand(brand);
    }

    @PutMapping
    public void updateBrand(@RequestBody Brand brand) {
        brandService.updateBrand(brand);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable Long id) {
        brandService.deleteBrandById(id);
    }
}
