package pl.calculator.service;

import java.util.List;

public interface OperationStrategy {

    String execute(List<String> values);

}
