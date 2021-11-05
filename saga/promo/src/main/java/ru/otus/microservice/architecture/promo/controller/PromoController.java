package ru.otus.microservice.architecture.promo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservice.architecture.promo.model.dto.PromoDto;
import ru.otus.microservice.architecture.promo.service.PromoService;

@RestController
public class PromoController {
    private final PromoService promoService;

    @Autowired
    public PromoController(PromoService promoService) {
        this.promoService = promoService;
    }

    @PostMapping("digital/v1/promo")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PromoDto create(@RequestBody PromoDto promoDto) {
        return promoService.create(promoDto);
    }

    @GetMapping("digital/v1/promo/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PromoDto read(@PathVariable(name = "id") String id) {
        return promoService.read(id);
    }

    @PatchMapping("digital/v1/promo/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PromoDto update(@PathVariable(name = "id") String id, @RequestBody PromoDto promoDto) {
        return promoService.update(id, promoDto);
    }

    @DeleteMapping("digital/v1/promo/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PromoDto delete(@PathVariable(name = "id") String id) {
        return promoService.delete(id);
    }

    @PostMapping("digital/v1/promo/check")
    @ResponseStatus(value = HttpStatus.OK)
    public void check(@RequestBody PromoDto promoDto) {
        promoService.check(promoDto);
    }
}