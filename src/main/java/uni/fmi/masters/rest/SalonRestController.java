package uni.fmi.masters.rest;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.fmi.masters.dto.SalonDTO;
import uni.fmi.masters.dto.UserDTO;
import uni.fmi.masters.models.Salon;
import uni.fmi.masters.models.User;
import uni.fmi.masters.services.SalonService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path ="/salon")
public class SalonRestController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SalonService salonService;


    @GetMapping
    public List<SalonDTO> findAll(){
        List<Salon> salons = salonService.findAll();
        return salons.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private SalonDTO convertToDTO(Salon salon) {
        return modelMapper.map(salon, SalonDTO.class);
    }
    @GetMapping(path = "/{salonId}")
    public SalonDTO getBy(@PathVariable(name = "salonId") long salonId) {
        Optional<Salon> optionalSalon = salonService.getEntity(salonId);
        return optionalSalon.map(this::convertToDTO).orElse(null);
    }
    @PostMapping()
    public SalonDTO create(@RequestBody SalonDTO salonDTO) {
        Salon salon = convertToModel(salonDTO);
        salon.setId(null);
        return convertToDTO(salonService.create(salon));
    }
    public Salon convertToModel(SalonDTO salonDTO) {
        return modelMapper.map(salonDTO, Salon.class);
    }
//    @PutMapping()
//    public ProductDTO update(@RequestBody ProductDTO productDTO) {
//        Product updated = productService.update(convertToModel(productDTO));
//        return convertToDTO(updated);
//    }
//
//    @DeleteMapping(path = "/{productId}")
//    public ResponseEntity<String> remove(@PathVariable(name = "productId") long productId) {
//
//        boolean isRemoved = productService.remove(productId);
//
//        String deletedMessage = "Product with id: '" + productId + "' was deleted!";
//        String notDeletedMessage = "Product with id: '" + productId + "' does not exists!";
//        return isRemoved ?
//                new ResponseEntity<>(deletedMessage, HttpStatusCode.valueOf(200)) :
//                new ResponseEntity<>(notDeletedMessage, HttpStatusCode.valueOf(404));
//    }

}


