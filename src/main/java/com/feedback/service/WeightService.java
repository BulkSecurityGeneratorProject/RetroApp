package com.feedback.service;

import com.feedback.service.dto.WeightDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Weight.
 */
public interface WeightService {

    /**
     * Save a weight.
     *
     * @param weightDTO the entity to save
     * @return the persisted entity
     */
    WeightDTO save(WeightDTO weightDTO);

    /**
     *  Get all the weights.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<WeightDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" weight.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    WeightDTO findOne(Long id);

    /**
     *  Delete the "id" weight.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
