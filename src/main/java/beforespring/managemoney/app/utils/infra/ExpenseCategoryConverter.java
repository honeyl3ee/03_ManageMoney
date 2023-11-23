package beforespring.managemoney.app.utils.infra;

import beforespring.managemoney.app.utils.ExpenseCategory;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

public class ExpenseCategoryConverter implements AttributeConverter<ExpenseCategory, List<String>> {

    @Override
    public List<String> convertToDatabaseColumn(ExpenseCategory attribute) {
        List<String> result = new ArrayList<>();
        return result;
    }

    @Override
    public ExpenseCategory convertToEntityAttribute(List<String> dbData) {
        return null;
    }
}
