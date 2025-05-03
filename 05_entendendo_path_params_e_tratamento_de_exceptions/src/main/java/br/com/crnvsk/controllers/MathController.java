package br.com.crnvsk.controllers;

import br.com.crnvsk.exception.UnsupportedMathOperationException;
import br.com.crnvsk.math.SimpleMath;
import br.com.crnvsk.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
        ) throws Exception {
            if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
                throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.sum(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{num1}/{num2}")
    public Double subtraction(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.subtraction(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{num1}/{num2}")
    public Double multiplication(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.multiplication(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{num1}/{num2}")
    public Double division(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.division(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{num1}/{num2}")
    public Double mean(
            @PathVariable("num1") String num1,
            @PathVariable("num2") String num2
    ) throws Exception {
        if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return  math.mean(NumberConverter.convertToDouble(num1), NumberConverter.convertToDouble(num2));
    }

    // http://localhost:8080/math/squareRoot/3/5
    @RequestMapping("/squareRoot/{num}")
    public Double squareRoot(
            @PathVariable("num") String num
    ) throws Exception {
        if (!NumberConverter.isNumeric(num))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return  math.squareRoot(NumberConverter.convertToDouble(num));
    }
}
