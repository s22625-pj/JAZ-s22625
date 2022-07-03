package com.example.jazs22625.api;

import com.example.jazs22625.model.Database;
import com.example.jazs22625.service.NBPService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NBPRestController {
    private final NBPService nbpService;

    public NBPRestController(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiOperation("Zwraca (a przynajmniej powinno zwracać ale mam problemy z metodą) liczbę walut (z tabeli A) przekraczających kiedykolwiek daną\\n\" +\n" +
            "                        \"(przez użytkownika) średnią ceną biorąc pod uwagę dane z przedziału od YYYY-MM-DD\\n\" +\n" +
            "                        \"do YYYY-MM-DD, z wykorztaniem do tego api NBP")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currencyCount", value = "Liczba walut",dataType = "Long", paramType = "variable", example = "5"),
            @ApiImplicitParam(name = "from", value = "Data od YYYY-MM-DD", dataType = "string"),
            @ApiImplicitParam(name = "to", value = "Data do YYYY-MM-DD",dataType = "string")
    })

    @GetMapping("/{avg}")
    public ResponseEntity<Database> currencyCount(@PathVariable Long currencyCount,@RequestParam(defaultValue = "2021-05-01") String from, @RequestParam(defaultValue = "2020-07-03") String to){
        return ResponseEntity.ok(nbpService.currencyCount(from,to,currencyCount));
    }
}
