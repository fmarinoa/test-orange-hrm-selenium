package utils.Datatable;

import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class DatatableUtilTest {

    @Test
    void shouldThrowExceptionForNullDataTable() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            DatatableUtil.getValueFromTable(null, "username");
        }, "The provided DataTable is null or empty.");
    }

    @Test
    void shouldThrowExceptionForEmptyDataTable() {
        List<List<String>> emptyData = Arrays.asList();
        DataTable dataTable = DataTable.create(emptyData);

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            DatatableUtil.getValueFromTable(dataTable, "username");
        }, "The provided DataTable is null or empty.");
    }
}

