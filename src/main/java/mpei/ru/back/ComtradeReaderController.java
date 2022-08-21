package mpei.ru.back;

import mpei.ru.back.model.dto.FaultDTO;
import mpei.ru.back.service.ComtradeReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Degtiarev Dmitry on 17.08.2022
 * @project Comtrade_reader
 */

@RestController
public class ComtradeReaderController {

    @Autowired
    private ComtradeReaderService comtradeReaderService;

    @PostMapping("comtrade/readAndSave")
    public String readAndSave(@RequestParam String path,
                              @RequestParam String fileName) {
        comtradeReaderService.read(path, fileName);
        comtradeReaderService.checkTrigger();
        comtradeReaderService.save();
        return "Comtrade with path: " + path + "/" + fileName + " read and save.";
    }

    @GetMapping("comtrade/getFault")
    public List<FaultDTO> getFaultList(){
        return comtradeReaderService.getFault();
    }
}
