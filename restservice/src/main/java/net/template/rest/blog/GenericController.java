package net.template.rest.blog;

import lombok.extern.slf4j.Slf4j;
import net.template.data.base.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prayoon-pc on 4/12/2017.
 */
@Slf4j
public abstract class GenericController<T> {

    @Autowired
    private GenericService<T> service;

    private String className;
    private Class<T> clazz;

    public GenericController(GenericService<T> service) {
        try {
            this.service = service;
            Type t = getClass().getGenericSuperclass();
            ParameterizedType pt = (ParameterizedType) t;
            this.clazz = (Class) pt.getActualTypeArguments()[0];
            this.className = this.clazz.getName();
        } catch (Exception e) {
            log.error("{}", e);
        }
    }


    @RequestMapping(value = "/findAll/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<T>> getAllUser() {
        List<T> results = new ArrayList<T>();
        try {
            System.out.println("Fetching All " + this.className);
            results = service.findAll();
            if (results == null || results.size() == 0) {
                System.out.println(this.className + " not found");
                return new ResponseEntity<List<T>>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("{}", e);
        }
        return new ResponseEntity<List<T>>(results, HttpStatus.OK);
    }


    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> getById(@PathVariable("id") long id) {
        T t = null;
        try {
            System.out.println("Fetching with id " + id);
            t = (T) service.findById(id);
            if (t == null) {
                System.out.println(this.className + " with id " + id + " not found");
                return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("{}", e);
        }
        return new ResponseEntity<T>(t, HttpStatus.OK);
    }
}
