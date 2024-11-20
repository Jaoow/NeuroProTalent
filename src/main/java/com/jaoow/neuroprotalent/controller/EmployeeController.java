package com.jaoow.neuroprotalent.controller;

import com.jaoow.neuroprotalent.dto.EmployeeDto;
import com.jaoow.neuroprotalent.entity.Employee;
import com.jaoow.neuroprotalent.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta classe é um controlador REST no Spring.
@RequestMapping("/employee") // Define o caminho base para os endpoints deste controlador: localhost:8080/employee.
public class EmployeeController {

    private final EmployeeService employeeService;

    // Construtor para injeção de dependência do serviço.
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping // Mapeia requisições HTTP GET no endpoint /employee.
    public List<EmployeeDto> getAllEmployees() {
        // Retorna uma lista de todos os funcionários utilizando o serviço.
        return employeeService.findAll();
    }

    @GetMapping("/{id}") // Mapeia requisições HTTP GET no endpoint /employee/{id}.
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        // Busca um funcionário pelo ID e retorna uma resposta apropriada (200 ou 404).
        return employeeService.getEmployeeById(id);
    }

    @PostMapping // Mapeia requisições HTTP POST no endpoint /employee.
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employee) {
        // Cria um novo funcionário com os dados recebidos no corpo da requisição.
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}") // Mapeia requisições HTTP DELETE no endpoint /employee/{id}.
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        // Deleta o funcionário com o ID especificado.
        employeeService.deleteEmployee(id);
        // Retorna uma resposta sem conteúdo (204 No Content).
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}") // Mapeia requisições HTTP PUT no endpoint /employee/{id}.
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employee) {
        // Atualiza o funcionário com o ID especificado utilizando os dados recebidos.
        return employeeService.updateEmployee(id, employee);
    }
}
