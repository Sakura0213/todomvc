import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Module {
    private List<String> fields;

    public Module(List<String> fields) {
        this.fields = fields;
    }

    public List<String> getFields() {
        return fields;
    }
}

class Worksheet {
    private List<String> columns;

    public Worksheet(List<String> columns) {
        this.columns = columns;
    }

    public List<String> getColumns() {
        return columns;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Module> modules = new ArrayList<>();
        List<Worksheet> worksheets = new ArrayList<>();

        // 添加模块到模块集合
        List<String> moduleFields1 = new ArrayList<>();
        moduleFields1.add("Field1");
        moduleFields1.add("Field2");
        Module module1 = new Module(moduleFields1);
        modules.add(module1);

        List<String> moduleFields2 = new ArrayList<>();
        moduleFields2.add("Field3");
        moduleFields2.add("Field4");
        Module module2 = new Module(moduleFields2);
        modules.add(module2);

        // 添加工作表到工作表集合
        List<String> worksheetColumns1 = new ArrayList<>();
        worksheetColumns1.add("Field1");
        worksheetColumns1.add("Field2");
        Worksheet worksheet1 = new Worksheet(worksheetColumns1);
        worksheets.add(worksheet1);

        List<String> worksheetColumns2 = new ArrayList<>();
        worksheetColumns2.add("Field2");
        worksheetColumns2.add("Field3");
        Worksheet worksheet2 = new Worksheet(worksheetColumns2);
        worksheets.add(worksheet2);

        // 匹配模块集合和工作表集合
        List<Worksheet> matchedWorksheets = new ArrayList<>();
        for (Worksheet worksheet : worksheets) {
            for (Module module : modules) {
                List<String> worksheetColumns = worksheet.getColumns();
                List<String> moduleFields = module.getFields();
                boolean isMatched = true;
                for (String column : worksheetColumns) {
                    if (!moduleFields.contains(column)) {
                        isMatched = false;
                        break;
                    }
                }
                if (isMatched) {
                    matchedWorksheets.add(worksheet);
                    break;
                }
            }
        }

        // 输出匹配到的工作表和字段
        for (Worksheet worksheet : matchedWorksheets) {
            System.out.println("Matched Worksheet: " + worksheet.getColumns());
        }
    }
}