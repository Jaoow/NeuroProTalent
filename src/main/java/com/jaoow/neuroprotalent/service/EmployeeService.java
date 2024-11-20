package com.jaoow.neuroprotalent.service;

import com.jaoow.neuroprotalent.dto.EmployeeDto;
import com.jaoow.neuroprotalent.entity.Employee;
import com.jaoow.neuroprotalent.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Indica ao Spring que esta classe é um componente de serviço (gerenciado pelo framework).
public class EmployeeService {

    // Repositório que será usado para acessar e manipular dados no banco.
    public final EmployeeRepository employeeRepository;

    // Construtor que injeta a dependência do repositório no serviço.
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Método que busca todos os funcionários no banco de dados.
    public List<EmployeeDto> findAll() {
        // Chama o método findAll do repositório, que retorna uma lista de todos os registros da tabela Employee.
        return employeeRepository.findAll().stream()
                .map(EmployeeDto::fromEntity) // Converte cada entidade para um DTO usando um método helper na classe EmployeeDto.
                .collect(Collectors.toList()); // Coleta os DTOs em uma lista e retorna.
    }

    // Método que busca um funcionário por ID e retorna um ResponseEntity com o DTO correspondente.
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) {
        // Busca o funcionário pelo ID. Caso exista, converte para DTO e retorna com status 200 (OK).
        // Caso contrário, retorna uma resposta com status 404 (Not Found).
        return employeeRepository.findById(id)
                .map(EmployeeDto::fromEntity) // Converte a entidade para um DTO usando um método helper na classe EmployeeDto.
                .map(ResponseEntity::ok) // Envolve o DTO em uma resposta HTTP 200 (OK).
                .orElse(ResponseEntity.notFound().build()); // Caso o ID não seja encontrado, retorna 404 (Not Found).
    }

    // Método para criar um novo funcionário.
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Converte o DTO recebido para uma entidade.
        Employee employee = employeeDto.toEntity();

        // Salva o funcionário recebido no banco de dados.
        Employee saved = employeeRepository.save(employee);

        // Converte a entidade salva para um DTO e retorna.
        return EmployeeDto.fromEntity(saved);
    }

    // Método para deletar um funcionário pelo ID.
    public void deleteEmployee(Long id) {
        // Remove o registro do banco com base no ID.
        employeeRepository.deleteById(id);
    }

    // Método para atualizar um funcionário existente.
    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) {
        // Busca o funcionário no banco pelo ID.
        return employeeRepository.findById(id).map(employeeToSave -> {
                    // Atualiza os dados do funcionário encontrado com as novas informações recebidas.
                    employeeToSave.setName(employeeDto.getName());
                    employeeToSave.setEmail(employeeDto.getEmail());
                    employeeToSave.setPhone(employeeDto.getPhone());
                    employeeToSave.setExperienceTime(employeeDto.getExperienceTime());
                    employeeToSave.setLinkedInUrl(employeeDto.getLinkedInUrl());

                    // Salva o funcionário atualizado no banco de dados.
                    return employeeRepository.save(employeeToSave);
                })
                .map(EmployeeDto::fromEntity) // Converte o funcionário atualizado para um DTO.
                .map(ResponseEntity::ok) // Retorna uma resposta HTTP 200 (OK) com o DTO atualizado.
                .orElse(ResponseEntity.notFound().build()); // Caso o ID não seja encontrado, retorna 404 (Not Found).
    }
}
