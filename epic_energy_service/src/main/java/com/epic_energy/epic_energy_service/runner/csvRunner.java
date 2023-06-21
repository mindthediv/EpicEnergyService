// package com.epic_energy.epic_energy_service.runner;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.util.ArrayList;
// import java.util.Arrays;
//import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.ApplicationArguments;
// import org.springframework.boot.ApplicationRunner;
// import org.springframework.stereotype.Component;
// import com.epic_energy.epic_energy_service.models.Municipality;
// import com.epic_energy.epic_energy_service.models.Province;
// import com.epic_energy.epic_energy_service.repositories.MunicipalityRepository;
// import com.epic_energy.epic_energy_service.repositories.ProvinceRepository;
// import com.epic_energy.epic_energy_service.services.ProvinceService;
// import lombok.val;
// import lombok.extern.slf4j.Slf4j;
// @Component
//@Slf4j
// public class csvRunner implements ApplicationRunner {
//     @Autowired      ProvinceService provinceService;
//     @Autowired
//    ProvinceRepository provinceDAO;
//     @Autowired
//     MunicipalityRepository municDAO;
//     @Override
//     public void run(ApplicationArguments args) throws Exception {
//         List<List<String>> recordsProvince = new ArrayList<>();
// 		     BufferedReader brProvince = new BufferedReader(
// 		     new
// 		     FileReader("epic_energy_service/src/main/resources/province-italiane.csv"));
// 		     String lineProvince;
// 		     while ((lineProvince = brProvince.readLine()) != null) {
//		     String[] values = lineProvince.split(";");
//		     recordsProvince.add(Arrays.asList(values));
//		     Province p = new Province();
//		     p.setSign(values[0]);
// 		     p.setName(values[1]);
//		     p.setRegion(values[2]);
// 		     System.out.println(p);
// 		     provinceService.saveProvince(p);
//		     // log.info(values[0].toString() + " " + values[1].toString());
//		     // records.forEach(el -> log.info(el.toString()));
//}
//         List<List<String>> records = new ArrayList<>();
//         BufferedReader br = new BufferedReader(
//                 new FileReader("epic_energy_service/src/main/resources/comuni-italiani.csv"));
// 			String line;
// 			while ((line = br.readLine()) != null) {
// 			    String[] values = line.split(";");
// 			     Municipality m = new Municipality();  			     m.setName(values[2]);
//			     m.setProvincename(provinceDAO.findByName(values[3]));
//			     m.setProvince_id(values[0]);
// 			     m.setMunicipality_id(values[1]);  			     municDAO.save(m);
//		    records.add(Arrays.asList(values));
//		   // log.info(values[0].toString() + " " + values[1].toString() + " "
// 		   //         + values[2].toString() + " ");		   
//		     }		     
//     
// 			    throw new UnsupportedOperationException("Unimplemented method 'run'");
//     
//     
// 
//             
//             }
// }
