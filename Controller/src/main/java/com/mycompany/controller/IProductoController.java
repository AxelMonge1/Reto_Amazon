/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.controller;

import excepciones.ControllerException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LABORATORIOS
 */
public interface IProductoController {
    void agregarProducto(Producto producto) throws ControllerException;
    void actualizarProducto(Producto producto) throws ControllerException;
    void eliminarProducto(ObjectId _id) throws ControllerException;
    DefaultTableModel obtenerTabla() throws ControllerException;
    Producto buscarProducto(ObjectId _id) throws ControllerException;
    List<Producto> buscarTodos() throws ControllerException;
}
