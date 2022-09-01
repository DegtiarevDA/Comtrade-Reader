package mpei.ru.back;

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

@RestController
@RequestMapping("/comtrade")
public class ComtradeReaderController {

    @Autowired
    private ComtradeReaderService comtradeReaderService;

    @PostMapping("/readAndSave")
    public String readAndSave(@RequestParam String path,
                              @RequestParam String fileName) {
        comtradeReaderService.read(path, fileName);
        comtradeReaderService.checkTrigger();
        comtradeReaderService.save();
        return "Comtrade with path: " + path + "/" + fileName + " read and save.";
    }

    @GetMapping("/getFault")
    public ResponseEntity<List<FaultDTO>> getFaultList(){
        return new ResponseEntity<>(comtradeReaderService.getFault(), HttpStatus.OK);
    }
}
