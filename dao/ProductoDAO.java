/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import models.Producto;
import org.bson.types.ObjectId;

/**
 *
 * @author David TL
 */
public class ProductoDAO implements IProductoDAO{
 private final MongoCollection<Producto> col;    

    public ProductoDAO(MongoCollection<Producto> col) {
        this.col = col;
    }

    @Override
    public void guardarProducto(Producto producto) {
            try {
            if (producto.getId()== null) producto.setId(new ObjectId());
            producto.setFechaRegistro(Instant.now());
            col.insertOne(producto);
            
        } catch (MongoException e) {
                System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void editar(Producto producto) {
                try {
            var result = col.updateOne(
                Filters.eq("_id", producto.getId()),
                Updates.combine(
                    Updates.set("nombre", producto.getNombre()),
                     Updates.set("categoria", producto.getCategoria()),
                    Updates.set("cantidad", producto.getCantidad()),
                     Updates.set("precio", producto.getPrecio()),
                      Updates.set("direccion", producto.getDirecciones()),
                       Updates.set("proveedor", producto.getProveedores()),
                        Updates.set("activo", producto.isActivo()),
                    Updates.set("fechaRegistro", producto.getFechaRegistro())
                )
            );
            if (result.getMatchedCount() == 0)
                        System.out.println("No existe el usuario");
        
        } catch (MongoException e) {
                System.out.println(e.getMessage());
        }
    }
 
    @Override
    public void eliminar(ObjectId _id) {
        try {
            var result = col.deleteOne(Filters.eq("_id", _id));
            if (result.getDeletedCount() == 0) {
                System.out.println("No existe el usuario");
            }
        } catch (MongoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Producto> listar() {
            try {
            List<Producto> lista = (List<Producto>) col.find();
            return lista;
        } catch (MongoException e) {
                        System.out.println(e.getMessage());
                        return null;
        }
    }
    

    @Override
    public Producto buscarPorNombre(String nombre) {
        try {
            return col.find(Filters.eq("nombre", nombre)).first();
        } catch (MongoException e) {
            return null;
        }
    
    }
    
}
