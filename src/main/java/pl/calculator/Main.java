package pl.calculator;

import pl.calculator.client.NumberGenerator;
import pl.calculator.client.java.api.NumberGeneratorJavaAPI;
import pl.calculator.client.rest.api.NumberGeneratorRestAPI;
import pl.calculator.client.rest.api.RestAPICallImpl;
import pl.calculator.service.Calculator;
import pl.calculator.service.Operation;

public class Main {

    public static void main(String[] args) {

        NumberGenerator firstGenerator = new NumberGeneratorJavaAPI();
        NumberGenerator secondGenerator = new NumberGeneratorRestAPI(new RestAPICallImpl());
        Calculator calculator = new Calculator(firstGenerator, secondGenerator);

        System.out.println(calculator.add(0, 5, Operation.ADD));

    }

}
