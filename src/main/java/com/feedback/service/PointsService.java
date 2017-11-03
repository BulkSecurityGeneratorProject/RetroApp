package com.feedback.service;

import com.feedback.domain.Points;
import com.feedback.service.dto.PointsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service Interface for managing Points.
 */
public interface PointsService {

    /**
     * Save a points.
     *
     * @param pointsDTO the entity to save
     * @return the persisted entity
     */
    PointsDTO save(PointsDTO pointsDTO);

    /**
     *  Get all the points.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PointsDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" points.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PointsDTO findOne(Long id);

    /**
     *  Delete the "id" points.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    List<PointsDTO> getPointsList(List<Points> content);

}
