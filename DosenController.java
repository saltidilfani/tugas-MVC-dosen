/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salti_dilfani.controller;

import salti_dilfani.model.Dosen;
import salti_dilfani.view.FormDosen;
import salti_dilfani.model.DosenDao;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salti
 */
public class DosenController {
    FormDosen formDosen;
    Dosen dosen;
    DosenDao dosenDao;
    int index;
    
    public DosenController(FormDosen formDosen)
    {
        this.formDosen = formDosen;
        dosenDao = new DosenDao();
    }
    
    public void cancel()
    {
        formDosen.getTxtNIDN().setText("");
        formDosen.getTxtNama().setText("");
        formDosen.getTxtTanggalLahir().setText("");
        isiJenisKelamin();
    }
    
    public void isiJenisKelamin()
    {
        formDosen.getCboJenisKelamin().removeAllItems();
        formDosen.getCboJenisKelamin().addItem("L");
        formDosen.getCboJenisKelamin().addItem("P");
    }
    
    public void insert()
    {
        dosen = new Dosen();
        dosen.setNidn(formDosen.getTxtNIDN().getText());
        dosen.setNama(formDosen.getTxtNama().getText());
        dosen.setJenisKelamin(formDosen.getCboJenisKelamin().getSelectedItem().toString());
        dosen.setTgllahir(formDosen.getTxtTanggalLahir().getText());
        dosenDao.insert(dosen);
        JOptionPane.showMessageDialog(formDosen, "Entry Data Ok");
    }
    
    public void getDosen(){
        int index = formDosen.getTabelDosen().getSelectedRow();
        dosen = dosenDao.getDosen(index);
        if(dosen != null){
            formDosen.getTxtNIDN().setText(dosen.getNidn());
            formDosen.getTxtNama().setText(dosen.getNama());
            formDosen.getCboJenisKelamin().setSelectedItem(dosen.getJenisKelamin());
            formDosen.getTxtTanggalLahir().setText(dosen.getTgllahir());
            
        }
    }
    
    public void viewData()
    {
        DefaultTableModel model = (DefaultTableModel)formDosen.getTabelDosen().getModel();
        model.setNumRows(0);
        List<Dosen> list = dosenDao.getAllDosen();
        for(Dosen dosen :list)
        {
            Object[] data = 
            {
                dosen.getNidn(),
                dosen.getNama(),
                dosen.getJenisKelamin(),
                dosen.getTgllahir()
            };
            model.addRow(data);
        }
    }
    
    public void update()
    {
        dosen.setNidn(formDosen.getTxtNIDN().getText());
        dosen.setNama(formDosen.getTxtNama().getText());
        dosen.setJenisKelamin(formDosen.getCboJenisKelamin().getSelectedItem().toString());
        dosen.setTgllahir(formDosen.getTxtTanggalLahir().getText());
        JOptionPane.showMessageDialog(formDosen, "Update Data OK");
    }
    
    public void delete()
        {
            dosenDao.delete(index);
            JOptionPane.showMessageDialog(formDosen, "Delete Data Ok");
        }
}
