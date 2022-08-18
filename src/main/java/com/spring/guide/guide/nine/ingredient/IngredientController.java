package com.spring.guide.guide.nine.ingredient;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.nine.ingredient.data.dto.IngredientCreateRequest;
import com.spring.guide.guide.nine.ingredient.data.dto.IngredientDto;
import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;
import com.spring.guide.guide.nine.ingredient.service.IngredientService;
import com.spring.guide.guide.nine.ingredient.service.ProviderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "IngredientController")
@RestController
@RequiredArgsConstructor
public class IngredientController {
    private final ProviderService providerService;
    private final IngredientService ingredientService;

    @Operation(description = "공급자 조회")
    @GetMapping("/provider/v1/{id}")
    public ResponseEntity<ProviderDto> findProvider(@PathVariable Long id) {
        return ResponseEntity.ok(providerService.selectProviderById(id));
    }

    @Operation(description = "공급자 생성")
    @PostMapping("/provider/v1/create")
    public ResponseEntity<ProviderDto> createProvider(@RequestBody ProviderDto provider) {
        return ResponseEntity.ok(providerService.createProvider(provider));
    }

    @Operation(description = "공급자 삭제")
    @DeleteMapping("/provider/v1/{id}")
    public ResponseEntity<String> removeProvider(@PathVariable Long id) {
        providerService.removeProviderById(id);
        return ResponseEntity.ok("정상 삭제 됨");
    }

    @Operation(description = "공급자 업데이트")
    @PutMapping("/provider/v1/update")
    public ResponseEntity<ProviderDto> updateProvider(@RequestBody ProviderDto provider) {
        return ResponseEntity.ok(providerService.updateProvider(provider));
    }

    @Operation(description = "재료 조회")
    @GetMapping("/ingredient/v1/{id}")
    public ResponseEntity<IngredientDto> findIngredient(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientService.selectIngredientById(id));
    }

    @Operation(description = "재료 생성")
    @PostMapping("/ingredient/v1/create")
    public ResponseEntity<IngredientDto> createIngredient(@RequestBody IngredientCreateRequest createRequest) {
        return ResponseEntity.ok(ingredientService.createIngredient(createRequest.getIngredient(), createRequest.getProvider()));
    }

    @Operation(description = "재료 삭제")
    @DeleteMapping("/ingredient/v1/{id}")
    public ResponseEntity<String> removeIngredient(@PathVariable Long id) {
        ingredientService.removeIngredient(id);
        return ResponseEntity.ok("정상 삭제 됨");
    }

    @Operation(description = "재료 업데이트")
    @PutMapping("/ingredient/v1/update")
    public ResponseEntity<IngredientDto> updateIngredient(@RequestBody IngredientDto ingredient) {
        return ResponseEntity.ok(ingredientService.updateIngredient(ingredient));
    }
}
