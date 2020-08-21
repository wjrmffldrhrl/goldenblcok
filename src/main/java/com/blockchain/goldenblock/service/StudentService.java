package com.blockchain.goldenblock.service;

import com.blockchain.goldenblock.controller.MemberController;
import com.blockchain.goldenblock.domain.dto.StudentDto;
import com.blockchain.goldenblock.domain.entity.Student;
import com.blockchain.goldenblock.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    
    public Long saveStudent(StudentDto studentDto) {

        studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        boolean isExist = studentRepository.existsByEmail(studentDto.getEmail());
        if (isExist) {
            throw new MemberController.AlreadyExistsException("change_email");
        }
        return studentRepository.save(studentDto.toEntity()).getId();
    }

    public Student getStudent(String email) {

        return studentRepository.findByEmail(email);

    }
    
}