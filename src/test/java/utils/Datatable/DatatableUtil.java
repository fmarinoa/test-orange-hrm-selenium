package utils.Datatable;

import io.cucumber.datatable.DataTable;

public class DatatableUtil {

    public static String getValueFromTable(DataTable dataTable, String key) {
        if (dataTable == null || dataTable.isEmpty()) {
            throw new IllegalArgumentException("The provided DataTable is null or empty.");
        }
        return dataTable.asMaps(String.class, String.class).get(0).getOrDefault(key, null);
    }
}

