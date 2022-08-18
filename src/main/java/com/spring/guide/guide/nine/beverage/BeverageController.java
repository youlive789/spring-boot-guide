package com.spring.guide.guide.nine.beverage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.nine.beverage.data.dto.BeverageCreateDto;
import com.spring.guide.guide.nine.beverage.data.dto.BeverageDto;
import com.spring.guide.guide.nine.beverage.data.dto.BeverageUpdateDto;
import com.spring.guide.guide.nine.beverage.service.BeverageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "BeverageController")
@RestController
@RequestMapping("/beverage/v1/")
@RequiredArgsConstructor
public class BeverageController {
    private final BeverageService beverageService;

    @Operation(description = "음료조회")
    @GetMapping("/{id}")
    public ResponseEntity<BeverageDto> find(@PathVariable Long id) {
        return ResponseEntity.ok(beverageService.selectBeverage(id));
    }

    @Operation(description = "음료생성")
    @PostMapping("/create")
    public ResponseEntity<BeverageDto> create(@RequestBody BeverageCreateDto beverageCreateDto) {
        return ResponseEntity.ok(beverageService.createBeverage(beverageCreateDto));
    }

    @Operation(description = "음료업데이트")
    @PutMapping("/update")
    public ResponseEntity<BeverageDto> update(@RequestBody BeverageUpdateDto beverageUpdateDto) {
        return ResponseEntity.ok(beverageService.updateBeverage(beverageUpdateDto));
    }

    @Operation(description = "음료삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        beverageService.removeBeverage(id);
        return ResponseEntity.ok("정상삭제");
    }
}
