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

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class csvRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
          List<List<String>> records = new ArrayList<>();
       BufferedReader br = new BufferedReader(new FileReader("epic_energy_service\\src\\main\\resources\\comuni-italiani.csv"));
        String line;
    while ((line = br.readLine()) != null) {
    String[] values = line.split(";");
    records.add(Arrays.asList(values));
    log.info(values[0].toString() + " " + values[1].toString() + " " + values[2].toString() + " " + values[3].toString());
    // records.forEach(el -> log.info(el.toString()));
    }

        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

       
    

   

}
