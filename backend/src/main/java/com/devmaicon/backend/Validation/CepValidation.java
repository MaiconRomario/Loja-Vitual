package com.devmaicon.backend.Validation;

import com.devmaicon.backend.Validation.constraints.ValidatorCep;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CepValidation implements ConstraintValidator<ValidatorCep, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Verifica se o CEP é nulo ou vazio
        if (value == null || value.isEmpty()) {
            return false;
        }

        // Remove qualquer caractere que não seja dígito (0-9)
        String cepDigitsOnly = value.replaceAll("\\D", "");

        // Verifica se o CEP possui 8 dígitos
        if (cepDigitsOnly.length() != 8) {
            return false;
        }

        // Se todas as condições forem atendidas, considera o CEP válido
        return true;

    }

}
