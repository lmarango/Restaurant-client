package co.unicauca.restaurant.client.acces;

import co.unicauca.restaurant.commons.domain.Dish;
import java.util.List;

/**
 *Interface que define los servicios de persistencia de platos del restaurante
 * @author HP
 */
public interface IDishAccess {
    /**
     * Guarda un nuevo Plato(Dish) 
     * @param newDish objeto de tipo Dish 
     * @return  booleano confirmando si la actualización fue exitosa o no.
     * @throws java.lang.Exception
     */
    public String save(Dish newDish) throws Exception;;
    /**
     * Actualiza un Plato(Dish) 
     * @param newDish objeto de tipo Dish 
     * @return  booleano confirmando si la actualización fue exitosa o no.
     * @throws java.lang.Exception
     */
    public boolean update(Dish newDish) throws Exception;;
    /**
     * Busca un Plato(Dish) por su codigo
     * @param id identificador del plato
     * @return  objeto de tipo Dish 
     * @throws java.lang.Exception 
     */
    public Dish find(int id) throws Exception;
    /**
     * Lista los Platos(Dish)
     * @return lista de Dish(platos) 
     * @throws java.lang.Exception 
     */
    public List<Dish> list()throws Exception;
}
