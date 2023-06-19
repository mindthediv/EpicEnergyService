package com.epic_energy.epic_energy_service.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class csvRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        throw new UnsupportedOperationException("Unimplemented method 'run'");

    }

 List<List<String>> records = new ArrayList<>();try(
    BufferedReader br = new BufferedReader(new FileReader("comuni-italiani.csv")))
    {
String line;
while ((line = br.readLine()) != null) {
String[] values = line.split(";");
records.add(Arrays.asList(values));
}

  
}
