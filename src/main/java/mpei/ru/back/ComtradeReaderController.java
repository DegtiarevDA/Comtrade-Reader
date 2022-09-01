package mpei.ru.back;

import lombok.extern.slf4j.Slf4j;
import mpei.ru.back.model.dto.DataDTO;
import mpei.ru.back.model.dto.FaultDTO;
import mpei.ru.back.service.ComtradeReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */

@Slf4j
@RestController
@RequestMapping("/comtrade")
public class ComtradeReaderController {

    @Autowired
    private ComtradeReaderService comtradeReaderService;

    @GetMapping("/readAndSave")
    public ResponseEntity<List<DataDTO>> readAndSave(@RequestParam String path,
                                                      @RequestParam String fileName) {
        comtradeReaderService.read(path, fileName);
        comtradeReaderService.checkTrigger();
        comtradeReaderService.save();
        log.info("Comtrade with path: " + path + "/" + fileName + " read and save.");
        return getData();
    }

    @GetMapping("/getFault")
    public ResponseEntity<List<FaultDTO>> getFaultList() {
        return new ResponseEntity<>(comtradeReaderService.getFault(), HttpStatus.OK);
    }

    @GetMapping("/getData")
    public ResponseEntity<List<DataDTO>> getData() {
        return new ResponseEntity<>(comtradeReaderService.getData(), HttpStatus.OK);
    }
}
