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
    private IProductoDAO pDAO;

    public ProductoController() {
        pDAO = new ProductoDAO();
    }
    
    private boolean camposVacios(Producto producto){
        return producto.getNombre().isBlank() || producto.getCategorias() == null || producto.getCategorias().isEmpty() || producto.getCantidad() == null || producto.getPrecio() == null || producto.getDireccion() == null || producto.getProveedor() == null || producto.getActivo() == null;
    }

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
        if(camposVacios(producto)){
            throw new ControllerException("Hay campos requeridos que estan vacios, debe llenarlos");
        }
    }

    @Override
    public void actualizarProducto(Producto producto) throws ControllerException{
        if(producto.getId() == null){
            throw new ControllerException("Se necesita el id del producto que se quiere actualizar");
        }
        if(producto.getNombre().isEmpty()){
            throw new ControllerException("El nombre no debe estar vacio");
        }
        if(producto.getCategorias().isEmpty()){
            throw new ControllerException("El producto debe tener al menos 1 categoria");
        }
        if(producto.getPrecio() <= 0){
            throw new ControllerException("El producto debe tener un precio positivo");
        }
        if(camposVacios(producto)){
            throw new ControllerException("Hay campos requeridos que estan vacios, debe llenarlos");
        }
    }

    @Override
    public void eliminarProducto(ObjectId _id) throws ControllerException{
        
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

    }

    @Override
    public List<Producto> buscarTodos() {

    }
}