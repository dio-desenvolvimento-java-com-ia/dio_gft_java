package org.example.Tratamento_de_Exception_e_Debug.DAO;

import org.example.Tratamento_de_Exception_e_Debug.exceptions.UserNotFoundException;
import org.example.Tratamento_de_Exception_e_Debug.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class  UserDAO {

    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model){
        UserModel toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public UserModel findById(final long id){
        String message = "Não existe usuário com o ID %d cadastrado".formatted(id);
        return models.stream()
                .filter(user -> user.getId() == id).
                findFirst()
                .orElseThrow(()-> new UserNotFoundException(message));
    }

    public void delete(final long id){
        UserModel toDelete = findById(id);
        models.remove(toDelete);
    }

    public List<UserModel> findAll(){
        return models;
    }

}
