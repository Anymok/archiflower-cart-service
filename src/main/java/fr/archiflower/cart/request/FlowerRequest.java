package fr.archiflower.cart.request;


import fr.archiflower.cart.entity.Flower;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class FlowerRequest {
    private final RestClient restClient = RestClient.create("https://archiflower-catalog.arthur-heude.dev");

    /**
     * API Request call flower service to get flower by id
     * @param flower_id
     * @return Flower
     */
    public Flower getFlowerById(UUID flower_id) {

        return restClient.get()
                .uri("/api/flower/{id}", flower_id)
                .retrieve()
                .body(Flower.class);
    }

    /**
     * API Request call flower service to get list of flowers by id
     * @param id_list
     * @return List<Flower>
     */
    public List<Flower> getFlowersById(List<UUID> id_list) {

        return restClient.post()
                .uri("/api/flower/list")
                .body(id_list)
                .retrieve()
                .body(List.class);
    }
}
