/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.Library;
import common.Validation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Data;

/**
 *
 * @author Admin
 */
public class DataDao {

    private static DataDao instance = null;
    private static Validation valid = new Validation();
    private static Library lib = new Library();

    public static DataDao Instance() {
        if (instance == null) {
            synchronized (DataDao.class) {
                if (instance == null) {
                    instance = new DataDao();
                }
            }
        }
        return instance;
    }

    public void importCSV(List<Data> datas) {
        String pathname = valid.inputString("Enter path");
        try {
            datas.clear();
            BufferedReader br = new BufferedReader(new FileReader(new File(pathname)));
            String line;
            while ((line = br.readLine()) != null) {
                Data data = new Data();
                String dataCSV[] = line.trim().split(",");
                data.setId(dataCSV[0].trim());
                data.setName(dataCSV[1].trim());
                data.setEmail(dataCSV[2].trim());
                data.setPhone(dataCSV[3].trim());
                data.setAddress(dataCSV[4].trim());
                datas.add(data);
            }
            System.out.println("Import: Done");
            br.close();

        } catch (FileNotFoundException ex) {
            System.err.println("File does not exist");;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void formatAddress(List<Data> datas) {
        for (Data data : datas){
            data.setAddress(lib.normalize(data.getAddress()));
        }
        System.out.println("Format: Done");
    }

    public void formatName(List<Data> datas) {
        for (Data data : datas){
            data.setName(lib.normalize(data.getName()));
        }
        System.out.println("Format: Done");
    }

    public void exportCSV(List<Data> datas) {
        String pathname = valid.inputString("Enter path");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(pathname)));
            for (Data data : datas){
               bw.append(data.getId() + ", ");
               bw.append(data.getName() + ", ");
               bw.append(data.getEmail() + ", ");
               bw.append(data.getPhone() + ", ");
               bw.append(data.getAddress() + "\n");
            }
            System.out.println("Export: Done");
            bw.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File does not exist");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
