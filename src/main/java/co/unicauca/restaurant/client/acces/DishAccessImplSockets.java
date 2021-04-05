package co.unicauca.restaurant.client.acces;

import co.unicauca.restaurant.commons.infra.Protocol;
import co.unicauca.restaurant.commons.domain.Dish;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.client.infra.RestaurantSocket;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Servicio de Platos. Permite hacer el CRUD de platos solicitando los
 *servicios con la aplicación server. Maneja los errores devueltos
 * @author HP
 */
public class DishAccessImplSockets implements IDishAccess{
    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private RestaurantSocket mySocket;

    public DishAccessImplSockets() {
        mySocket = new RestaurantSocket();
    }

    /**
     * Busca un plato. Utiliza socket para pedir el servicio al servidor
     *
     * @param id identificador del plato
     * @return Objeto Dish
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Dish find(int id) throws Exception {
        String jsonResponse = null;
        String requestJson = findDishRequestJson(id); //solicitud
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);// envia solicitud
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el plato
                Dish plate = jsonToDish(jsonResponse); //convierte jsonToDish a java(plate)
                return plate;
            }
        }

    }

    /**
     * Crea un  Dish. Utiliza socket para pedir el servicio al servidor
     *
     * @param plate plato especial del restaurante
     * @return devuelve el identificador del plato creado
     * @throws Exception error crear el plato especial
     */
    @Override
    public String save(Dish plate) throws Exception {
        String jsonResponse = null;
        String requestJson = createDishRequestJson(plate);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve el identificador del plato 
                return String.valueOf(plate.getDishID());
            }

        }

    }
    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param idDish identificador del plato
     * @return solicitud de consulta del plato en formato Json, algo como:
     * {"resource":"plate","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String findDishRequestJson(int idDish) {

        Protocol protocol = new Protocol();
        protocol.setResource("plate");
        protocol.setAction("get");
        protocol.addParameter("id", String.valueOf(idDish));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del plato para ser enviado por el
     * socket
     *
     * @param plate objeto Dish
     * @return devuelve algo como:
     * {"resource":"plate","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"Name","value":"Camarones"},...}]}
     */
    private String createDishRequestJson(Dish plate) {

        Protocol protocol = new Protocol();
        protocol.setResource("plate");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(plate.getDishID()));
        protocol.addParameter("Name", plate.getDishName());
        protocol.addParameter("Description", plate.getDishDescription());
        protocol.addParameter("price", String.valueOf(plate.getDishPrice()));
        protocol.addParameterIcon("email", plate.getDishImage());
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Convierte jsonDish, proveniente del server socket, de json a un
     * objeto Dish
     *
     * @param jsonDish objeto plato en formato json
     */
    private Dish jsonToDish(String jsonDish) {

        Gson gson = new Gson();
        Dish plate = gson.fromJson(jsonDish, Dish.class);

        return plate;

    }

    @Override
    public boolean update(Dish newDish) throws Exception {
        Boolean encontrado=false;
        String jsonResponse = null;
        String requestJson = createDishRequestJson(newDish); //solicitud
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);// envia solicitud
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(DishAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el plato
                Dish plate = jsonToDish(jsonResponse); //convierte jsonToDish a java(plate)
                encontrado=true;
                return encontrado;
            }
        }
    }

    @Override
    public List<Dish> list() throws Exception {
        //falta implementar
        List<Dish> plates = new ArrayList<>();
        return plates;
    }
}
