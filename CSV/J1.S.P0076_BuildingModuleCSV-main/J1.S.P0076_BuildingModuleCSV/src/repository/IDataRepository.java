/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.Data;

/**
 *
 * @author Admin
 */
public interface IDataRepository {

    void exportCSV(List<Data> datas);

    void formatAddress(List<Data> datas);

    void formatName(List<Data> datas);

    void importCSV(List<Data> datas);
    
}
