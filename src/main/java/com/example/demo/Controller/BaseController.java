package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.ApiResponseDto;
import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Audit;
import com.example.demo.IService.IBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



public abstract class BaseController<T extends Audit, S extends IBaseService<T>> {
	protected S service;
	protected String entityName;
	protected BaseController(S service, String entityName) {
			this.service = service;
		 	this.entityName = entityName;
	}

	@GetMapping
	public ResponseEntity<ApiResponseDto<List<T>>> findByStateTrue() {
		try {
			return ResponseEntity.ok(new ApiResponseDto<List<T>>("Datos obtenidos", service.findByStateTrue(), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<List<T>>(e.getMessage(), null, false));
		}
	}


	@PostMapping
	public ResponseEntity<ApiResponseDto<T>> save(@RequestBody T entity) {
		try {
			return ResponseEntity.ok(new ApiResponseDto<T>("Datos guardados", service.save(entity), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<T>(e.getMessage(), null, false));
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<T>> update(@PathVariable Long id, @RequestBody T entity) {
		try {
			service.update(id, entity);
			return ResponseEntity.ok(new ApiResponseDto<T>("Datos actualizados", null, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<T>(e.getMessage(), null, false));
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<T>> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok(new ApiResponseDto<T>("Registro eliminado", null, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<T>(e.getMessage(), null, false));
		}
	}
}