package beforespring.managemoney.web.api.expenditure;

import beforespring.managemoney.app.expenditure.service.ExpenditureService;
import beforespring.managemoney.web.api.expenditure.request.CreateExpenditureRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/expenditure")
@RequiredArgsConstructor
public class ExpenditureController {

    private final ExpenditureService expenditureService;

    @PostMapping()
    public void createExpenditure(@RequestBody CreateExpenditureRequest request) {}

    @PatchMapping()
    public void updateExpenditure() {}

    @GetMapping()
    public void findExpenditure() {}

    @GetMapping()
    public void findExpenditureList() {}

    @DeleteMapping()
    public void deleteExpenditure() {}

    @PatchMapping()
    public void excludeTotalExpenditure() {}

}
