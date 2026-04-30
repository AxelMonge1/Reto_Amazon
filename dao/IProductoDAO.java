/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import models.Producto;
import org.bson.types.ObjectId;

/**
 *
 * @author David TL
 */
public interface IProductoDAO {
    void guardarProducto (Producto producto);
    void editar (Producto producto);
    void eliminar (ObjectId _id);
    List<Producto> listar ();
    Producto buscarPorNombre (String nombre); 
    
}
