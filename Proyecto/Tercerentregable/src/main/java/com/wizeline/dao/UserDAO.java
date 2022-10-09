package com.wizeline.dao;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.wizeline.entidad.UsuarioEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {
    /* Uso de MongoTemplate */
    @Autowired
    private MongoTemplate mongoTemplate;

    public UsuarioEntidad crearUsuario(UsuarioEntidad usuarioEntidad){
        /* Escritura en MongoDB usando MongoTemplate: mongoTemplate.save() */
        return mongoTemplate.save(usuarioEntidad);
    }

    public List<UsuarioEntidad> obtenerUsuarios(){
        /* Lectura de MongoDB usando MongoTemplate: mongoTemplate.findAll() */
        List<UsuarioEntidad> usuarios = mongoTemplate.findAll(UsuarioEntidad.class);
        return usuarios;
    }

    public long cambiarContrasenia(String idUsuario, String nuevaContrasenia) {
        int identificador = Integer.parseInt(idUsuario);
        Query query = new Query().addCriteria(Criteria.where("_id").is(identificador));
        Update update = new Update().set("contrasenia", nuevaContrasenia);

        /* Actualización en MongoDB usando MongoTemplate: mongoTemplate.updateFirst() */
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, UsuarioEntidad.class);

        return updateResult.getModifiedCount();
    }

    public UsuarioEntidad obtenerUsuario(String idUsuario) {
        int identificador = Integer.parseInt(idUsuario);
        /* Lectura de MongoDB usando MongoTemplate: mongoTemplate.findOne() */
        Query query = new Query().addCriteria(Criteria.where("id").in(identificador));
        UsuarioEntidad usuario = mongoTemplate.findOne(query, UsuarioEntidad.class);

        return usuario;
    }

    public long borrarUsuario(String idUsuario) {

        int identificador = Integer.parseInt(idUsuario);
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(identificador));

        /* Borrado en MongoDB usando MongoTemplate: mongoTemplate.remove() */
        DeleteResult result = mongoTemplate.remove(query, UsuarioEntidad.class);

        return result.getDeletedCount();
    }

    public UsuarioEntidad login(String usuario, String contrasenia) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("nombre").is(usuario),
                Criteria.where("contrasenia").is(contrasenia)
        );

        Query query = new Query(criteria);

        UsuarioEntidad res = mongoTemplate.findOne(query, UsuarioEntidad.class);

        return res;
    }
}
