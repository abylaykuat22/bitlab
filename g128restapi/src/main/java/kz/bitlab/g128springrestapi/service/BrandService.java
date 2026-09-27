package kz.bitlab.g128springrestapi.service;

import kz.bitlab.g128springrestapi.entity.Brand;
import kz.bitlab.g128springrestapi.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public void addBrand(Brand brand) {
        if (brand == null) {
            return;
        }

        boolean isAlreadyExist = brandRepository.findByCode(brand.getCode()).isPresent();
        if (isAlreadyExist) {
            return;
        }

        brandRepository.save(brand);
    }

    public void updateBrand(Brand brand) {
        if (brand == null) {
            return;
        }

        boolean isAlreadyExist = brandRepository.findByCode(brand.getCode()).isPresent();
        if (isAlreadyExist) {
            return;
        }
        brandRepository.save(brand);
    }

    public void deleteBrandById(Long id) {

        brandRepository.deleteById(id);
    }
}
