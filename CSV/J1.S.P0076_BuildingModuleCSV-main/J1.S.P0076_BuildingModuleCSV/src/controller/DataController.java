package controller;

import java.util.ArrayList;
import java.util.List;
import model.Data;
import repository.DataRepository;
import view.Menu;

public class DataController extends Menu {

    protected static String[] mc = {"Import CSV", "Format Address", "Format Name", "Export CSV", "Exit"};
    protected DataRepository repo;
    protected List<Data> datas;

    public DataController() {
        super("========== Format CSV Program =========", mc);
        repo = new DataRepository();
        datas = new ArrayList<Data>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                repo.importCSV(datas);
                break;
            }
            case 2: {
                repo.formatAddress(datas);
                break;
            }
            case 3: {
                repo.formatName(datas);
                break;
            }
            case 4: {
                repo.exportCSV(datas);
                break;
            }
            case 5: {
                System.out.println("EXIT...");
                System.exit(0);
            }
            default: {
                System.out.println("No such choice");
            }
        }
    }
}
