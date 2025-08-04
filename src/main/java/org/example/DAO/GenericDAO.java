package org.example.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/*
    Vamos pensar em banco de dados onde teremos várias tabelas.
    Esse DAO vai nos possibilitar ter acesso a elas

    - <ID, T extends GenericDomain<ID>>:

    * Com isso, eu delimito que o DAO recebera dois tipos genericos: ID e T.
      Onde ID é livre, mas o segundo parametro deve extender de GenericDomain,
      cujo o tipo é ID


 */
public abstract class GenericDAO<ID, T extends GenericDomain<ID>>  {

    private final List<T> db = new ArrayList<>();

    public T save(T domain){
        db.add(domain);
        return domain;
    }

    public T update(ID id, T domain){
        T stored = db.stream().filter(d -> d.getId().equals(id))
                .findFirst().orElseThrow();
        db.remove(stored);
        return save(domain);
    }

    public boolean delete(T domain){
        return db.remove(domain);
    }

    public Optional<T> find(Predicate<T> filterCallBack){
        return db.stream().filter(filterCallBack).findFirst();
    }

    public List<T> findAll(){
        return db;
    }

    public int count(){
        return db.size();
    }

}
