/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import excepciones.ControllerException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LABORATORIOS
 */
public class ProductoController implements IProductoController{

    @Override
    public void agregarProducto(Producto producto) throws ControllerException{
        if(producto.getNombre().isEmpty()){
            throw new ControllerException("El nombre no debe estar vacio");
        }
        if(producto.getCategorias().isEmpty()){
            throw new ControllerException("El producto debe tener al menos 1 categoria");
        }
        if(producto.getPrecio() <= 0){
            throw new ControllerException("El producto debe tener un precio positivo");
        }
        
    }

    @Override
    public void actualizarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProducto(ObjectId _id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel obtenerTabla() {
        String[] columnas = {"ID", "NOMBRE", "CANTIDAD", "PRECIO", "PROVEEDOR"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        //List<Producto> lista = metodo del dao
        lista.forEach(p -> modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getCantidad(), p.getPrecio(), p.getProveedor().getNombre()}));
        return modelo;
    }

    @Override
    public Producto buscarProducto(ObjectId _id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}